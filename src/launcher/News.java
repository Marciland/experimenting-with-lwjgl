package launcher;

import java.awt.Color;
import javax.swing.JPanel;

public class News {

	private JPanel newsPanel = new JPanel();

	public News(int width, int height) {
		newsPanel.setLayout(null);
		newsPanel.setBounds(0, height/18, width/16*11, height-height/18);
		newsPanel.setBackground(Color.RED);
	}

	protected JPanel getNews() {
		return newsPanel;
	}
}