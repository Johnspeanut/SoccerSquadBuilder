package squad.dal;

import squad.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	protected ConnectionManager connectionManager;

	// Single pattern: instantiation is limited to one object.
	private static LoginDao instance = null;

	protected LoginDao() {
		connectionManager = new ConnectionManager();
	}

	public static LoginDao getInstance() {
		if (instance == null) {
			instance = new LoginDao();
		}
		return instance;
	}


	public Users login(String username, String password) throws SQLException {
		String sql = "select str_username, str_password, firstname, lastname, email, budget "
				+ "from tbl_users "
				+ "where str_username = ? and str_password = ?";
		
		Connection conn = connectionManager.getConnection();
		PreparedStatement insertStmt = conn.prepareStatement(sql);
		insertStmt.setString(1, username);
		insertStmt.setString(2, password);
		ResultSet rs = insertStmt.executeQuery();
		try {
		/*
		 * if(conn != null) { conn.close(); }
		 */
		
	if(rs.next()) {
		Users user = new Users(rs.getString("str_username"), rs.getString("str_password"));
		return user;
	}
		}catch (SQLException e) {
		e.printStackTrace();
		throw e;
	} finally {
		if(conn != null) {
			conn.close();
		}
		if(insertStmt != null) {
			insertStmt.close();
		}
		if(rs != null) {
			rs.close();
		}
	}
	return null;
}
}
