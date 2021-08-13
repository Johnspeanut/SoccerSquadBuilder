package squad.dal;

import squad.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDao {
	protected ConnectionManager connectionManager;

	private static TeamDao instance = null;
	protected TeamDao() {
		connectionManager = new ConnectionManager();
	}
	public static TeamDao getInstance() {
		if(instance == null) {
			instance = new TeamDao();
		}
		return instance;
	}

	
	public Team getTeamById(int teamId) throws SQLException {
		String selectTeam =
				"SELECT * " +
				"FROM tbl_team "
				+ "left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id " +
						"WHERE tbl_team.int_team_id=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectTeam);
			selectStmt.setInt(1, teamId);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int resultTeamId = results.getInt("int_team_id");
				String team_name = results.getString("str_team_name");
				String league = results.getString("str_league");
				int overall = results.getInt("int_overall");
				int attack = results.getInt("int_attack");
				int midfield = results.getInt("int_midfield");
				int defence = results.getInt("int_defence");
				int international_prestige = results.getInt("int_international_prestige");
				int domestic_prestige = results.getInt("int_domestic_prestige");
				int transfer_budget = results.getInt("int_transfer_budget");
				String team_url = results.getString("str_url");
				
				Team team = new Team(resultTeamId,team_name,league,overall,attack,midfield,defence,international_prestige, domestic_prestige,transfer_budget,team_url);
				return team;
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


	public List<Team> getTeamsByTeamName(String teamName) throws SQLException {
		List<Team> teams = new ArrayList<Team>();
		String selectTeams =
				"SELECT * " +
				"FROM tbl_team "
				+ "left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id " +
				"WHERE str_team_name=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectTeams);
			selectStmt.setString(1, teamName);
			results = selectStmt.executeQuery();
			
			while(results.next()) {
				int resultTeamId = results.getInt("int_team_id");
				String team_name = results.getString("str_team_name");
				String league = results.getString("str_league");
				int overall = results.getInt("int_overall");
				int attack = results.getInt("int_attack");
				int midfield = results.getInt("int_midfield");
				int defence = results.getInt("int_defence");
				int international_prestige = results.getInt("int_international_prestige");
				int domestic_prestige = results.getInt("int_domestic_prestige");
				int transfer_budget = results.getInt("int_transfer_budget");
				String team_url = results.getString("str_url");
				
				Team team = new Team(resultTeamId,team_name,league,overall,attack,midfield,defence,international_prestige, domestic_prestige,transfer_budget,team_url);
				teams.add(team);
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
		return teams;
	}
	
	
	
	
	public List<Team> getAllTeams() throws SQLException {
		List<Team> teams = new ArrayList<Team>();
		String selectTeams =
				"SELECT * " +
				"FROM tbl_team "
				+ "left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id " +
				"LIMIT 100;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectTeams);
			results = selectStmt.executeQuery();
			
			while(results.next()) {
				int resultTeamId = results.getInt("int_team_id");
				String team_name = results.getString("str_team_name");
				String league = results.getString("str_league");
				int overall = results.getInt("int_overall");
				int attack = results.getInt("int_attack");
				int midfield = results.getInt("int_midfield");
				int defence = results.getInt("int_defence");
				int international_prestige = results.getInt("int_international_prestige");
				int domestic_prestige = results.getInt("int_domestic_prestige");
				int transfer_budget = results.getInt("int_transfer_budget");
				String team_url = results.getString("str_url");
				
				Team team = new Team(resultTeamId,team_name,league,overall,attack,midfield,defence,international_prestige, domestic_prestige,transfer_budget,team_url);
				teams.add(team);
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
		return teams;
	}	
	
	
	
	
	public List<Team> getTeamsOrderBy(String orderby) throws SQLException {
		List<Team> teams = new ArrayList<Team>();
		
		String selectTeams = "";
		
		switch(orderby) {
		case "name": 
			selectTeams = 
					"SELECT * " +
					"FROM tbl_team "
					+ "left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id " +
					"ORDER BY str_team_name asc " +
					"LIMIT 100;";
			break;
		case "defence":
			selectTeams = 
					"SELECT * " +
							"FROM tbl_team "
							+ "left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id " +
					"ORDER BY int_defence desc " +
					"LIMIT 100;";
			break;
		case "attack":
			selectTeams =
					"SELECT * " +
					"FROM tbl_team "
					+ "left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id " +
					"ORDER BY int_attack desc " +
					"LIMIT 100;";
			break;
		case "score":
			selectTeams =
					"SELECT * " +
					"FROM tbl_team "
					+ "left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id " +
					"ORDER BY int_overall desc " +
					"LIMIT 100;";
			break;
		case "transferbudget":
			selectTeams =
					"SELECT * " +
					"FROM tbl_team "
					+ "left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id " +
					"ORDER BY int_transfer_budget desc " +
					"LIMIT 100;";
			break;
		}
		

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectTeams);
			results = selectStmt.executeQuery();
			
			while(results.next()) {
				int resultTeamId = results.getInt("int_team_id");
				String team_name = results.getString("str_team_name");
				String league = results.getString("str_league");
				int overall = results.getInt("int_overall");
				int attack = results.getInt("int_attack");
				int midfield = results.getInt("int_midfield");
				int defence = results.getInt("int_defence");
				int international_prestige = results.getInt("int_international_prestige");
				int domestic_prestige = results.getInt("int_domestic_prestige");
				int transfer_budget = results.getInt("int_transfer_budget");
				String team_url = results.getString("str_url");
				
				Team team = new Team(resultTeamId,team_name,league,overall,attack,midfield,defence,international_prestige, domestic_prestige,transfer_budget,team_url);
				teams.add(team);
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
		return teams;
	}	
	
	
	public List<Team> getTeamsByLeague(String league) throws SQLException {
		List<Team> teams = new ArrayList<Team>();
		String selectTeams =
				"SELECT * " +
				"FROM tbl_team "
				+ "left join tbl_team_urls on tbl_team.int_team_id = tbl_team_urls.int_team_id " +
				"WHERE str_league=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectTeams);
			selectStmt.setString(1, league);
			results = selectStmt.executeQuery();
			
			while(results.next()) {
				int resultTeamId = results.getInt("int_team_id");
				String team_name = results.getString("str_team_name");
				String resultLeague = results.getString("str_league");
				int overall = results.getInt("int_overall");
				int attack = results.getInt("int_attack");
				int midfield = results.getInt("int_midfield");
				int defence = results.getInt("int_defence");
				int international_prestige = results.getInt("int_international_prestige");
				int domestic_prestige = results.getInt("int_domestic_prestige");
				int transfer_budget = results.getInt("int_transfer_budget");
				String team_url = results.getString("str_url");
				
				Team team = new Team(resultTeamId,team_name,league,overall,attack,midfield,defence,international_prestige, domestic_prestige,transfer_budget,team_url);
				teams.add(team);
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
		return teams;
	}
	

}