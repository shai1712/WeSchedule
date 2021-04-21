package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp {

	private JTextField firstNameTF, lastNameTF, usernameTF;
	private JPasswordField passwordPF;

	public SignUp(JTextField firstName, JTextField lastName, JTextField username, JPasswordField password) {
		this.firstNameTF = firstName;
		this.lastNameTF = lastName;
		this.usernameTF = username;
		this.passwordPF = password;
	}

	public int register() {
		String firstName = firstNameTF.getText();
		String lastName = lastNameTF.getText();
		String username = usernameTF.getText();
		char[] pass = passwordPF.getPassword();
		String password = new String(pass);
		String fn = firstName;

		if (!(firstName.matches("[a-zA-Z]+") && lastName.matches("[a-zA-Z]+") && username.matches("[a-zA-Z0-9]+")
				&& password.length() > 0)) {
			JOptionPane.showMessageDialog(null, "Please Fill Valid Information", "Error - Invalid Information",
					JOptionPane.ERROR_MESSAGE);
			return -1;
		} else {
			String msg = "" + fn;
			msg += " \n";
			try {
				Connection connection = (Connection) DriverManager
						.getConnection("jdbc:mysql://127.0.0.1:3306/WeSchedule", "root", "root");

				PreparedStatement ps = (PreparedStatement) connection
						.prepareStatement("Select user_name from account where user_name=?");

				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "Username already taken", "Error - Username Unavailable",
							JOptionPane.ERROR_MESSAGE);
					return -1;
				} else {
					String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + username
							+ "','" + password + "')";

					Statement sta = connection.createStatement();
					int x = sta.executeUpdate(query);
					if (x != 0) {
						JOptionPane.showMessageDialog(null, "Welcome, " + msg + "Your account is sucessfully created",
								"WeSchedule - Registration Completed", JOptionPane.INFORMATION_MESSAGE);
						return 0;
					}
					connection.close();
					return 0;
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return 0;
	}
}
