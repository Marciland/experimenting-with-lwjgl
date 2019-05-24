package launcher;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import input.FrameDragListener;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	private Dimension screenSize;
	protected int width, height;
	protected final static double scaling = 0.7; //smaller number = smaller window; 1 = fullscreen
	protected final static double fontSize = 23;
	private Login login;
	private Menu menu;
	private News news;
	private ServerList serverList;
	private FriendList friendList;
	private JPanel loginPanel;
	private JPanel menuPanel;
	private JPanel newsPanel;
	private JPanel serverListPanel;
	private JPanel friendListPanel;
	private ImageIcon launcherIcon = new ImageIcon("src/res/launcherIcon.png");
	private FrameDragListener frameDragListener = new FrameDragListener(this);

	public Window(String title) {

		if(scaling != 1) {
			addMouseListener(frameDragListener);
			addMouseMotionListener(frameDragListener);
		}
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) Math.round(screenSize.width * scaling);
		height = (int) Math.round(screenSize.height * scaling);
		setSize(width, height);
		setIconImage(launcherIcon.getImage());
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);	//has to be called before frame is displayable!
		setLocationRelativeTo(null);
		setResizable(false);
		login = new Login(width, height);
		loginPanel = login.getLogin();
		getContentPane().add(loginPanel);
		menu = new Menu(width, height);
		menuPanel = menu.getMenu();
		getContentPane().add(menuPanel);
		news = new News(width, height);
		newsPanel = news.getNews();
		getContentPane().add(newsPanel);
		serverList = new ServerList(width, height);
		serverListPanel = serverList.getServerList();
		getContentPane().add(serverListPanel);
		setVisible(true);
		if(isShowing()) {
			System.out.println("Successfully created window!");	
		}else {
			System.out.println("Failed to create window!");				
		}
	}

	public void login() {
		System.out.println("Successfully logged in");
		getContentPane().remove(loginPanel);
		getContentPane().remove(serverListPanel);
		friendList = new FriendList(width, height);
		friendListPanel = friendList.getFriendList();
		getContentPane().add(friendListPanel);
		repaint();
	}
}