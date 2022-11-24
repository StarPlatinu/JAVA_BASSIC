package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDao {

	public void addNewUser(User user) {
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"INSERT INTO [dbo].[Users]\r\n" + "           ([Username]\r\n" + "           ,[Email]\r\n"
							+ "           ,[Password])\r\n" + "     VALUES\r\n" + "           (?,?,?)");
			prepareStatement.setString(1, user.getUsername());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.setString(3, user.getPassword());
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}

	public User getAUser(String username, String password) {
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("select * from Users where Username = ? and Password = ?");
			prepareStatement.setString(1, username);
			prepareStatement.setString(2, password);
			rs = prepareStatement.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString(2), rs.getString(3), rs.getString(4));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return null;
	}

}
