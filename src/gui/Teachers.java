package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import sun.awt.DefaultMouseInfoPeer;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Teachers extends JFrame {

	private JPanel contentPane;
	private JTextField teacherNameTF;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private Integer teacherId = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teachers frame = new Teachers();
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
	public Teachers() {
		setTitle("Teachers Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel teacherNameTL = new JLabel("Teacher Name:");
		teacherNameTL.setBounds(10, 60, 121, 14);
		contentPane.add(teacherNameTL);

		teacherNameTF = new JTextField();
		teacherNameTF.setBounds(105, 57, 150, 20);
		contentPane.add(teacherNameTF);
		teacherNameTF.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 549, 205);
		contentPane.add(scrollPane);

		
		model = new DefaultTableModel();
		String[] columnNames = { "ID", "Name" };
		final Object[] row = new Object[2];		
		table = new JTable(model) {
			public boolean isCellEditable(int data, int columns)
			{
				return false;
			}
		};
		table.setFillsViewportHeight(true);
		table.setOpaque(false);
		table.setBackground(new Color(112, 128, 144));
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		scrollPane.setViewportView(table);

		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (teacherNameTF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Plase Fill Teacher Name", "Error - Missing Information",
							JOptionPane.ERROR_MESSAGE);
				} else {
					row[0] = teacherId++;
					row[1] = teacherNameTF.getText();
					model.addRow(row);
					teacherNameTF.setText("");
					JOptionPane.showMessageDialog(null, "Saved Successfully", "Information Saved",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		addButton.setBounds(20, 327, 89, 23);
		contentPane.add(addButton);

		JButton delButton = new JButton("Delete");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0)
				{
				model.removeRow(i);
				teacherId--;
				JOptionPane.showMessageDialog(null, "Deleted Successfully", "Information Deleted",
						JOptionPane.INFORMATION_MESSAGE);				
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Plase Select a Row First", "Error - No Rows Selected",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		delButton.setBounds(119, 327, 89, 23);
		contentPane.add(delButton);

		JButton clrButton = new JButton("Clear");
		clrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherNameTF.setText("");
			}
		});
		clrButton.setBounds(282, 56, 89, 23);
		contentPane.add(clrButton);
	}
}
