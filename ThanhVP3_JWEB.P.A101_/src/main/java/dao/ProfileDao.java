package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Member;
import model.User;

public class ProfileDao {
	

	public void updateProfile(Member member,String uname) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"UPDATE [dbo].[Member]\r\n"
					+ "   SET [Firstname] = ?\r\n"
					+ "      ,[Lastname] = ?\r\n"
					+ "      ,[Username] = ?\r\n"
					+ "      ,[Password] =?\r\n"
					+ "      ,[Phone] = ?\r\n"
					+ "      ,[Email] = ?\r\n"
					+ "      ,[Description] = ?\r\n"
					+ "      ,[CretaedDate] = ?\r\n"
					+ "      ,[UpdateTime] = ?\r\n"
					+ " WHERE Username = ?");
			prepareStatement.setString(1, member.getFirstname());
			prepareStatement.setString(2, member.getLastname());
			prepareStatement.setString(3, member.getUsername());
			prepareStatement.setString(4, member.getPassword());
			prepareStatement.setString(5, member.getPhone());
			prepareStatement.setString(6, member.getEmail());
			prepareStatement.setString(7, member.getDescription());
			prepareStatement.setString(8, member.getCreatedDate());
			prepareStatement.setString(9, member.getUpdateTime());
			prepareStatement.setString(10, uname);
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}

	public void addNewProfile(Member member) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"INSERT INTO [dbo].[Member]\r\n"
					+ "           ([Firstname]\r\n"
					+ "           ,[Lastname]\r\n"
					+ "           ,[Username]\r\n"
					+ "           ,[Password]\r\n"
					+ "           ,[Phone]\r\n"
					+ "           ,[Email]\r\n"
					+ "           ,[Description]\r\n"
					+ "           ,[CretaedDate]\r\n"
					+ "           ,[UpdateTime])\r\n"
					+ "     VALUES\r\n"
					+ "           (?,?,?,?,?,?,?,?,?)");
			prepareStatement.setString(1, member.getFirstname());
			prepareStatement.setString(2, member.getLastname());
			prepareStatement.setString(3, member.getUsername());
			prepareStatement.setString(4, member.getPassword());
			prepareStatement.setString(5, member.getPhone());
			prepareStatement.setString(6, member.getEmail());
			prepareStatement.setString(7, member.getDescription());
			prepareStatement.setString(8, member.getCreatedDate());
			prepareStatement.setString(9, member.getUpdateTime());
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}

	public Member getMemberByUsername(String uname) {
		PreparedStatement prepareStatement = null;
        ResultSet rs = null;
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("select * from Member where Username = ?");
			prepareStatement.setString(1, uname);
            rs = prepareStatement.executeQuery();
            while(rs.next()) {
            	Member m = new Member();       
            	m.setFirstname(rs.getString(2));
            	m.setLastname(rs.getString(3));
            	m.setUsername(rs.getString(4));
            	m.setPassword(rs.getString(5));
            	m.setPhone(rs.getString(6));
            	m.setEmail(rs.getString(7));
            	m.setDescription(rs.getString(8));
            	m.setCreatedDate(rs.getString(9));
            	m.setUpdateTime(rs.getString(10));
            	return m;
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return null;
	}
}
