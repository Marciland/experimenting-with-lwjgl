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
	private JList<String> serverList = new JList<String>();
	private DefaultListModel<String> serverListModel = new DefaultListModel<String>();

	public ServerList(int width, int height) {
		serverListPanel.setLayout(null);
		serverListPanel.setBounds(width/16*11, height/18, width/16*5, height/9*6);
		serverListPanel.setBackground(Color.BLUE);

		try {
			loadServerData();
		} catch (SQLException ignored) {
			System.out.println(ignored);
		}

		serverList.setBounds(0, serverListPanel.getHeight()/5*1, serverListPanel.getWidth(), serverListPanel.getHeight()/5*4);
		serverList.setModel(serverListModel);

		serverListPanel.add(serverList);
	}

	private void loadServerData() throws SQLException {
		sql.connect("login");
		sql.executeQuery("SELECT name FROM server;");
		ResultSet rs = sql.getResultSet();
		serverListModel.clear();
		while(rs.next()) {
			serverListModel.addElement(rs.getString("name"));
		}
		rs.close();
		MySQL.disconnect();
	}

	protected JPanel getServerList() {
		return serverListPanel;
	}
}