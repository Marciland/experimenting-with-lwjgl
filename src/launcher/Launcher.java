package launcher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.MySQL;
import test.MainGameLoop;

public class Launcher {

	private Window window;
	protected static MySQL sql = new MySQL();
	protected static ArrayList<String> usernames = new ArrayList<String>();
	protected static ArrayList<String> emails = new ArrayList<String>();
	protected static ArrayList<String> passwords = new ArrayList<String>();
	protected final String title =  "This is u - Launcher v" + MainGameLoop.version;
	public boolean startGame = false;
	
	public Launcher() {
		
		try {
			getUsers();
		} catch (SQLException ignored) {}
		window = new Window(title);
		while(!Login.success) {
			System.out.println(Login.success);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException ignored) {}
		}
		window.login();
	}
	private static void getUsers() throws SQLException {
		sql.connect("login");
		sql.executeQuery("SELECT username, password, email FROM users;");
		ResultSet rs = sql.getResultSet();
		usernames.clear();
		passwords.clear();
		emails.clear();
		while(rs.next()) {
			usernames.add(rs.getString("username"));	
			passwords.add(rs.getString("password"));
			emails.add(rs.getString("email"));
		}
		System.out.println("Successfully loaded users data!");
		sql.disconnect();
	}

	protected static int newUser(String username, String email) {
		int result = 0;
		try {
			getUsers();
		} catch (SQLException ignored) {}

		if(usernames.contains(username) || emails.contains(email)) {
			if(usernames.contains(username)) {
				result = 1;
				return result;	
			}else if(emails.contains(email)) {
				result = 2;
				return result;
			}
		}else {
			result = 3;
			return result;
		}
		return result;
	}

	public void close() {
		window.dispose();
	}
}