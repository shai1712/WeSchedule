package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Rectangle;

public class RegistrationObsolete extends JFrame implements ActionListener{

	private JMenuBar menuBar;
	private JMenu file, help;
	private JMenuItem exit, about;
	private ImageIcon fileIcon, helpIcon, exitIcon, aboutIcon;
	private JPanel mainPanel; // remove contentPane after finishing;
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JTextField usernameTF;
	private JPasswordField passwordPF;
	private JButton okRegisterButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationObsolete frame = new RegistrationObsolete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationObsolete() {
		setUndecorated(true);
		initialize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	private void initialize() {
		setTitle("WeSchedule - Registration Form");
		setBounds(new Rectangle(100, 100, 600, 320));
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		createTheMenu();
		createMainPanel();
	}

	private void createTheMenu() {
		// create the menu bar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

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
	
	private void createMainPanel() {
		mainPanel = new JPanel(null);
		mainPanel.setBackground(new Color(119, 136, 153));
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);

		// create the new user registration label
		JLabel newUserRegisterLabel = new JLabel("New User Registration");
		newUserRegisterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newUserRegisterLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 42));
		newUserRegisterLabel.setBounds(10, 11, 558, 50);
		mainPanel.add(newUserRegisterLabel);

		// create the first name label
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		firstNameLabel.setBounds(10, 72, 110, 29);
		mainPanel.add(firstNameLabel);

		// create the first name field
		firstNameTF = new JTextField();
		firstNameTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		firstNameTF.setBounds(125, 72, 172, 29);
		mainPanel.add(firstNameTF);

		// create the last name label
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		lastNameLabel.setBounds(10, 122, 110, 29);
		mainPanel.add(lastNameLabel);
		
		// create the last name field
		lastNameTF = new JTextField();
		lastNameTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lastNameTF.setBounds(125, 122, 172, 29);
		mainPanel.add(lastNameTF);
		
		// create the username label
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		usernameLabel.setBounds(10, 172, 110, 29);
		mainPanel.add(usernameLabel);

		// create the username field
		usernameTF = new JTextField();
		usernameTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		usernameTF.setBounds(125, 172, 172, 29);
		mainPanel.add(usernameTF);
		
		// create the password label
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		passwordLabel.setBounds(10, 222, 110, 29);
		mainPanel.add(passwordLabel);
		
		// create the password field
		passwordPF = new JPasswordField();
		passwordPF.setBounds(125, 222, 172, 29);
		passwordPF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mainPanel.add(passwordPF);
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
		
	}
}
