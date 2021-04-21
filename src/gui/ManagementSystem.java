package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class ManagementSystem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementSystem frame = new ManagementSystem();
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
	public ManagementSystem() {
		setTitle("WeSchedule");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 340);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("MenuBar.background"));
		menuBar.setToolTipText("This is the menu bar");
		menuBar.setFont(UIManager.getFont("MenuBar.font"));
		setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("File");
//		fileMenu.setIcon(new ImageIcon(Main.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		fileMenu.setFont(UIManager.getFont("Menu.font"));
		menuBar.add(fileMenu);

		JMenuItem exitItem = new JMenuItem("Exit");
//		exitItem.setIcon(new ImageIcon(Main.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Teachers");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 11, 180, 60);
		contentPane.add(btnNewButton);

		JButton btnClasses = new JButton("Classes");
		btnClasses.setBounds(294, 11, 180, 60);
		contentPane.add(btnClasses);

		JButton btnCourses = new JButton("Courses");
		btnCourses.setBounds(10, 123, 180, 60);
		contentPane.add(btnCourses);

		JButton btnWip = new JButton("WIP");
		btnWip.setBounds(294, 123, 180, 60);
		contentPane.add(btnWip);
	}
}
