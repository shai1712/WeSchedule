package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;

public class Main implements ActionListener {

	private JFrame frame;
	private JPasswordField passwordPF;
	private JTextField usernameTF;
	private JButton loginButton;
	private JMenuBar menuBar;
	private JMenu file, help;
	private JMenuItem exit, about;
	private ImageIcon timetableIcon, fileIcon, helpIcon, exitIcon, aboutIcon, signUpIcon, signInIcon;
	private JButton signUp, signIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setTitle("WeSchedule");
		frame.setBounds(100, 100, 700, 400);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//createSidePanel();
		//createMainPanel();

		frame.getContentPane().setLayout(null);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(0, 0, 350, 400);
		frame.getContentPane().add(imagePanel);
		
		JPanel signInPanel = new JPanel();
		signInPanel.setBounds(350, 0, 350, 400);
		frame.getContentPane().add(signInPanel);
		

	}

	private void createTheMenu() {
		// create the menu bar
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// create the file menu object
		file = new JMenu("File");
		fileIcon = new ImageIcon("src\\images\\icons8-file-24.png");
		file.setIcon(fileIcon);
		menuBar.add(file);

		// create the help menu object
		help = new JMenu("Help");
		helpIcon = new ImageIcon("src\\images\\icons8-help-24.png");
		help.setIcon(helpIcon);
		menuBar.add(help);

		// create the exit menu item
		exit = new JMenuItem("Exit");
		exitIcon = new ImageIcon("src\\images\\icons8-exit-24.png");
		exit.setIcon(exitIcon);
		exit.addActionListener(this);
		file.add(exit);

		// create the about menu item
		about = new JMenuItem("About");
		aboutIcon = new ImageIcon("src\\images\\icons8-about-24.png");
		about.setIcon(aboutIcon);
		about.addActionListener(this);
		help.add(about);
	}

	private void createSidePanel()
	{
	}
	
	private void createMainPanel() {
		// create WeSchedule Label
		timetableIcon = new ImageIcon("src/images/icons8-timetable-64.png");
		JLabel weScheduleLabel = new JLabel("WeSchedule", timetableIcon, JLabel.CENTER);
		weScheduleLabel.setForeground(new Color(0, 0, 0));
		weScheduleLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
		weScheduleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weScheduleLabel.setBounds(323, 96, 374, 67);
		frame.getContentPane().add(weScheduleLabel);

		// create the username label
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		usernameLabel.setBounds(393, 158, 90, 14);
		frame.getContentPane().add(usernameLabel);

		// create the password label
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		passwordLabel.setBounds(393, 203, 90, 14);
		frame.getContentPane().add(passwordLabel);

		// create the username field
		usernameTF = new JTextField();
		usernameTF.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		usernameTF.setBackground(new Color(211, 211, 211));
		usernameTF.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernameTF.setBounds(393, 174, 227, 22);
		frame.getContentPane().add(usernameTF);

		// create the password field
		passwordPF = new JPasswordField();
		passwordPF.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		passwordPF.setBackground(new Color(211, 211, 211));
		passwordPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordPF.setBounds(393, 222, 227, 22);
		frame.getContentPane().add(passwordPF);

		// create the sign up button
		signUpIcon = new ImageIcon("src/images/icons8-registration-26.png");
		signUp = new JButton("Sign Up", signUpIcon);
		signUp.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		signUp.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		signUp.setToolTipText("Register a new user");
		signUp.addActionListener(this);
		signUp.setBackground(new Color(211, 211, 211));
		signUp.setBounds(393, 251, 110, 45);
		frame.getContentPane().add(signUp);

		// create the sign in button
		signInIcon = new ImageIcon("src/images/icons8-signin-26.png");
		signIn = new JButton("Sign In", signInIcon);
		signIn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		signIn.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		signIn.setToolTipText("Login to existing user");
		signIn.addActionListener(this);
		signIn.setBackground(new Color(211, 211, 211));
		signIn.setBounds(513, 251, 110, 45);
		frame.getContentPane().add(signIn);
	}

	private void registration() {
		frame.dispose();
		RegistrationObsolete reg = new RegistrationObsolete();
		reg.setLocationRelativeTo(frame);
		reg.setVisible(true);
	}

	private void login() {
		String userName = usernameTF.getText();
		char[] pass = passwordPF.getPassword();
		String password = new String(pass);
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/weschedule",
					"root", "root");

			PreparedStatement query = (PreparedStatement) connection
					.prepareStatement("Select user_name, password from account where user_name=? and password=?");

			query.setString(1, userName);
			query.setString(2, password);
			ResultSet rs = query.executeQuery();
			if (rs.next()) {
				frame.dispose();
				JOptionPane.showMessageDialog(loginButton, "Successfully Signed in", "WeSchedule - Sign In", JOptionPane.INFORMATION_MESSAGE);
				ManagementSystem managementWindow = new ManagementSystem();
				managementWindow.setLocationRelativeTo(frame);
				managementWindow.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(loginButton, "Wrong Username & Password");
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			System.exit(0);
		}
		if (e.getSource() == about) {
			JOptionPane.showMessageDialog(null, "WeSchedule\nMade By: Shay Shitrit & Amit Amir", "WeSchedule - About",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == signUp) {
			registration();
		}
		if (e.getSource() == signIn) {
			login();
		}
	}
}
