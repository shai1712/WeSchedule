package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import database.Login;
import definitions.SideFunctions;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;

public class EntranceScreen extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7387110272821445875L;
	private JPanel contentPane, rightPanel;
	private JButton signUpBtn, exitBtn, signInBtn;
	private JLabel usernameLabel, passwordLabel, frameDrag;
	private JTextField usernameTF;
	private JPasswordField passwordPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntranceScreen frame = new EntranceScreen();
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
	public EntranceScreen() {
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
		createImagePanel();
		createRightPanel();
		createFrameDragLabel();
	}

	private void createImagePanel() {

		// create the image panel
		PaintPane imagePanel = new PaintPane();
		imagePanel.setBounds(0, 0, 350, 400);
		contentPane.add(imagePanel);
		imagePanel.setLayout(null);

		// create the welcome to Label
		JLabel welcomeLabel = new JLabel("Welcome to WeSchedule");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBackground(new Color(255, 255, 255));
		welcomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		welcomeLabel.setForeground(new Color(204, 204, 204));
		welcomeLabel.setBounds(10, 169, 330, 45);
		imagePanel.add(welcomeLabel);

		// create the welcome icon
		ImageIcon timetableIcon = new ImageIcon(getClass().getResource("/images/timetable_96px.png"));
		JLabel welcomeIcon = new JLabel(timetableIcon);
		welcomeIcon.setBounds(134, 75, 96, 96);
		imagePanel.add(welcomeIcon);

		// create the sign up button
		ImageIcon signUpIcon = new ImageIcon(getClass().getResource("/images/registration_26px.png"));
		signUpBtn = new JButton("Sign Up", signUpIcon);
		signUpBtn.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		signUpBtn.setForeground(new Color(204, 204, 204));
		signUpBtn.setBackground(new Color(51, 51, 51));
		signUpBtn.setBounds(100, 236, 140, 32);
		signUpBtn.setFocusPainted(false);
		signUpBtn.addActionListener(this);
		signUpBtn.addMouseListener(this);
		imagePanel.add(signUpBtn);

	}

	private void createRightPanel() {

		// create the right panel
		rightPanel = new JPanel();
		rightPanel.setBackground(new Color(51, 51, 51));
		rightPanel.setBounds(350, 0, 350, 400);
		contentPane.add(rightPanel);
		rightPanel.setLayout(null);

		ImageIcon exitIcon = new ImageIcon(getClass().getResource("/images/shutdown_26px.png"));
		exitBtn = new JButton(exitIcon);
		exitBtn.setBackground(new Color(51, 51, 51));
		exitBtn.setBounds(324, 0, 26, 26);
		exitBtn.setBorder(null);
		exitBtn.addActionListener(this);
		exitBtn.addMouseListener(this);
		rightPanel.add(exitBtn);
		createSignInPanel();
	}

	public void createSignInPanel() {
		// create the sign in panel
		JPanel signInPanel = new JPanel();
		signInPanel.setBackground(new Color(220, 220, 220));
		signInPanel.setBounds(36, 35, 280, 335);
		rightPanel.add(signInPanel);
		signInPanel.setLayout(null);

		// create the sign in button
		ImageIcon signInIcon = new ImageIcon(getClass().getResource("/images/signin_26px.png"));
		signInBtn = new JButton("Sign In", signInIcon);
		signInBtn.setForeground(new Color(204, 204, 204));
		signInBtn.setFocusPainted(false);
		signInBtn.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		signInBtn.setBackground(new Color(51, 51, 51));
		signInBtn.setBounds(67, 236, 140, 32);
		signInBtn.addActionListener(this);
		signInBtn.addMouseListener(this);
		signInPanel.add(signInBtn);

		// create the sign in label
		JLabel signInLabel = new JLabel("Sign In");
		signInLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		signInLabel.setForeground(new Color(51, 51, 51));
		signInLabel.setBounds(93, 11, 82, 32);
		signInPanel.add(signInLabel);

		// create the username label
		usernameLabel = new JLabel("Username:");
		usernameLabel.setForeground(new Color(51, 51, 51));
		usernameLabel.setBounds(67, 80, 110, 18);
		signInPanel.add(usernameLabel);

		// create the username field
		usernameTF = new JTextField();
		usernameTF.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		usernameTF.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		usernameTF.setBounds(67, 100, 140, 20);
		usernameTF.setOpaque(false);
		signInPanel.add(usernameTF);
		usernameTF.setColumns(10);

		// create the password label
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(67, 156, 110, 18);
		passwordLabel.setForeground(new Color(51, 51, 51));
		signInPanel.add(passwordLabel);

		// create the password field
		passwordPF = new JPasswordField();
		passwordPF.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordPF.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		passwordPF.setBounds(67, 179, 140, 20);
		passwordPF.setOpaque(false);
		signInPanel.add(passwordPF);
	}

	private void createFrameDragLabel() {
		frameDrag = new JLabel();
		frameDrag.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				SideFunctions.frameDragMouseDragged(EntranceScreen.this, arg0);
			}
		});
		frameDrag.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				SideFunctions.frameDragMouseClicked(EntranceScreen.this, arg0);
			}
		});
		frameDrag.setBounds(0, 0, 700, 400);
		contentPane.add(frameDrag);
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		if (action.getSource() == exitBtn) {
			System.exit(0);
		}
		if (action.getSource() == signUpBtn) {
			dispose();
			RegistrationScreen regScreen = new RegistrationScreen();
			regScreen.setVisible(true);
		}
		if (action.getSource() == signInBtn) {
			Login loginObject = new Login(usernameTF, passwordPF);
			int result = loginObject.login();
			if (result == 0) {
				dispose();
				MainScreen mainScreen = new MainScreen();
				mainScreen.setLocationRelativeTo(this);
				mainScreen.setVisible(true);
			} else if (result == -1) {
				usernameTF.setText("");
				passwordPF.setText("");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == exitBtn) {
			exitBtn.setBackground(new Color(242, 242, 242));
		}
		if (e.getSource() == signUpBtn) {
			signUpBtn.setBackground(new Color(242, 242, 242));
		}
		if (e.getSource() == signInBtn) {
			signInBtn.setBackground(new Color(242, 242, 242));
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == exitBtn) {
			exitBtn.setBackground(new Color(51, 51, 51));
		}
		if (e.getSource() == signUpBtn) {
			signUpBtn.setBackground(new Color(51, 51, 51));
		}
		if (e.getSource() == signInBtn) {
			signInBtn.setBackground(new Color(51, 51, 51));
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
