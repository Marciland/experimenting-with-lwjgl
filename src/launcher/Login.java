package launcher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import database.MySQL;
import utilities.Tools;

public class Login {

	private JPanel loginPanel = new JPanel();
	private JLabel usernameLabel = new JLabel();
	private JLabel passwordLabel= new JLabel();
	private	JTextField usernameText = new JTextField();
	private	JPasswordField passwordText = new JPasswordField();	
	private ImageIcon loginIcon = new ImageIcon("src/res/loginIcon.png");
	private ImageIcon newUserIcon = new ImageIcon("src/res/newUserIcon.png");	
	private JButton loginButton = new JButton();
	private JButton newUserButton = new JButton();
	private JButton forgotUsernameButton = new JButton();
	private JButton forgotPasswordButton = new JButton();
	private ActionListener newUserListener, loginListener, forgotUsernameListener, forgotPasswordListener;
	private static boolean success = false;

	public Login(int width, int height) {

		loginPanel.setLayout(null);
		loginPanel.setBackground(Color.BLACK);
		loginPanel.setBounds(width/16*11, height/9*6 + height/18, width/16*5, height/9*2 + height/18);

		usernameLabel.setBounds(0, 0,  loginPanel.getWidth()/5, (int) (loginPanel.getHeight()/2.5));
		usernameLabel.setText("  Username:");
		usernameLabel.setForeground(Color.RED);
		usernameLabel.setFont(Tools.getCalibriFont((int) (Window.fontSize*Window.scaling)));

		usernameText.setBounds(loginPanel.getWidth()/5, (int) (loginPanel.getHeight()/2.5/4), loginPanel.getWidth()/5*3, (int) (loginPanel.getHeight()/2.5/4*2));
		usernameText.setFont(Tools.getCalibriFont((int) (Window.fontSize*Window.scaling)));
		usernameText.setBorder(null);

		passwordLabel.setBounds(0, (int) (loginPanel.getHeight()/2.5), loginPanel.getWidth()/5, (int) (loginPanel.getHeight()/2.5));
		passwordLabel.setText("  Password:");
		passwordLabel.setForeground(Color.RED);
		passwordLabel.setFont(Tools.getCalibriFont((int) (Window.fontSize*Window.scaling)));

		passwordText.setBounds(loginPanel.getWidth()/5, (int) (loginPanel.getHeight()/2.5 + loginPanel.getHeight()/2.5/4), loginPanel.getWidth()/5*3, (int) (loginPanel.getHeight()/2.5/4*2));
		passwordText.setFont(Tools.getCalibriFont((int) (Window.fontSize*Window.scaling)));
		passwordText.setBorder(null);

		loginButton.setBounds(loginPanel.getWidth()/20, (int) (loginPanel.getHeight()/2.5*2), loginPanel.getWidth()/5*2, loginPanel.getHeight()/5);
		loginButton.setBorderPainted(false);
		loginButton.setBackground(loginPanel.getBackground());
		loginButton.setIcon(Tools.resizeIcon(loginIcon, loginButton.getWidth(), loginButton.getHeight()));

		newUserButton.setBounds(loginPanel.getWidth()/2 + loginPanel.getWidth()/20, (int) (loginPanel.getHeight()/2.5*2), loginPanel.getWidth()/5*2, loginPanel.getHeight()/5);
		newUserButton.setBorderPainted(false);
		newUserButton.setBackground(loginPanel.getBackground());
		newUserButton.setIcon(Tools.resizeIcon(newUserIcon, newUserButton.getWidth(), newUserButton.getHeight()));

		forgotUsernameButton.setBounds(loginPanel.getWidth()/5*4, 0, loginPanel.getWidth()/5, (int) (loginPanel.getHeight()/2.5));
		forgotUsernameButton.setBorderPainted(false);
		forgotUsernameButton.setBackground(loginPanel.getBackground());
		forgotUsernameButton.setForeground(Color.RED);
		forgotUsernameButton.setFont(Tools.getCalibriFont((int) (Window.fontSize*Window.scaling)));
		forgotUsernameButton.setText("<html>forgot<br>username?</html>");

		forgotPasswordButton.setBounds(loginPanel.getWidth()/5*4, (int) (loginPanel.getHeight()/2.5), loginPanel.getWidth()/5, (int) (loginPanel.getHeight()/2.5));
		forgotPasswordButton.setBorderPainted(false);
		forgotPasswordButton.setBackground(loginPanel.getBackground());
		forgotPasswordButton.setForeground(Color.RED);
		forgotPasswordButton.setFont(Tools.getCalibriFont((int) (Window.fontSize*Window.scaling)));
		forgotPasswordButton.setText("<html>forgot<br>password?</html>");

		loginListener = new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(Launcher.usernames.contains(usernameText.getText()) || Launcher.emails.contains(usernameText.getText())) {
					int indexU = Launcher.usernames.indexOf(usernameText.getText());
					int indexE = Launcher.emails.indexOf(usernameText.getText());
					if(Launcher.passwords.contains(passwordText.getText())) {
						if(Launcher.passwords.indexOf(passwordText.getText()) == indexU) {
							success = true;
							JOptionPane.showMessageDialog(null, "Successfully logged in! Please Wait.", "Success", JOptionPane.INFORMATION_MESSAGE);
						}else if(Launcher.passwords.indexOf(passwordText.getText()) == indexE) {
							success = true;
							JOptionPane.showMessageDialog(null, "Successfully logged in! Please Wait.", "Success", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Failed to log in!", "Error", JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Failed to log in!", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Failed to log in!", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		};

		newUserListener = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JLabel usernameLabel = new JLabel("Username:", SwingConstants.CENTER);
				JLabel passwordLabel1 = new JLabel("Password:", SwingConstants.CENTER);
				JLabel passwordLabel2 = new JLabel("Password:", SwingConstants.CENTER);
				JLabel emailLabel = new JLabel("Email:", SwingConstants.CENTER);
				JTextField usernameText = new JTextField();
				JTextField passwordText1 = new JTextField();
				JTextField passwordText2 = new JTextField();
				JTextField emailText = new JTextField();
				JButton okButton = new JButton("OK");
				JButton cancelButton = new JButton("CANCEL");
				JPanel newUserPanel = new JPanel();
				JFrame frame = new JFrame();
				MySQL sql = new MySQL();
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int fWidth = (int) Math.round(screenSize.width * Window.scaling/3);
				int fHeight = (int) Math.round(screenSize.height * Window.scaling/3);

				newUserPanel.setLayout(null);
				newUserPanel.setBackground(Color.GREEN);
				newUserPanel.setBounds(0, 0, fHeight, fWidth);

				usernameLabel.setBounds(0, 0, newUserPanel.getWidth()/2, newUserPanel.getHeight()/8);
				passwordLabel1.setBounds(0, newUserPanel.getHeight()/4, newUserPanel.getWidth()/2, newUserPanel.getHeight()/8);
				passwordLabel2.setBounds(0, newUserPanel.getHeight()/4*2, newUserPanel.getWidth()/2, newUserPanel.getHeight()/8);
				emailLabel.setBounds(0, newUserPanel.getHeight()/4*3, newUserPanel.getWidth()/2, newUserPanel.getHeight()/8);

				usernameText.setBounds(newUserPanel.getWidth()/2, 0, newUserPanel.getWidth()/2, newUserPanel.getHeight()/8);
				passwordText1.setBounds(newUserPanel.getWidth()/2, newUserPanel.getHeight()/4, newUserPanel.getWidth()/2, newUserPanel.getHeight()/8);
				passwordText2.setBounds(newUserPanel.getWidth()/2, newUserPanel.getHeight()/4*2, newUserPanel.getWidth()/2, newUserPanel.getHeight()/8);
				emailText.setBounds(newUserPanel.getWidth()/2, newUserPanel.getHeight()/4*3, newUserPanel.getWidth()/2, newUserPanel.getHeight()/8);

				okButton.setBounds(newUserPanel.getWidth()/10, newUserPanel.getHeight()/8*7, newUserPanel.getWidth()/3, newUserPanel.getHeight()/16);
				okButton.setBorderPainted(false);
				cancelButton.setBounds(newUserPanel.getWidth()/2 + newUserPanel.getWidth()/10, newUserPanel.getHeight()/8*7, newUserPanel.getWidth()/3, newUserPanel.getHeight()/16);
				cancelButton.setBorderPainted(false);

				newUserPanel.add(usernameLabel);
				newUserPanel.add(passwordLabel1);
				newUserPanel.add(passwordLabel2);
				newUserPanel.add(emailLabel);
				newUserPanel.add(usernameText);
				newUserPanel.add(passwordText1);
				newUserPanel.add(passwordText2);
				newUserPanel.add(emailText);
				newUserPanel.add(okButton);
				newUserPanel.add(cancelButton);

				ActionListener okListener = new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if(passwordText1.getText().contains(passwordText2.getText())) {
							if(!usernameText.getText().isEmpty() && !passwordText1.getText().isEmpty() && !emailText.getText().isEmpty()) {
								int i = Launcher.newUser(usernameText.getText(), emailText.getText());

								if(i == 1) {
									JOptionPane.showMessageDialog(null, "Username already taken!", "Error", JOptionPane.ERROR_MESSAGE);
								}else if(i == 2) {
									JOptionPane.showMessageDialog(null, "Email already taken!", "Error", JOptionPane.ERROR_MESSAGE);
								}else if(i == 3) {
									//create new user
									try {
										sql.executeUpdate("INSERT INTO login.users (username, password, email) VALUES ('" + usernameText.getText() + "', '" + passwordText1.getText() + "', '" + emailText.getText() + "');");
									} catch (SQLException ignored) {
										System.out.println(ignored);
									}
									//dispose & JOptionPane
								}
							}else {JOptionPane.showMessageDialog(null, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}		
				};

				ActionListener cancelListener = new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}		
				};

				okButton.addActionListener(okListener);	
				cancelButton.addActionListener(cancelListener);

				frame.setSize(fHeight, fWidth);
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				frame.setTitle("Create account!");
				frame.getContentPane().add(newUserPanel);
				frame.setVisible(true);	
			}
		};

		forgotUsernameListener = new ActionListener(){
			public void actionPerformed(ActionEvent e) {

			}		
		};

		forgotPasswordListener = new ActionListener(){
			public void actionPerformed(ActionEvent e) {

			}		
		};

		loginButton.addActionListener(loginListener);	
		newUserButton.addActionListener(newUserListener);
		forgotUsernameButton.addActionListener(forgotUsernameListener);
		forgotPasswordButton.addActionListener(forgotPasswordListener);

		loginPanel.add(usernameLabel);
		loginPanel.add(passwordLabel);
		loginPanel.add(usernameText);
		loginPanel.add(passwordText);
		loginPanel.add(loginButton);
		loginPanel.add(newUserButton);
		loginPanel.add(forgotUsernameButton);
		loginPanel.add(forgotPasswordButton);
	}

	public JPanel getLogin() {
		return loginPanel;
	}

	public static boolean getSuccess() {
		return success;
	}
}