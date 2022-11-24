package dao;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Content;

public class ContentDao {

	public void addContent(Content c) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"INSERT INTO [dbo].[Content]\r\n"
					+ "           ([Title]\r\n"
					+ "           ,[Brief]\r\n"
					+ "           ,[Content]\r\n"
					+ "           ,[CreatedDate]\r\n"
					+ "           ,[UpdateTime]\r\n"
					+ "           ,[Sort]\r\n"
					+ "           ,[AuthorId])\r\n"
					+ "     VALUES\r\n"
					+ "           (?,?,?,?,?,?,?)");
			prepareStatement.setString(1, c.getTitle());
			prepareStatement.setString(2, c.getBrief());
			prepareStatement.setString(3,c.getContent());
			prepareStatement.setString(4, c.getCreatedDate());
			prepareStatement.setString(5, c.getUpdateTime());
			prepareStatement.setInt(6, c.getSort());
			prepareStatement.setInt(7, c.getAuthorId());
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}

	public List<Content> getContentByTitle(String title) {
		// TODO Auto-generated method stub
		List<Content> list = new ArrayList<>();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("Select * from Content where Title like '%"+title+"%'");		
			rs = prepareStatement.executeQuery();
			while(rs.next()) {
				Content c = new Content(rs.getString("Title"),rs.getString("Brief"), rs.getString("Content"), rs.getString("CreatedDate"), rs.getString("UpdateTime"), rs.getInt("Sort"), rs.getInt("AuthorId"));
			    list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return list;
	}
	
	public List<Content> getListByPage(ArrayList<Content> list,int start,int end){
		ArrayList<Content> arr = new ArrayList<>();
		for(int i = start;i>end;i++) {
			arr.add(list.get(i));
		}
		return arr;
		
	}
	
	public static void main(String[] args) {
		List<Content> list = new ContentDao().getContentByTitle("a");
		for (Content c : list) {
			System.out.println(c.getContent());
		}
	}
	

}
