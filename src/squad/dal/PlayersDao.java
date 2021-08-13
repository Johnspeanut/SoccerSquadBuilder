package squad.dal;

import squad.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayersDao {
	protected ConnectionManager connectionManager;

	private static PlayersDao instance = null;
	protected PlayersDao() {
		connectionManager = new ConnectionManager();
	}
	public static PlayersDao getInstance() {
		if(instance == null) {
			instance = new PlayersDao();
		}
		return instance;
	}

	
	public Player getPlayerByPlayerId(int playerId) throws SQLException {
		String selectPlayer =
			"SELECT * " +
			"FROM tbl_player " +
			"WHERE int_player_id=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPlayer);
			selectStmt.setInt(1, playerId);
			results = selectStmt.executeQuery();
			TeamDao teamDao = TeamDao.getInstance();
			if(results.next()) {
				int resultPlayerId = results.getInt("int_player_id");
				String player_name = results.getString("str_player_name");
				String positions = results.getString("str_positions");
				Date dob = new Date(results.getTimestamp("dt_date_of_birth").getTime());
				int height = results.getInt("int_height");
				int weight = results.getInt("int_weight");
				int overall_rating = results.getInt("int_overall_rating");
				int potential_rating = results.getInt("int_potential_rating");
				String best_position = results.getString("str_best_position");
				int best_overall_rating = results.getInt("int_best_overall_rating");
				int value = results.getInt("int_value");
				int wage = results.getInt("int_wage");
				String player_image_url = results.getString("str_player_image_url");
				Team team = teamDao.getTeamById(results.getInt("int_team_id"));
				String nationality = results.getString("str_nationality");
				
				Player player = new Player(resultPlayerId, player_name, positions, dob, height, weight, overall_rating, potential_rating, best_position, best_overall_rating, value, wage, player_image_url, team, nationality);
				return player;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}
	
	
	public Player getPlayerAllinfoByPlayerId(int playerId) throws SQLException {
		String selectPlayer =
			"SELECT tbl_player.int_player_id, str_player_name, str_positions, " +
		    "dt_date_of_birth, int_height, int_weight, int_overall_rating, int_potential_rating, " + 
			"str_best_position, int_best_overall_rating, int_value, int_wage, " +
		    "str_player_image_url, int_team_id, str_nationality, " +
			"(int_crossing + int_finishing + int_heading_accuracy + int_short_passing + int_volleys) / 5 as attack_score, " + 
		    "(int_defensive_awareness + int_standing_tackle + int_sliding_tackle) / 3 as defend_score, " + 
			"(int_diving + int_handling + int_kicking + int_positioning + int_reflexes) / 5 as goalkeep_score " + 
			"FROM tbl_player " +
			"inner join tbl_player_attacking " +
			"on tbl_player.int_player_id = tbl_player_attacking.int_player_id " +
			"inner join tbl_player_defending "+
			"on tbl_player.int_player_id = tbl_player_defending.int_player_id " + 
			"inner join tbl_player_goalkeeping " + 
			"on tbl_player.int_player_id = tbl_player_goalkeeping.int_player_id " + 
			"WHERE tbl_player.int_player_id = ?;";
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPlayer);
			selectStmt.setInt(1, playerId);
			results = selectStmt.executeQuery();
			TeamDao teamDao = TeamDao.getInstance();
			if(results.next()) {
				int resultPlayerId = results.getInt("int_player_id");
				String player_name = results.getString("str_player_name");
				String positions = results.getString("str_positions");
				Date dob = new Date(results.getTimestamp("dt_date_of_birth").getTime());
				int height = results.getInt("int_height");
				int weight = results.getInt("int_weight");
				int overall_rating = results.getInt("int_overall_rating");
				int potential_rating = results.getInt("int_potential_rating");
				String best_position = results.getString("str_best_position");
				int best_overall_rating = results.getInt("int_best_overall_rating");
				int value = results.getInt("int_value");
				int wage = results.getInt("int_wage");
				String player_image_url = results.getString("str_player_image_url");
				Team team = teamDao.getTeamById(results.getInt("int_team_id"));
				String nationality = results.getString("str_nationality");
				int attack_score = results.getInt("attack_score");
				int defend_score = results.getInt("defend_score");
				int goalkeep_score = results.getInt("goalkeep_score");
				
				Player player = new Player(resultPlayerId, player_name, positions, dob, height, weight, 
						overall_rating, potential_rating, best_position, best_overall_rating, value, wage, 
						player_image_url, team, nationality, attack_score, defend_score, goalkeep_score);
				return player;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}


	public List<Player> getPlayersByPlayerName(String playerName) throws SQLException {
		
		List<Player> players = new ArrayList<Player>();
		String selectPlayers =
				"SELECT * " +
				"FROM " +
				"(SELECT tbl_player.int_player_id, str_player_name, str_positions, dt_date_of_birth, int_height,int_weight,int_overall_rating, int_potential_rating,str_best_position,int_best_overall_rating,int_value,int_wage,str_player_image_url,int_team_id,str_nationality,str_url " +
				"FROM tbl_player "
				+ "left join tbl_player_urls on tbl_player.int_player_id = tbl_player_urls.int_player_id) as player_new "+
				"left join "
				+ "(select tbl_team.int_team_id as int_team_id,tbl_team.str_team_name,tbl_team_urls.str_url as team_url,tbl_team_urls.int_team_id as drop_team_id  "
				+ "from tbl_team left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id) as team_table "
				+ "on player_new.int_team_id = team_table.int_team_id "+
				"WHERE str_player_name=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPlayers);
			selectStmt.setString(1, playerName);
			results = selectStmt.executeQuery();
			TeamDao teamDao = TeamDao.getInstance();
			
			while(results.next()) {
				int resultPlayerId = results.getInt("int_player_id");
				String player_name = results.getString("str_player_name");
				String positions = results.getString("str_positions");
				Date dob = new Date(results.getTimestamp("dt_date_of_birth").getTime());
				int height = results.getInt("int_height");
				int weight = results.getInt("int_weight");
				int overall_rating = results.getInt("int_overall_rating");
				int potential_rating = results.getInt("int_potential_rating");
				String best_position = results.getString("str_best_position");
				int best_overall_rating = results.getInt("int_best_overall_rating");
				int value = results.getInt("int_value");
				int wage = results.getInt("int_wage");
				String player_image_url = results.getString("str_player_image_url");
				Team team = teamDao.getTeamById(results.getInt("int_team_id"));
				String nationality = results.getString("str_nationality");
				String profile = results.getString("str_url");
				String team_name = results.getString("str_team_name");
				String team_url = results.getString("team_url");
				
				Player player = new Player(resultPlayerId, player_name, positions, dob, height, weight, overall_rating, potential_rating, best_position, best_overall_rating, value, wage, player_image_url, team, nationality, profile,team_name,team_url);
			
				players.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return players;
	}
	
	public List<Player> getPlayersByQueryTerms(QueryTerms queryTerms) throws SQLException {
		
		List<Player> players = new ArrayList<Player>();
		String selectPlayers =
				"SELECT * " +
				"FROM " +
				"(SELECT tbl_player.int_player_id, str_player_name, str_positions, dt_date_of_birth, int_height,int_weight,int_overall_rating, int_potential_rating,str_best_position,int_best_overall_rating,int_value,int_wage,str_player_image_url,int_team_id,str_nationality,str_url " +
				"FROM tbl_player "
				+ "left join tbl_player_urls on tbl_player.int_player_id = tbl_player_urls.int_player_id) as player_new "+
				"left join "
				+ "(select tbl_team.int_team_id as int_team_id,tbl_team.str_team_name,tbl_team_urls.str_url as team_url,tbl_team_urls.int_team_id as drop_team_id  "
				+ "from tbl_team left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id) as team_table "
				+ "on player_new.int_team_id = team_table.int_team_id "+
				"WHERE LOWER(str_player_name) LIKE ?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPlayers);
			selectStmt.setString(1, String.format("%%%s%%", queryTerms.getTerms().get(0)));
			results = selectStmt.executeQuery();
			TeamDao teamDao = TeamDao.getInstance();
			
			while(results.next()) {
				int resultPlayerId = results.getInt("int_player_id");
				String player_name = results.getString("str_player_name");
				String positions = results.getString("str_positions");
				Date dob = new Date(results.getTimestamp("dt_date_of_birth").getTime());
				int height = results.getInt("int_height");
				int weight = results.getInt("int_weight");
				int overall_rating = results.getInt("int_overall_rating");
				int potential_rating = results.getInt("int_potential_rating");
				String best_position = results.getString("str_best_position");
				int best_overall_rating = results.getInt("int_best_overall_rating");
				int value = results.getInt("int_value");
				int wage = results.getInt("int_wage");
				String player_image_url = results.getString("str_player_image_url");
				Team team = teamDao.getTeamById(results.getInt("int_team_id"));
				String nationality = results.getString("str_nationality");
				String profile = results.getString("str_url");
				String team_name = results.getString("str_team_name");
				String team_url = results.getString("team_url");
				
				Player player = new Player(resultPlayerId, player_name, positions, dob, height, weight, overall_rating, potential_rating, best_position, best_overall_rating, value, wage, player_image_url, team, nationality, profile,team_name,team_url);
			
				players.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return players;
	}
	
	
	
	public List<Player> getAllPlayers() throws SQLException {
			
			List<Player> players = new ArrayList<Player>();
			String selectPlayers =
					"SELECT * " +
					"FROM " +
					"(SELECT tbl_player.int_player_id as int_player_id, str_player_name, str_positions, dt_date_of_birth, int_height,int_weight,int_overall_rating, int_potential_rating,str_best_position,int_best_overall_rating,int_value,int_wage,str_player_image_url,int_team_id,str_nationality,str_url,tbl_player_urls.int_player_id as drop_player_id " +
					"FROM tbl_player "
					+ "left join tbl_player_urls on tbl_player.int_player_id = tbl_player_urls.int_player_id) as player_new "+
					"left join "
					+ "(select tbl_team.int_team_id,tbl_team.str_team_name,tbl_team_urls.str_url as team_url "
					+ "from tbl_team left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id) as team_table "
					+ "on player_new.int_team_id = team_table.int_team_id "+
					"LIMIT 100;";
			Connection connection = null;
			PreparedStatement selectStmt = null;
			ResultSet results = null;
			try {
				connection = connectionManager.getConnection();
				selectStmt = connection.prepareStatement(selectPlayers);
				results = selectStmt.executeQuery();
				TeamDao teamDao = TeamDao.getInstance();
				
				while(results.next()) {
					int resultPlayerId = results.getInt("int_player_id");
					String player_name = results.getString("str_player_name");
					String positions = results.getString("str_positions");
					Date dob = new Date(results.getTimestamp("dt_date_of_birth").getTime());
					int height = results.getInt("int_height");
					int weight = results.getInt("int_weight");
					int overall_rating = results.getInt("int_overall_rating");
					int potential_rating = results.getInt("int_potential_rating");
					String best_position = results.getString("str_best_position");
					int best_overall_rating = results.getInt("int_best_overall_rating");
					int value = results.getInt("int_value");
					int wage = results.getInt("int_wage");
					String player_image_url = results.getString("str_player_image_url");
					Team team = teamDao.getTeamById(results.getInt("int_team_id"));
					String nationality = results.getString("str_nationality");
					String profile = results.getString("str_url");
					String team_name = results.getString("str_team_name");
					String team_url = results.getString("team_url");
					
					Player player = new Player(resultPlayerId, player_name, positions, dob, height, weight, overall_rating, potential_rating, best_position, best_overall_rating, value, wage, player_image_url, team, nationality, profile,team_name,team_url);
				
					players.add(player);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				if(connection != null) {
					connection.close();
				}
				if(selectStmt != null) {
					selectStmt.close();
				}
				if(results != null) {
					results.close();
				}
			}
			return players;
		}
	
	
	
	public List<Player> getPlayersOrderBy(String orderby) throws SQLException {
		
		List<Player> players = new ArrayList<Player>();
		String selectPlayers = "";
		
		switch(orderby) {
		case "name": 
			selectPlayers =
					"SELECT * " +
					"FROM " +
					"(SELECT tbl_player.int_player_id, str_player_name, str_positions, dt_date_of_birth, int_height,int_weight,int_overall_rating, int_potential_rating,str_best_position,int_best_overall_rating,int_value,int_wage,str_player_image_url,int_team_id,str_nationality,str_url " +
					"FROM tbl_player "
					+ "left join tbl_player_urls on tbl_player.int_player_id = tbl_player_urls.int_player_id) as player_new "+
					"left join "
					+ "(select tbl_team.int_team_id,tbl_team.str_team_name,tbl_team_urls.str_url as team_url "
					+ "from tbl_team left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id) as team_table "
					+ "on player_new.int_team_id = team_table.int_team_id "+
					"ORDER BY str_player_name asc " +
					"LIMIT 100;";
			break;
		case "age":
			selectPlayers =
					"SELECT * " +
					"FROM " +
					"(SELECT tbl_player.int_player_id, str_player_name, str_positions, dt_date_of_birth, int_height,int_weight,int_overall_rating, int_potential_rating,str_best_position,int_best_overall_rating,int_value,int_wage,str_player_image_url,int_team_id,str_nationality,str_url " +
					"FROM tbl_player "
					+ "left join tbl_player_urls on tbl_player.int_player_id = tbl_player_urls.int_player_id) as player_new "+
					"left join "
					+ "(select tbl_team.int_team_id,tbl_team.str_team_name,tbl_team_urls.str_url as team_url "
					+ "from tbl_team left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id) as team_table "
					+ "on player_new.int_team_id = team_table.int_team_id "+
					"ORDER BY dt_date_of_birth asc " +
					"LIMIT 100;";
			break;
		case "wage":
			selectPlayers = 
					"SELECT * " +
					"FROM " +
					"(SELECT tbl_player.int_player_id, str_player_name, str_positions, dt_date_of_birth, int_height,int_weight,int_overall_rating, int_potential_rating,str_best_position,int_best_overall_rating,int_value,int_wage,str_player_image_url,int_team_id,str_nationality,str_url " +
					"FROM tbl_player "
					+ "left join tbl_player_urls on tbl_player.int_player_id = tbl_player_urls.int_player_id) as player_new "+
					"left join "
					+ "(select tbl_team.int_team_id,tbl_team.str_team_name,tbl_team_urls.str_url as team_url "
					+ "from tbl_team left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id) as team_table "
					+ "on player_new.int_team_id = team_table.int_team_id "+
					"ORDER BY int_wage desc " +
					"LIMIT 100;";
			break;
		case "rating":
			selectPlayers = 
					"SELECT * " +
					"FROM " +
					"(SELECT tbl_player.int_player_id, str_player_name, str_positions, dt_date_of_birth, int_height,int_weight,int_overall_rating, int_potential_rating,str_best_position,int_best_overall_rating,int_value,int_wage,str_player_image_url,int_team_id,str_nationality,str_url " +
					"FROM tbl_player "
					+ "left join tbl_player_urls on tbl_player.int_player_id = tbl_player_urls.int_player_id) as player_new "+
					"left join "
					+ "(select tbl_team.int_team_id,tbl_team.str_team_name,tbl_team_urls.str_url as team_url "
					+ "from tbl_team left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id) as team_table "
					+ "on player_new.int_team_id = team_table.int_team_id "+
					"ORDER BY int_overall_rating desc " +
					"LIMIT 100;";
			break;
		}
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPlayers);
			results = selectStmt.executeQuery();
			TeamDao teamDao = TeamDao.getInstance();
			
			while(results.next()) {
				int resultPlayerId = results.getInt("int_player_id");
				String player_name = results.getString("str_player_name");
				String positions = results.getString("str_positions");
				Date dob = new Date(results.getTimestamp("dt_date_of_birth").getTime());
				int height = results.getInt("int_height");
				int weight = results.getInt("int_weight");
				int overall_rating = results.getInt("int_overall_rating");
				int potential_rating = results.getInt("int_potential_rating");
				String best_position = results.getString("str_best_position");
				int best_overall_rating = results.getInt("int_best_overall_rating");
				int value = results.getInt("int_value");
				int wage = results.getInt("int_wage");
				String player_image_url = results.getString("str_player_image_url");
				Team team = teamDao.getTeamById(results.getInt("int_team_id"));
				String nationality = results.getString("str_nationality");
				String profile = results.getString("str_url");
				String team_name = results.getString("str_team_name");
				String team_url = results.getString("team_url");
				
				Player player = new Player(resultPlayerId, player_name, positions, dob, height, weight, overall_rating, potential_rating, best_position, best_overall_rating, value, wage, player_image_url, team, nationality, profile,team_name,team_url);
			
				players.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return players;
	}
	
	public List<Player> getPlayersByPopularSearch(String popularsearch) throws SQLException {
		
		List<Player> players = new ArrayList<Player>();
		String selectPlayers = "";
		
		switch(popularsearch) {
		case "top20forwards": 
			selectPlayers =
					"SELECT * " +
					"FROM " +
					"(SELECT tbl_player.int_player_id, str_player_name, str_positions, dt_date_of_birth, int_height,int_weight,int_overall_rating, int_potential_rating,str_best_position,int_best_overall_rating,int_value,int_wage,str_player_image_url,int_team_id,str_nationality,str_url " +
					"FROM tbl_player "
					+ "left join tbl_player_urls on tbl_player.int_player_id = tbl_player_urls.int_player_id) as player_new "+
					"left join "
					+ "(select tbl_team.int_team_id,tbl_team.str_team_name,tbl_team_urls.str_url as team_url "
					+ "from tbl_team left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id) as team_table "
					+ "on player_new.int_team_id = team_table.int_team_id "
					+ "where str_best_position in ('CF', 'LF', 'ST', 'LW', 'RW' ) "
					+ "order by int_overall_rating desc "
					+ "limit 20;";
			break;
		case "top20midfields":
			selectPlayers = 
					"SELECT * " +
					"FROM " +
					"(SELECT tbl_player.int_player_id, str_player_name, str_positions, dt_date_of_birth, int_height,int_weight,int_overall_rating, int_potential_rating,str_best_position,int_best_overall_rating,int_value,int_wage,str_player_image_url,int_team_id,str_nationality,str_url " +
					"FROM tbl_player "
					+ "left join tbl_player_urls on tbl_player.int_player_id = tbl_player_urls.int_player_id) as player_new "+
					"left join "
					+ "(select tbl_team.int_team_id,tbl_team.str_team_name,tbl_team_urls.str_url as team_url "
					+ "from tbl_team left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id) as team_table "
					+ "on player_new.int_team_id = team_table.int_team_id "
					+ "where str_best_position in ('LAM', 'CAM', 'RAM', 'LM', 'CM', 'RM', 'CDM') "
					+ "order by int_overall_rating desc "
					+ "limit 20;";
			break;
		case "top20defenders":
			selectPlayers =
					"SELECT * " +
					"FROM " +
					"(SELECT tbl_player.int_player_id, str_player_name, str_positions, dt_date_of_birth, int_height,int_weight,int_overall_rating, int_potential_rating,str_best_position,int_best_overall_rating,int_value,int_wage,str_player_image_url,int_team_id,str_nationality,str_url " +
					"FROM tbl_player "
					+ "left join tbl_player_urls on tbl_player.int_player_id = tbl_player_urls.int_player_id) as player_new "+
					"left join "
					+ "(select tbl_team.int_team_id,tbl_team.str_team_name,tbl_team_urls.str_url as team_url "
					+ "from tbl_team left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id) as team_table "
					+ "on player_new.int_team_id = team_table.int_team_id "
					+ "where str_best_position in ('LWB', 'RWB', 'LB', 'CB', 'RB') "
					+ "order by int_overall_rating desc "
					+ "limit 20;";
			break;
		case "top20goalkeepers":
			selectPlayers =
					"SELECT * " +
					"FROM " +
					"(SELECT tbl_player.int_player_id, str_player_name, str_positions, dt_date_of_birth, int_height,int_weight,int_overall_rating, int_potential_rating,str_best_position,int_best_overall_rating,int_value,int_wage,str_player_image_url,int_team_id,str_nationality,str_url " +
					"FROM tbl_player "
					+ "left join tbl_player_urls on tbl_player.int_player_id = tbl_player_urls.int_player_id) as player_new "+
					"left join "
					+ "(select tbl_team.int_team_id,tbl_team.str_team_name,tbl_team_urls.str_url as team_url "
					+ "from tbl_team left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id) as team_table "
					+ "on player_new.int_team_id = team_table.int_team_id "
					+ "where str_best_position in ('GK') "
					+ "order by int_overall_rating desc "
					+ "limit 20;";
			break;
		}
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPlayers);
			results = selectStmt.executeQuery();
			TeamDao teamDao = TeamDao.getInstance();
			
			while(results.next()) {
				int resultPlayerId = results.getInt("int_player_id");
				String player_name = results.getString("str_player_name");
				String positions = results.getString("str_positions");
				Date dob = new Date(results.getTimestamp("dt_date_of_birth").getTime());
				int height = results.getInt("int_height");
				int weight = results.getInt("int_weight");
				int overall_rating = results.getInt("int_overall_rating");
				int potential_rating = results.getInt("int_potential_rating");
				String best_position = results.getString("str_best_position");
				int best_overall_rating = results.getInt("int_best_overall_rating");
				int value = results.getInt("int_value");
				int wage = results.getInt("int_wage");
				String player_image_url = results.getString("str_player_image_url");
				Team team = teamDao.getTeamById(results.getInt("int_team_id"));
				String nationality = results.getString("str_nationality");
				String profile = results.getString("str_url");
				String team_name = results.getString("str_team_name");
				String team_url = results.getString("team_url");
				
				Player player = new Player(resultPlayerId, player_name, positions, dob, height, weight, overall_rating, potential_rating, best_position, best_overall_rating, value, wage, player_image_url, team, nationality, profile,team_name,team_url);
			
				players.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return players;
	}
}
