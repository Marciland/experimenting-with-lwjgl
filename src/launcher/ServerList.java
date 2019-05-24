package launcher;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import database.MySQL;

public class ServerList {

	private MySQL sql = new MySQL();
	private JPanel serverListPanel = new JPanel();
	private JList<Server> serverList = new JList<Server>();
	private DefaultListModel<Server> model = new DefaultListModel<Server>();

	public ServerList(int width, int height) {
		serverListPanel.setLayout(null);
		serverListPanel.setBounds(width/16*11, height/18, width/16*5, height/9*6);
		serverListPanel.setBackground(Color.BLUE);

		serverList.setModel(model);
		try {
			loadServerData();
		} catch (SQLException ignored) {}
		serverList.setBounds(0, 0, 100, 100);
		serverListPanel.add(serverList);
	}

	private void loadServerData() throws SQLException {
		sql.connect("login");
		sql.executeQuery("SELECT serverID, name, playerAmount FROM server;");
		ResultSet rs = sql.getResultSet();
		while(rs.next()) {
			model.addElement(new Server(rs.getInt("serverID"), rs.getString("name"), rs.getInt("playerAmount")));
		}
		sql.disconnect();
	}

	protected JPanel getServerList() {
		return serverListPanel;
	}
}