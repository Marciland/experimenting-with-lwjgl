package launcher;

import java.awt.Color;
import javax.swing.JPanel;

public class ServerList {

	private JPanel serverListPanel = new JPanel();

	public ServerList(int width, int height) {
		serverListPanel.setLayout(null);
		serverListPanel.setBounds(width/16*11, height/18, width/16*5, height/9*6);
		serverListPanel.setBackground(Color.BLUE);
	}

	public JPanel getServerList() {
		return serverListPanel;
	}
}