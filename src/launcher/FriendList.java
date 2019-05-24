package launcher;

import java.awt.Color;
import javax.swing.JPanel;

public class FriendList {

	JPanel friendListPanel = new JPanel();

	public FriendList(int width, int height) {
		friendListPanel.setLayout(null);
		friendListPanel.setBackground(Color.YELLOW);
//		friendListPanel.setBounds(x, y, w, h);
	}

	protected JPanel getFriendList() {
		return friendListPanel;
	}
}
