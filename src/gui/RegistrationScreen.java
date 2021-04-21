package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import database.SignUp;
import definitions.SideFunctions;

import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;

public class RegistrationScreen extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4313506898833257988L;
	private JPanel contentPane;
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JTextField usernameTF;
	private JPasswordField passwordField;
	private JButton exitBtn, signUpBtn;
	private JLabel frameDrag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationScreen frame = new RegistrationScreen();
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
	public RegistrationScreen() {

		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 700, 400);
		setTitle("WeSchedule");
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		createLeftPanel();
		createRightPanel();
		createFrameDragLabel();
	}

	private void createFrameDragLabel() {
		frameDrag = new JLabel();
		frameDrag.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				SideFunctions.frameDragMouseDragged(RegistrationScreen.this, arg0);
			}
		});
		frameDrag.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				SideFunctions.frameDragMouseClicked(RegistrationScreen.this, arg0);
			}
		});
		frameDrag.setBounds(0, 0, 700, 400);
		contentPane.add(frameDrag);
	}

	private void createLeftPanel() {
		// create the left panel
		PaintPane leftPanel = new PaintPane();
		leftPanel.setBorder(new MatteBorder(0, 0, 0, 0, (Color) null));
		leftPanel.setBackground(new Color(220, 220, 220));
		leftPanel.setBounds(0, 0, 350, 400);
		contentPane.add(leftPanel);
		leftPanel.setLayout(null);

		// create the timetable icon
		ImageIcon timetableIcon = new ImageIcon(getClass().getResource("/images/timetable_gray_124px.png"));
		JLabel timetableLabel = new JLabel(timetableIcon);
		timetableLabel.setBounds(112, 102, 124, 124);
		leftPanel.add(timetableLabel);

		// create the WeSchedule label
		JLabel wescheduleLabel = new JLabel("WeSchedule");
		wescheduleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		wescheduleLabel.setForeground(new Color(220, 220, 220));
		wescheduleLabel.setBounds(86, 35, 212, 42);
		leftPanel.add(wescheduleLabel);

		// create the top separator
		JSeparator topSeparator = new JSeparator();
		topSeparator.setForeground(new Color(220, 220, 220));
		topSeparator.setFocusTraversalKeysEnabled(false);
		topSeparator.setBackground(new Color(220, 220, 220));
		topSeparator.setBounds(60, 257, 212, 10);
		leftPanel.add(topSeparator);

		// create the bottom separator
		JSeparator bottomSeparator = new JSeparator();
		bottomSeparator.setForeground(new Color(220, 220, 220));
		bottomSeparator.setBackground(new Color(220, 220, 220));
		bottomSeparator.setBounds(86, 303, 150, 10);
		leftPanel.add(bottomSeparator);

	}

	private void createRightPanel() {
		// create the right panel
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(new Color(105, 105, 105));
		rightPanel.setBounds(350, 0, 350, 400);
		contentPane.add(rightPanel);
		rightPanel.setLayout(null);

		// create the exit button
		ImageIcon exitIcon = new ImageIcon(getClass().getResource("/images/shutdown_26px.png"));
		exitBtn = new JButton(exitIcon);
		exitBtn.setBackground(new Color(105, 105, 105));
		exitBtn.setBounds(324, 0, 26, 26);
		exitBtn.setBorder(null);
		exitBtn.addActionListener(this);
		exitBtn.addMouseListener(this);
		rightPanel.add(exitBtn);

		// create the sign up label
		JLabel signUpLabel = new JLabel("Sign Up");
		signUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signUpLabel.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		signUpLabel.setForeground(new Color(220, 220, 220));
		signUpLabel.setBounds(110, 35, 125, 42);
		rightPanel.add(signUpLabel);

		// create the first name label
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		firstNameLabel.setForeground(new Color(220, 220, 220));
		firstNameLabel.setBounds(55, 100, 75, 20);
		rightPanel.add(firstNameLabel);

		// create the first name field
		firstNameTF = new JTextField();
		firstNameTF.setToolTipText("Alphabetic letters only");
		firstNameTF.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		firstNameTF.setForeground(new Color(255, 255, 255));
		firstNameTF.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		firstNameTF.setBounds(55, 120, 195, 20);
		firstNameTF.setOpaque(false);
		rightPanel.add(firstNameTF);
		firstNameTF.setColumns(10);

		// create the last name label
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lastNameLabel.setBounds(55, 150, 75, 20);
		lastNameLabel.setForeground(new Color(220, 220, 220));
		rightPanel.add(lastNameLabel);

		// create the last name field
		lastNameTF = new JTextField();
		lastNameTF.setToolTipText("Alphabetic letters only");
		lastNameTF.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		lastNameTF.setForeground(new Color(255, 255, 255));
		lastNameTF.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lastNameTF.setOpaque(false);
		lastNameTF.setColumns(10);
		lastNameTF.setBounds(55, 170, 195, 20);
		rightPanel.add(lastNameTF);

		// create the username label
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		usernameLabel.setBounds(55, 200, 75, 20);
		usernameLabel.setForeground(new Color(220, 220, 220));
		rightPanel.add(usernameLabel);

		// create the username field
		usernameTF = new JTextField();
		usernameTF.setToolTipText("Alphabetic and numeric characters only");
		usernameTF.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		usernameTF.setForeground(new Color(255, 255, 255));
		usernameTF.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		usernameTF.setOpaque(false);
		usernameTF.setColumns(10);
		usernameTF.setBounds(55, 220, 195, 20);
		rightPanel.add(usernameTF);

		// create the password label
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordLabel.setBounds(55, 250, 75, 20);
		passwordLabel.setForeground(new Color(220, 220, 220));
		rightPanel.add(passwordLabel);

		// create the password field
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordField.setOpaque(false);
		passwordField.setBounds(55, 270, 195, 20);
		rightPanel.add(passwordField);

		// create the sign up button
		ImageIcon signUpIcon = new ImageIcon(getClass().getResource("/images/registration_black_26px.png"));
		signUpBtn = new JButton("Sign Up", signUpIcon);
		signUpBtn.setFocusPainted(false);
		signUpBtn.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		signUpBtn.setBackground(new Color(220, 220, 220));
		signUpBtn.setBounds(55, 322, 125, 35);
		signUpBtn.addActionListener(this);
		signUpBtn.addMouseListener(this);
		rightPanel.add(signUpBtn);

	}

	@Override
	public void actionPerformed(ActionEvent action) {
		if (action.getSource() == exitBtn) {
			System.exit(0);
		}
		if (action.getSource() == signUpBtn) {
			SignUp signUpObject = new SignUp(firstNameTF, lastNameTF, usernameTF, passwordField);
			int result = signUpObject.register();
			if (result == -1) {
				firstNameTF.setText("");
				lastNameTF.setText("");
				usernameTF.setText("");
				passwordField.setText("");
			} else if (result == 0) {
				dispose();
				MainScreen mainScreen = new MainScreen();
				mainScreen.setLocationRelativeTo(this);
				mainScreen.setVisible(true);
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == exitBtn) {
			exitBtn.setBackground(new Color(242, 242, 242));
		}
		if (arg0.getSource() == signUpBtn) {
			signUpBtn.setBackground(new Color(242, 242, 242));
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if (arg0.getSource() == exitBtn) {
			exitBtn.setBackground(new Color(105, 105, 105));
		}
		if (arg0.getSource() == signUpBtn) {
			signUpBtn.setBackground(new Color(220, 220, 220));
		}

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
