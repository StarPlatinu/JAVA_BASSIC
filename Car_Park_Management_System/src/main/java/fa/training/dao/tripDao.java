package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fa.training.util.*;
import fa.training.entity.*;

public class tripDao {

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

}
