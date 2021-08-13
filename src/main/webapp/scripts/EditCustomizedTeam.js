var CURRENT_TEAM_KEY = 'current_team';
var CACHED_PLAYERS_KEY = 'cached_players';
var SELECTED_PLAYER_IDS_KEY = 'selected_players';

var APP_STORAGE = {
  current_team: {},
  cached_players: new Map(),
  selected_players: []
};

function deepCopy(object) {
  return JSON.parse(JSON.stringify(object));
}

function makeRequest(method, url, payload) {
  return new Promise(function (resolve, reject) {
    let xhr = new XMLHttpRequest();
    xhr.open(method, url);
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.onload = function () {
      if (this.status >= 200 && this.status < 300) {
        resolve(JSON.parse(xhr.response));
      } else {
        reject({
          status: this.status,
          statusText: xhr.statusText
        });
      }
    };
    xhr.onerror = function () {
      reject({
        status: this.status,
        statusText: xhr.statusText
      });
    };
    xhr.send(JSON.stringify(payload));
  });
}

function isNumeric(str) {
  if (typeof str != "string") return false;
  return !isNaN(str) && !isNaN(parseFloat(str));
}

function loadCustomizedTeamById(teamId) {
  return makeRequest('GET', 'http://localhost:8080/UltimateSoccerSquadBuilder/customized-team/' + teamId);
}

function updateCustomizedTeam(team) {
  return makeRequest('POST', 'http://localhost:8080/UltimateSoccerSquadBuilder/customized-team', team);
}

function searchPlayerByQueryTerms(queryTerms) {
  return makeRequest('POST', 'http://localhost:8080/UltimateSoccerSquadBuilder/search-player', queryTerms);
}

function setupButtonClickEventHandler() {
  // all player select listener
  $('.select-player').on('change', function (data) {
    const newPlayerId = parseInt(data.currentTarget.value);
    const selectIndex = parseInt(data.currentTarget.id.match(/select-player-(.*)/)[1]);
    console.log("Selecting new player - select index:", selectIndex, "new playerId:", newPlayerId);

    APP_STORAGE[SELECTED_PLAYER_IDS_KEY][selectIndex - 1] = newPlayerId;
  });

  // update button
  $("#update-customized-team-button").click(function () {

    $(this).attr("disabled", true);

    [...Array(11).keys()].forEach(index => {
      const playerId = APP_STORAGE[SELECTED_PLAYER_IDS_KEY][index];
      APP_STORAGE[CURRENT_TEAM_KEY]['p'.concat(index + 1)] = { player_id: playerId };
    });

    updateCustomizedTeam(APP_STORAGE[CURRENT_TEAM_KEY])
      .then(result => {
        console.log("Updated selection: " + result);
      }).then(() => {
        $('#update-customized-team-alert').text('Your squad has been updated.');
        $('#update-customized-team-alert').fadeIn(500).delay(1500).fadeOut(500);
      }).then(() => {
        $(this).removeAttr("disabled");
      });
  });

  // search button
  $("#search-players-button").click(function () {
    const rawQuery = $('#search-query-input').val();
    const payload = {
      terms: rawQuery.trim().split(/\s+/)
    };

    $(this).attr("disabled", true);
    searchPlayerByQueryTerms(payload)
      .then(newPlayers => {
        console.log("Queried players: " + newPlayers);
        newPlayers.forEach(player => APP_STORAGE[CACHED_PLAYERS_KEY].set(player.player_id, player));
      }).then(() => {
        $('#update-customized-team-alert').text('Your Available Player List has been updated.');
        $('#update-customized-team-alert').fadeIn(500).delay(1500).fadeOut(500);
      }).then(() => {
        $(this).removeAttr("disabled");
      }).then(() => {
        renderTeamPlayers();
        renderAvailablePlayers();
      });
  });

  // clear result button
  $("#clear-players-result-button").click(function () {
    const selectedPlayerIdSet = new Set(APP_STORAGE[SELECTED_PLAYER_IDS_KEY]);
    const cachedPlayerIds = [...APP_STORAGE[CACHED_PLAYERS_KEY].values()].map(player => player.player_id);
    cachedPlayerIds.forEach(playerId => {
      if (!selectedPlayerIdSet.has(playerId)) APP_STORAGE[CACHED_PLAYERS_KEY].delete(playerId);
    });
    renderAvailablePlayers();
    $('#update-customized-team-alert').text('Your Available Player List has been cleaned.');
    $('#update-customized-team-alert').fadeIn(500).delay(1500).fadeOut(500);
  });
}

function renderAvailablePlayers() {
  // render avaialble players
  const cachedPlayers = deepCopy([...APP_STORAGE[CACHED_PLAYERS_KEY].values()])
    .sort((a, b) => a.player_name.localeCompare(b.player_name));

  $('#available-player-table tbody tr').remove();

  cachedPlayers.forEach((player) => {
    let newRow = '<tr>';
    newRow += '<td>' + player.player_name + '</td>';
    newRow += '<td>' + player.best_position + '</td>';
    newRow += '<td>' + player.potential_rating + '</td>';
    newRow += '<td>' + player.best_overall_rating + '</td>';
    newRow += '</tr>';
    $('#available-player-table tbody').append(newRow);
  });
}

function renderTeamPlayers() {
  // render selected players
  const selectedPlayerIds = deepCopy(APP_STORAGE[SELECTED_PLAYER_IDS_KEY]);
  const cachedPlayers = deepCopy([...APP_STORAGE[CACHED_PLAYERS_KEY].values()])
    .sort((a, b) => a.player_name.localeCompare(b.player_name));

  [...Array(11).keys()].forEach(index => {
    const $selectPlayerElement = $('#select-player-'.concat(index + 1));
    $selectPlayerElement.empty();

    cachedPlayers.forEach((player) => {
      const $newOption = $("<option></option>").attr("value", player.player_id).text(player.player_name);
      $selectPlayerElement.append($newOption);
    });

    $selectPlayerElement.val(selectedPlayerIds[index]).prop('selected', true);
  });
}

function initialize() {
  const rawQueryParam = window.location.search;
  const teamId = rawQueryParam.match(/customizedTeamId=(.*)/)[1];
  console.log("Initializing team with id: " + teamId);
  loadCustomizedTeamById(teamId).then(team => {
    APP_STORAGE[CURRENT_TEAM_KEY] = deepCopy(team);

    // store all selected players into cached players
    APP_STORAGE[SELECTED_PLAYER_IDS_KEY] = [];
    [...Array(11).keys()].map(i => ++i).forEach(positionId => {
      APP_STORAGE[SELECTED_PLAYER_IDS_KEY].push(team['p'.concat(positionId)].player_id);
    });

    // store all selected players into cached players
    [...Array(11).keys()].map(i => ++i).forEach(positionId => {
      const tempPlayer = deepCopy(team['p'.concat(positionId)]);
      APP_STORAGE[CACHED_PLAYERS_KEY].set(tempPlayer.player_id, tempPlayer);
    });
  }).then(() => {
    renderTeamPlayers();
    renderAvailablePlayers();
    setupButtonClickEventHandler();
  });
}

initialize();

