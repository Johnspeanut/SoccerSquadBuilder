package squad.dal;

import squad.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {
	protected ConnectionManager connectionManager;

	// Single pattern: instantiation is limited to one object.
	private static UsersDao instance = null;

	protected UsersDao() {
		connectionManager = new ConnectionManager();
	}

	public static UsersDao getInstance() {
		if (instance == null) {
			instance = new UsersDao();
		}
		return instance;
	}
	
	public List<Users> getUsersList() throws SQLException{
		String sql = "select str_username, str_password, email from tbl_users";
		List<Users> usersList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(sql);
			results = selectStmt.executeQuery();

			while (results.next()) {
				String resultUserName = results.getString("str_username");
				String password = results.getString("str_password");
				String email = results.getString("email");
				Users user = new Users(resultUserName, password,email);
				usersList.add(user);
			}
			return usersList;
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
	}

	public Users insert(Users user) throws SQLException {
		String insertUser = "INSERT INTO tbl_users(str_username,str_password, firstname,lastname, email) VALUES(?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertUser);

			insertStmt.setString(1, user.getUserName());
			insertStmt.setString(2, user.getPassword());
			insertStmt.setString(3, user.getFirstName());
			insertStmt.setString(4, user.getLastName());
			insertStmt.setString(5, user.getEmail());

			insertStmt.executeUpdate();
			return user;
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
		}
	}
	
	public boolean isUserExisted(String username) throws SQLException {
		String insertUser = "SELECT str_username FROM tbl_users WHERE str_username = ?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(insertUser);

			selectStmt.setString(1, username);
			results = selectStmt.executeQuery();
			if(connection != null) {
				connection.close();
			}
			if(results.next()) {
				return true;
			}
			return false;
	}
	

	public Users getUserByUserName(String userName) throws SQLException {
		String selectUser = "SELECT * FROM tbl_users WHERE str_username=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, userName);

			results = selectStmt.executeQuery();

			if (results.next()) {
				String resultUserName = results.getString("str_username");
				String password = results.getString("str_password");
				Users user = new Users(resultUserName, password);
				return user;
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

	public Users delete(Users user) throws SQLException {
		String deleteUser = "DELETE FROM tbl_users WHERE str_username=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteUser);
			deleteStmt.setString(1, user.getUserName());
			deleteStmt.executeUpdate();

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
		String truncateSql = "DELETE FROM tbl_users WHERE str_username IS NOT NULL;";
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
