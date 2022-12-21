package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import fa.training.util.*;
import fa.training.entity.*;

public class bookingDao {

	public List<bookingOffice> getAll() {
		List<bookingOffice> list = new ArrayList<>();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		tripDao tdao = new tripDao();
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("Select * from bookingoffice");		
			rs = prepareStatement.executeQuery();
			while(rs.next()) {
				bookingOffice b = bookingOffice.builder()
						.officeId(rs.getInt(1))
						.endContractDateline(rs.getString(2))
						.officeName(rs.getString(3))
						.officePhone(rs.getString(4))
						.officePlace(rs.getString(5))
						.officePrice(rs.getString(6))
						.startContractDeadline(rs.getString(7))
						.tripOb(tdao.getTripById(rs.getInt(8))).build();					      
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return list;
	}
	
	public List<bookingOffice> getListByPage(List<bookingOffice> list,int start,int end){
		List<bookingOffice> arr = new ArrayList<>();
		for(int i = start;i<end;i++) {
			arr.add(list.get(i));
		}
		return arr;	
	}
	
	public List<bookingOffice> getBookingOfficeByName(String name) {
		// TODO Auto-generated method stub
		List<bookingOffice> list = new ArrayList<>();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		tripDao tdao = new tripDao();
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("Select * from bookingoffice where officeName like '%"+name+"%'order by startContractDeadline desc");		
			rs = prepareStatement.executeQuery();
			while(rs.next()) {
				bookingOffice b = bookingOffice.builder()
						.officeId(rs.getInt(1))
						.endContractDateline(rs.getString(2))
						.officeName(rs.getString(3))
						.officePhone(rs.getString(4))
						.officePlace(rs.getString(5))
						.officePrice(rs.getString(6))
						.startContractDeadline(rs.getString(7))
						.tripOb(tdao.getTripById(rs.getInt(8))).build();
			    list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return list;
	}
	
	public void addBookingOffice(bookingOffice c) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"INSERT INTO [dbo].[bookingoffice]\r\n"
					+ "           ([endContractDateline]\r\n"
					+ "           ,[officeName]\r\n"
					+ "           ,[officePhone]\r\n"
					+ "           ,[officePlace]\r\n"
					+ "           ,[officePrice]\r\n"
					+ "           ,[startContractDeadline]\r\n"
					+ "           ,[tripId])\r\n"
					+ "     VALUES\r\n"
					+ "           (?,?,?,?,?,?,?)");
			prepareStatement.setString(1, c.getEndContractDateline());
			prepareStatement.setString(2, c.getOfficeName());
			prepareStatement.setString(3,c.getOfficePhone());
			prepareStatement.setString(4, c.getOfficePlace());
			prepareStatement.setString(5, c.getOfficePrice());
			prepareStatement.setString(6, c.getStartContractDeadline());
			prepareStatement.setInt(7, c.getTripOb().getTripId());
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}
	

}
