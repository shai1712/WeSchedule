package main_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Main extends JFrame implements ActionListener {
	private JMenuItem helpItem, exitItem;
	private JButton registerButton = new JButton("Register"), loginButton = new JButton("Login");

	public Main() {
		setTitle("WeScehdule");
		setSize(400,300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setResizable(false);
		createMainMenu();
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main mainFrame = new Main();
	}

	public void createMainMenu() {
		// create the menu bar
		JMenuBar menuBar = new JMenuBar();

		// create the headers
		JMenu file = new JMenu("File"), help = new JMenu("Help");
		menuBar.add(file);
		menuBar.add(help);

		// create the menu items
		helpItem = new JMenuItem("Help");
		exitItem = new JMenuItem("Exit");
		file.add(exitItem);
		help.add(helpItem);
		
		addActionListener();
		centralPanelCreator();
		// add the menu bar to the Frame
		add(menuBar, BorderLayout.PAGE_START);
		// add(loginButton,BorderLayout.EAST);
		// add(registerButton,BorderLayout.WEST);
	}

	public void centralPanelCreator()
	{
		JPanel centralPanel = new JPanel(null);
		
		// define the login & register buttons
		loginButton.setBackground(Color.GRAY);
		registerButton.setBackground(Color.GRAY);
		
		loginButton.setBorder(new LineBorder(Color.BLACK));
		registerButton.setBorder(new LineBorder(Color.BLACK));

		loginButton.setBounds(200,75,100,50);
		registerButton.setBounds(75,75,100,50);
		centralPanel.add(registerButton);
		centralPanel.add(loginButton);
		centralPanel.setVisible(true);
		add(centralPanel, BorderLayout.CENTER);
	}

	
	public void addActionListener() {
		helpItem.addActionListener(this);
		exitItem.addActionListener(this);
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == helpItem)
			JOptionPane.showMessageDialog(null, "WeSchedule\nMade By: Shay Shitrit & Amit Amir");
		else if (e.getSource() == exitItem)
			System.exit(0);
	}
}