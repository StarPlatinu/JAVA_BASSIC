package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fa.training.entity.ticket;
import fa.training.util.DBConnection;

public class ticketDao {

	public List<ticket> getAll() {
		List<ticket> list = new ArrayList<>();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		tripDao tdao = new tripDao();
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("Select * from ticket");		
			rs = prepareStatement.executeQuery();
			while(rs.next()) {
				ticket t = ticket.builder()
						.ticketId(rs.getInt(1))
						.bookingTime(rs.getString(2))
						.customerName(rs.getString(3))
						.licensePlate(rs.getString(4))
						.trip(tdao.getTripById(rs.getInt(5)))
						.build();					      
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return list;
	}
	
	public List<ticket> getListByPage(List<ticket> list,int start,int end){
		List<ticket> arr = new ArrayList<>();
		for(int i = start;i<end;i++) {
			arr.add(list.get(i));
		}
		return arr;	
	}
	
	public List<ticket> getTickets(String name) {
		// TODO Auto-generated method stub
		List<ticket> list = new ArrayList<>();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		tripDao tdao = new tripDao();
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("Select * from ticket where licensePlate like '%"+name+"%'");		
			rs = prepareStatement.executeQuery();
			while(rs.next()) {
				ticket t = ticket.builder()
						.ticketId(rs.getInt(1))
						.bookingTime(rs.getString(2))
						.customerName(rs.getString(3))
						.licensePlate(rs.getString(4))
						.trip(tdao.getTripById(rs.getInt(5)))
						.build();					      
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return list;
	}
	
	public void addTicket(ticket t) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"INSERT INTO [dbo].[ticket]\r\n"
					+ "           ([bookingTime]\r\n"
					+ "           ,[customerName]\r\n"
					+ "           ,[licensePlate]\r\n"
					+ "           ,[tripId])\r\n"
					+ "     VALUES\r\n"
					+ "           (?,?,?,?)");
			prepareStatement.setString(1, t.getBookingTime());
			prepareStatement.setString(2, t.getCustomerName());
			prepareStatement.setString(3,t.getLicensePlate());
			prepareStatement.setInt(4, t.getTrip().getTripId());
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}
	
	public void deleteTicket(int ticketId) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"DELETE FROM [dbo].[ticket]\r\n"
					+ "      WHERE ticketId = ?");
			prepareStatement.setInt(1,ticketId);
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}

}
