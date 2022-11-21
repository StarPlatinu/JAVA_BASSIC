package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Member;

public class MemberDao {

	public void addNewMember(Member member) {
		PreparedStatement prepareStatement = null;
		
		try{
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("INSERT INTO [dbo].[Member]\r\n"
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
					+ "         (?,?,?,?,?,?,?,?,?)");
			
					prepareStatement.executeUpdate();
			         
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}
	


}
