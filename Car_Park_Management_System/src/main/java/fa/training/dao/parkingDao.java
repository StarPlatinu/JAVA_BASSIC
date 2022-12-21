package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fa.training.entity.*;
import fa.training.util.DBConnection;

public class parkingDao {
	public parkingLot getparkinglotById(int tripId) {
		PreparedStatement prepareStatement = null;
        ResultSet rs = null;
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("select * from parkinglot where parkId = ?");
			prepareStatement.setInt(1, tripId);
            rs = prepareStatement.executeQuery();
            while(rs.next()) {
            	parkingLot park = parkingLot.builder()
            			.parkId(rs.getInt(1))
            			.parkArea(rs.getDouble(2))
            			.parkName(rs.getString(3))
            			.parkPlace(rs.getString(4))
            			.parkPrice(rs.getString(5))
            			.parkStatus(rs.getString(6))
            			.build();
            	return park;
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return null;
	}
	
	public List<parkingLot> getAllparkinglot() {
		PreparedStatement prepareStatement = null;
        ResultSet rs = null;
        List<parkingLot> plist = new ArrayList<>();
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("select * from parkinglot");
            rs = prepareStatement.executeQuery();
            while(rs.next()) {
            	parkingLot park = parkingLot.builder()
            			.parkId(rs.getInt(1))
            			.parkArea(rs.getDouble(2))
            			.parkName(rs.getString(3))
            			.parkPlace(rs.getString(4))
            			.parkPrice(rs.getString(5))
            			.parkStatus(rs.getString(6))
            			.build();
            	plist.add(park);
            	
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return plist;
	}
	
	public parkingLot getparkinglotName(String parking) {
		PreparedStatement prepareStatement = null;
        ResultSet rs = null;
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("select * from parkinglot where parkName = ?");
			prepareStatement.setString(1, parking);
            rs = prepareStatement.executeQuery();
            while(rs.next()) {
            	parkingLot park = parkingLot.builder()
            			.parkId(rs.getInt(1))
            			.parkArea(rs.getDouble(2))
            			.parkName(rs.getString(3))
            			.parkPlace(rs.getString(4))
            			.parkPrice(rs.getString(5))
            			.parkStatus(rs.getString(6))
            			.build();
            	return park;
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return null;
	}
	
	public List<parkingLot> getListByPage(List<parkingLot> list,int start,int end){
		List<parkingLot> arr = new ArrayList<>();
		for(int i = start;i<end;i++) {
			arr.add(list.get(i));
		}
		return arr;	
	}
	
	public List<parkingLot> getParkingLotByName(String name) {
		// TODO Auto-generated method stub
		List<parkingLot> list = new ArrayList<>();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		tripDao tdao = new tripDao();
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("Select * from parkinglot where parkName like '%"+name+"%'");		
			rs = prepareStatement.executeQuery();
			while(rs.next()) {
				parkingLot park = parkingLot.builder()
            			.parkId(rs.getInt(1))
            			.parkArea(rs.getDouble(2))
            			.parkName(rs.getString(3))
            			.parkPlace(rs.getString(4))
            			.parkPrice(rs.getString(5))
            			.parkStatus(rs.getString(6))
            			.build();
			    list.add(park);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return list;
	}
	
	public void addParking(parkingLot park) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"INSERT INTO [dbo].[parkinglot]\r\n"
					+ "           ([parkArea]\r\n"
					+ "           ,[parkName]\r\n"
					+ "           ,[parkPlace]\r\n"
					+ "           ,[parkPrice]\r\n"
					+ "           ,[parkStatus])\r\n"
					+ "     VALUES\r\n"
					+ "           (?,?,?,?,?)");
			prepareStatement.setDouble(1, park.getParkArea());
			prepareStatement.setString(2, park.getParkName());
			prepareStatement.setString(3,park.getParkPlace());
			prepareStatement.setString(4,park.getParkPrice());
			prepareStatement.setString(5,park.getParkStatus());
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}
	
	public void updateParking(parkingLot park,int parkId) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"UPDATE [dbo].[parkinglot]\r\n"
					+ "   SET [parkArea] = ?\r\n"
					+ "      ,[parkName] = ?\r\n"
					+ "      ,[parkPrice] = ?\r\n"
					+ " WHERE parkId = ?");
			prepareStatement.setDouble(1, park.getParkArea());
			prepareStatement.setString(2, park.getParkName());
			prepareStatement.setString(3,park.getParkPrice());	
			prepareStatement.setInt(4,parkId);	
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}
	
	public void deleteParkingLot(int parkId) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"DELETE FROM [dbo].[parkinglot]\r\n"
					+ "      WHERE parkId = ?");
			prepareStatement.setInt(1, parkId);
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}


}
