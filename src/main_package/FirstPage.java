package main_package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class FirstPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage window = new FirstPage();
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
	public FirstPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setTitle("WeSchedule");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(192, 192, 192));
		menuBar.setToolTipText("This is the menu bar");
		menuBar.setFont(UIManager.getFont("MenuBar.font"));
		frame.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setFont(UIManager.getFont("Menu.font"));
		menuBar.add(fileMenu);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setFont(UIManager.getFont("Menu.font"));
		menuBar.add(helpMenu);
		
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "WeSchedule\nMade By: Shay Shitrit & Amit Amir");
			}
		});
		helpMenu.add(aboutItem);
		frame.getContentPane().setLayout(null);
		
		JButton registerButton = new JButton("Register");
		registerButton.setToolTipText("Create new user");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		registerButton.setBackground(new Color(112, 128, 144));
		registerButton.setBounds(100, 108, 100, 45);
		registerButton.setBorder(new LineBorder(Color.BLACK));
		frame.getContentPane().add(registerButton);
		
		JButton loginButton = new JButton("Login");
		loginButton.setToolTipText("Login to existing user");
		loginButton.setBackground(new Color(112, 128, 144));
		loginButton.setBounds(225, 108, 100, 45);
		loginButton.setBorder(new LineBorder(Color.BLACK));
		frame.getContentPane().add(loginButton);
		
		JLabel weScheduleLabel = new JLabel("WeSchedule");
		weScheduleLabel.setForeground(new Color(0, 0, 0));
		weScheduleLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		weScheduleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weScheduleLabel.setBounds(100, 11, 237, 67);
		frame.getContentPane().add(weScheduleLabel);
	}
}
