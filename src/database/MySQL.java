package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

	private String host = "localhost";
	private String port = "3306";
	private String database;
	private String username = "Marcel";
	private String password = "password";
	private final String timezone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";

	public Connection con = null;
	public Statement stmt = null;
	public ResultSet rs = null;

	public void connect(String databaseName) throws SQLException {
		database = databaseName;
		con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + timezone, username, password);
		stmt = con.createStatement();
	}


	//executeQuery only works with SELECT
	public void executeQuery(String query) throws SQLException {
		rs = stmt.executeQuery(query);
	}

	//executeUpdate works with INSERT/DELETE/UPDATE
	public void executeUpdate(String update) throws SQLException {
		stmt.executeUpdate(update);
	}

	public ResultSet getResultSet() {
		return rs;
	}

	public void disconnect() {
		try {
			if(rs != null) {
				rs.close();	
			}
			if(stmt != null) {
				stmt.close();	
			}
			if(con != null) {
				con.close();
			}
		} catch (Exception ignored) {

		}
	}
}