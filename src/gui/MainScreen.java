package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainScreen extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2146520200955300204L;
	private JPanel contentPane, sidePanel;
	private JButton exitBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setTitle("WeSchedule");
		initialize();

	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 900, 450);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		createSidePanel();
		createHeadlinePanel();
		createTopPanel();

	}

	private void createSidePanel() {
		sidePanel = new JPanel();
		sidePanel.setBounds(0, 0, 216, 450);
		sidePanel.setBackground(new Color(51, 51, 51));
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		createBarPanel();
	}

	private void createBarPanel()
	{
		JPanel barPanel = new JPanel();
		barPanel.setBounds(0, 11, 216, 45);
		barPanel.setBackground(new Color(151, 51, 51));
		sidePanel.add(barPanel);
		barPanel.setLayout(null);
	}
	private void createHeadlinePanel() {
		JPanel headlinePanel = new JPanel();
		headlinePanel.setBounds(215, 67, 685, 69);
		headlinePanel.setBackground(new Color(51, 51, 51));
		contentPane.add(headlinePanel);
		headlinePanel.setLayout(null);
	}

	private void createTopPanel() {
		JPanel topPanel = new JPanel();
		topPanel.setBounds(215, 0, 685, 69);
		topPanel.setBackground(new Color(220, 220, 220));
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		// create the exit button
		ImageIcon exitIcon = new ImageIcon("src/images/shutdown_darkgray_26px.png");
		exitBtn = new JButton(exitIcon);
		exitBtn.setBackground(new Color(220, 220, 220));
		exitBtn.setBounds(659, 0, 26, 26);
		exitBtn.setBorder(null);
		exitBtn.addActionListener(this);
		exitBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				exitBtn.setBackground(new Color(242, 242, 242));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitBtn.setBackground(new Color(220, 220, 220));
			}
		});
		topPanel.add(exitBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitBtn)
		{
			System.exit(0);
		}
		
	}
}
