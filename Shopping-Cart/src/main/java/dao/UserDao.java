package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDao {
	private static int ID =2;

	public boolean save(User user) {
		PreparedStatement prepareStatement = null;
		try{
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("INSERT INTO [user](id,name,email,[password]) values(?,?,?,?,?)");
			prepareStatement.setInt(1,++ID);
			prepareStatement.setString(2,user.getName());
			prepareStatement.setString(3,user.getEmail());
			prepareStatement.setString(4,user.getPassword());
			return prepareStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
		return false;
	}

	public User userLogin(String email, String password) {
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		User user = null;
		try{
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("Select * from users where email=? and password=?");
			prepareStatement.setString(1, email);
			prepareStatement.setString(2, password);
			rs = prepareStatement.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return user;
	}
}
