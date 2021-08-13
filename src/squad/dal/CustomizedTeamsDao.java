package squad.dal;

import squad.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomizedTeamsDao {
	protected ConnectionManager connectionManager;

	private static CustomizedTeamsDao instance = null;

	protected CustomizedTeamsDao() {
		connectionManager = new ConnectionManager();
	}

	public static CustomizedTeamsDao getInstance() {
		if (instance == null) {
			instance = new CustomizedTeamsDao();
		}
		return instance;
	}

	public CustomizedTeams create(CustomizedTeams team) throws SQLException {
		String insertTeams = "INSERT INTO tbl_customized_teams(str_username,int_p1_id,int_p2_id,int_p3_id,int_p4_id,int_p5_id,int_p6_id,int_p7_id,int_p8_id,int_p9_id,int_p10_id,int_p11_id) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertTeams, Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, team.getUser().getUserName());
			insertStmt.setInt(2, team.getP1().getPlayer_id());
			insertStmt.setInt(3, team.getP2().getPlayer_id());
			insertStmt.setInt(4, team.getP3().getPlayer_id());
			insertStmt.setInt(5, team.getP4().getPlayer_id());
			insertStmt.setInt(6, team.getP5().getPlayer_id());
			insertStmt.setInt(7, team.getP6().getPlayer_id());
			insertStmt.setInt(8, team.getP7().getPlayer_id());
			insertStmt.setInt(9, team.getP8().getPlayer_id());
			insertStmt.setInt(10, team.getP9().getPlayer_id());
			insertStmt.setInt(11, team.getP10().getPlayer_id());
			insertStmt.setInt(12, team.getP11().getPlayer_id());

			insertStmt.executeUpdate();

			// Retrieve the auto-generated key and set it, so it can be used by the caller.
			resultKey = insertStmt.getGeneratedKeys();
			int teamId = -1;
			if (resultKey.next()) {
				teamId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			team.setTeam_id(teamId);
			;
			return team;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (insertStmt != null) {
				insertStmt.close();
			}
			if (resultKey != null) {
				resultKey.close();
			}
		}
	}

	public CustomizedTeams updateTeamById(final CustomizedTeams updatedCustomizedTeam) throws SQLException {
		String updateSql = "UPDATE tbl_customized_teams "
				+ "SET int_p1_id = ?, int_p2_id = ?, int_p3_id = ?, int_p4_id = ?, int_p5_id = ?, int_p6_id = ?, "
				+ "int_p7_id = ?, int_p8_id = ?, int_p9_id = ?, int_p10_id = ?, int_p11_id = ? "
				+ "WHERE int_team_id = ?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		CustomizedTeamsDao customizedTeamsDao = CustomizedTeamsDao.getInstance();
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateSql);
			updateStmt.setInt(1, updatedCustomizedTeam.getP1().getPlayer_id());
			updateStmt.setInt(2, updatedCustomizedTeam.getP2().getPlayer_id());
			updateStmt.setInt(3, updatedCustomizedTeam.getP3().getPlayer_id());
			updateStmt.setInt(4, updatedCustomizedTeam.getP4().getPlayer_id());
			updateStmt.setInt(5, updatedCustomizedTeam.getP5().getPlayer_id());
			updateStmt.setInt(6, updatedCustomizedTeam.getP6().getPlayer_id());
			updateStmt.setInt(7, updatedCustomizedTeam.getP7().getPlayer_id());
			updateStmt.setInt(8, updatedCustomizedTeam.getP8().getPlayer_id());
			updateStmt.setInt(9, updatedCustomizedTeam.getP9().getPlayer_id());
			updateStmt.setInt(10, updatedCustomizedTeam.getP10().getPlayer_id());
			updateStmt.setInt(11, updatedCustomizedTeam.getP11().getPlayer_id());
			updateStmt.setInt(12, updatedCustomizedTeam.getTeam_id());

			updateStmt.executeUpdate();
			return customizedTeamsDao.getTeamById(updatedCustomizedTeam.getTeam_id());
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (updateStmt != null) {
				updateStmt.close();
			}
		}
	}

	public CustomizedTeams getTeamById(int teamId) throws SQLException {
		String selectTeam = "SELECT * " + "FROM tbl_customized_teams " + "WHERE int_team_id=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectTeam);
			selectStmt.setInt(1, teamId);
			results = selectStmt.executeQuery();
			UsersDao usersDao = UsersDao.getInstance();
			PlayersDao playersDao = PlayersDao.getInstance();
			if (results.next()) {
				int resultTeamId = results.getInt("int_team_id");
				Users user = usersDao.getUserByUserName(results.getString("str_username"));
				Player p1 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p1_id"));
				Player p2 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p2_id"));
				Player p3 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p3_id"));
				Player p4 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p4_id"));
				Player p5 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p5_id"));
				Player p6 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p6_id"));
				Player p7 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p7_id"));
				Player p8 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p8_id"));
				Player p9 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p9_id"));
				Player p10 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p10_id"));
				Player p11 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p11_id"));

				CustomizedTeams team = new CustomizedTeams(resultTeamId, user, p1, p2, p3, p4, p5, p6, p7, p8, p9,
						p10, p11);
				return team;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return null;
	}

	public List<CustomizedTeams> getCustomizedTeamsByUserName(String userName) throws SQLException {
		List<CustomizedTeams> teams = new ArrayList<CustomizedTeams>();
		String selectTeams = "SELECT * " + "FROM tbl_customized_teams " + "WHERE str_username=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectTeams);
			selectStmt.setString(1, userName);
			results = selectStmt.executeQuery();
			UsersDao usersDao = UsersDao.getInstance();
			PlayersDao playersDao = PlayersDao.getInstance();

			while (results.next()) {
				int resultTeamId = results.getInt("int_team_id");
				Users user = usersDao.getUserByUserName(results.getString("str_username"));
				Player p1 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p1_id"));
				Player p2 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p2_id"));
				Player p3 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p3_id"));
				Player p4 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p4_id"));
				Player p5 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p5_id"));
				Player p6 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p6_id"));
				Player p7 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p7_id"));
				Player p8 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p8_id"));
				Player p9 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p9_id"));
				Player p10 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p10_id"));
				Player p11 = playersDao.getPlayerAllinfoByPlayerId(results.getInt("int_p11_id"));

				CustomizedTeams team = new CustomizedTeams(resultTeamId, user, p1, p2, p3, p4, p5, p6, p7, p8, p9,
						p10, p11);
				teams.add(team);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return teams;
	}

	public CustomizedTeams delete(CustomizedTeams team) throws SQLException {
		String deleteReservation = "DELETE FROM tbl_customized_teams WHERE int_team_id=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteReservation);
			deleteStmt.setInt(1, team.getTeam_id());
			deleteStmt.executeUpdate();

			// Return null so the caller can no longer operate on the Persons instance.
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}

	public int truncate() throws SQLException {
		String truncateSql = "DELETE FROM tbl_customized_teams WHERE int_team_id IS NOT NULL;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(truncateSql);
			int affectedRowCount = selectStmt.executeUpdate();
			return affectedRowCount;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
		}
	}
}