package launcher;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import input.FrameDragListener;

public class Settings extends JFrame{

	private static final long serialVersionUID = -3806064205532312763L;
	private JPanel settingsPanel = new JPanel();
	private ImageIcon settingsIcon = new ImageIcon("src/res/settingsIcon.png");
	private FrameDragListener frameDragListener = new FrameDragListener(this);

	public Settings() {
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);
		settingsPanel.setLayout(null);
		settingsPanel.setBackground(Color.CYAN); 
		// .add Buttons/Sliders/dropboxes to change various settings
		setSize(100,100); //size has to be adjusted based on launcher.window!
		setIconImage(settingsIcon.getImage());
		setTitle("Settings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().add(settingsPanel);
		setVisible(true);
	}
}