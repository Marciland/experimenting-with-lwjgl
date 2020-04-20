package launcher;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import database.MySQL;
import utilities.Tools;

public class Menu {

	private JPanel menuPanel = new JPanel();
	private JButton settingsButton = new JButton();
	private JButton exitButton = new JButton();
	private ImageIcon exitIcon = new ImageIcon("src/res/exitIcon.png");
	private ImageIcon settingsIcon = new ImageIcon("src/res/settingsIcon.png");
	private ActionListener exitListener, settingsListener;

	public Menu(int width, int height) {
		menuPanel.setLayout (null);
		menuPanel.setBounds(0, 0, width, height/18);
		menuPanel.setBackground(Color.WHITE);

		settingsButton.setBounds(0, 0, menuPanel.getHeight(), menuPanel.getHeight());
		settingsButton.setIcon(Tools.resizeIcon(settingsIcon, settingsButton.getWidth(), settingsButton.getHeight()));
		settingsButton.setBorderPainted(false);
		settingsButton.setBackground(menuPanel.getBackground());

		exitButton.setBounds(menuPanel.getWidth()-menuPanel.getHeight(), 0, menuPanel.getHeight(), menuPanel.getHeight());
		exitButton.setIcon(Tools.resizeIcon(exitIcon, exitButton.getWidth(), exitButton.getHeight()));
		exitButton.setBorderPainted(false);
		exitButton.setBackground(menuPanel.getBackground());

		exitListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Willst du den Launcher beenden?", "Beenden?", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(result == 0) {
					MySQL.disconnect();
					System.exit(0);
				}
			}
		};

		settingsListener = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Settings();
			}
		};

		exitButton.addActionListener(exitListener);
		settingsButton.addActionListener(settingsListener);

		menuPanel.add(settingsButton);
		menuPanel.add(exitButton);	
	}

	protected JPanel getMenu() {
		return menuPanel;
	}
}