package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fa.training.util.*;
import fa.training.entity.*;

public class tripDao {
	public List<trip> getAll() {
		PreparedStatement prepareStatement = null;
        ResultSet rs = null;
        List<trip> list = new ArrayList<>();
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("select * from trip");
            rs = prepareStatement.executeQuery();
            while(rs.next()) {
            	trip m = trip.builder().tripId(rs.getInt(1))
            			.bookedTicketNumber(rs.getString(2))
            			.carType(rs.getString(3))
            			.departureDate(rs.getString(4))
            			.departureTime(rs.getString(5))
            			.destination(rs.getString(6))
            			.driver(rs.getString(7))
            			.maximumOnlineTicketNumber(rs.getString(8))
            			.build();
            	list.add(m);
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return list;
	}

	public trip getTripById(int tripId) {
		PreparedStatement prepareStatement = null;
        ResultSet rs = null;
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("select * from trip where tripId = ?");
			prepareStatement.setInt(1, tripId);
            rs = prepareStatement.executeQuery();
            while(rs.next()) {
            	trip m = trip.builder().tripId(rs.getInt(1))
            			.bookedTicketNumber(rs.getString(2))
            			.carType(rs.getString(3))
            			.departureDate(rs.getString(4))
            			.departureTime(rs.getString(5))
            			.destination(rs.getString(6))
            			.driver(rs.getString(7))
            			.maximumOnlineTicketNumber(rs.getString(8))
            			.build();
  	
            	return m;
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return null;
	}

	public trip getIdByTripName(String destination) {
		PreparedStatement prepareStatement = null;
        ResultSet rs = null;
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("select * from trip where destination = ?");
			prepareStatement.setString(1, destination);
            rs = prepareStatement.executeQuery();
            while(rs.next()) {
            	trip m = trip.builder().tripId(rs.getInt(1))
            			.bookedTicketNumber(rs.getString(2))
            			.carType(rs.getString(3))
            			.departureDate(rs.getString(4))
            			.departureTime(rs.getString(5))
            			.destination(rs.getString(6))
            			.driver(rs.getString(7))
            			.maximumOnlineTicketNumber(rs.getString(8))
            			.build();
            	return m;
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return null;
	}
	
	public List<trip> getListTrip(String destination) {
		PreparedStatement prepareStatement = null;
        ResultSet rs = null;
        List<trip> list = new ArrayList<>();
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("select * from trip where destination like '%"+destination+"%'");
            rs = prepareStatement.executeQuery();
            while(rs.next()) {
            	trip t = trip.builder().tripId(rs.getInt(1))
            			.bookedTicketNumber(rs.getString(2))
            			.carType(rs.getString(3))
            			.departureDate(rs.getString(4))
            			.departureTime(rs.getString(5))
            			.destination(rs.getString(6))
            			.driver(rs.getString(7))
            			.maximumOnlineTicketNumber(rs.getString(8))
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
	
	public List<trip> getListByPage(List<trip> list,int start,int end){
		List<trip> arr = new ArrayList<>();
		for(int i = start;i<end;i++) {
			arr.add(list.get(i));
		}
		return arr;	
	}
	
	
	public void addTrip(trip t) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"INSERT INTO [dbo].[trip]\r\n"
					+ "           ([bookedTicketNumber]\r\n"
					+ "           ,[carType]\r\n"
					+ "           ,[departureDate]\r\n"
					+ "           ,[departureTime]\r\n"
					+ "           ,[destination]\r\n"
					+ "           ,[driver]\r\n"
					+ "           ,[maximumOnlineTicketNumber])\r\n"
					+ "     VALUES\r\n"
					+ "           (?,?,?,?,?,?,?)");
			prepareStatement.setString(1,t.getBookedTicketNumber());
			prepareStatement.setString(2,t.getCarType());
			prepareStatement.setString(3,t.getDepartureDate());
			prepareStatement.setString(4,t.getDepartureTime());
			prepareStatement.setString(5,t.getDestination());
			prepareStatement.setString(6,t.getDriver());
			prepareStatement.setString(7,t.getMaximumOnlineTicketNumber());
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}
	
	public void updateTrip(trip t,int tripId) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"UPDATE [dbo].[trip]\r\n"
					+ "   SET [bookedTicketNumber] = ?\r\n"
					+ "      ,[carType] = ?\r\n"
					+ "      ,[departureDate] = ?\r\n"
					+ "      ,[departureTime] = ?\r\n"
					+ "      ,[destination] = ?\r\n"
					+ "      ,[driver] = ?\r\n"
					+ "      ,[maximumOnlineTicketNumber] = ?\r\n"
					+ " WHERE tripId = ?");
			prepareStatement.setString(1,t.getBookedTicketNumber());
			prepareStatement.setString(2,t.getCarType());
			prepareStatement.setString(3,t.getDepartureDate());
			prepareStatement.setString(4,t.getDepartureTime());
			prepareStatement.setString(5,t.getDestination());
			prepareStatement.setString(6,t.getDriver());
			prepareStatement.setString(7,t.getMaximumOnlineTicketNumber());
			prepareStatement.setInt(8,tripId);
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}
	
	public void deleteTrip(int id) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"DELETE FROM [dbo].[trip]\r\n"
					+ "      WHERE tripId = ?");
			prepareStatement.setInt(1,id);
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}

}
