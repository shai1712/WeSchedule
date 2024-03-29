package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.MainScreen;
import gui.ManagementSystem;

public class Login {

	private JTextField usernameTF;
	private JPasswordField passwordPF;

	public Login(JTextField username, JPasswordField password) {
		this.usernameTF = username;
		this.passwordPF = password;
	}

	public int login() {
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
				// frame.dispose();
				JOptionPane.showMessageDialog(null, "Successfully Signed in", "WeSchedule - Signed In Successfully",
						JOptionPane.INFORMATION_MESSAGE);
				return 0;
			} else {
				JOptionPane.showMessageDialog(null, "Wrong Username or Password", "Error - Wrong Information",
						JOptionPane.ERROR_MESSAGE);
				return -1;
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return 0;
	}

}
