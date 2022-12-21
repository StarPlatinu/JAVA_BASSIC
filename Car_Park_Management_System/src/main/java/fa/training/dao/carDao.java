package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fa.training.entity.car;
import fa.training.util.DBConnection;

public class carDao {
	public List<car> getAll() {
		List<car> list = new ArrayList<>();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		parkingDao d = new parkingDao();
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("Select * from car");		
			rs = prepareStatement.executeQuery();
			while(rs.next()) {
				car c = car.builder()
						.licensePlate(rs.getString(1))
						.carColor(rs.getString(2))
						.carType(rs.getString(3))
						.company(rs.getString(4))
						.park(d.getparkinglotById(rs.getInt(5)))
						.build();				      
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return list;
	}
	
	public List<car> getListByPage(List<car> list,int start,int end){
		List<car> arr = new ArrayList<>();
		for(int i = start;i<end;i++) {
			arr.add(list.get(i));
		}
		return arr;	
	}
	
	public List<car> getCarByType(String name) {
		// TODO Auto-generated method stub
		List<car> list = new ArrayList<>();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		parkingDao d = new parkingDao();
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("Select * from car where carType like '%"+name+"%'");		
			rs = prepareStatement.executeQuery();
			while(rs.next()) {
				car c = car.builder()
						.licensePlate(rs.getString(1))
						.carColor(rs.getString(2))
						.carType(rs.getString(3))
						.company(rs.getString(4))
						.park(d.getparkinglotById(rs.getInt(5)))
						.build();				      
			    list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return list;
	}
	
	public car getACar(String licensePlate) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		parkingDao d = new parkingDao();
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("Select * from car where licensePlate like '%"+licensePlate+"%'");		
			rs = prepareStatement.executeQuery();
			while(rs.next()) {
				car c = car.builder()
						.licensePlate(rs.getString(1))
						.carColor(rs.getString(2))
						.carType(rs.getString(3))
						.company(rs.getString(4))
						.park(d.getparkinglotById(rs.getInt(5)))
						.build();				      
			    return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return null;
	}
	
	public void addCar(car c) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"INSERT INTO [dbo].[car]\r\n"
					+ "           ([licensePlate]\r\n"
					+ "           ,[carColor]\r\n"
					+ "           ,[carType]\r\n"
					+ "           ,[company]\r\n"
					+ "           ,[parkId])\r\n"
					+ "     VALUES\r\n"
					+ "           (?,?,?,?,?)");
			prepareStatement.setString(1, c.getLicensePlate());
			prepareStatement.setString(2, c.getCarColor());
			prepareStatement.setString(3,c.getCarType());
			prepareStatement.setString(4, c.getCompany());
			prepareStatement.setInt(5, c.getPark().getParkId());
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}
	
	public void updateCar(car c) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"UPDATE [dbo].[car]\r\n"
					+ "   SET [carColor] = ?\r\n"
					+ "      ,[carType] = ?\r\n"
					+ "      ,[company] = ?\r\n"
					+ " WHERE licensePlate = ?");		
			prepareStatement.setString(1, c.getCarColor());
			prepareStatement.setString(2,c.getCarType());
			prepareStatement.setString(3, c.getCompany());
			prepareStatement.setString(4,c.getLicensePlate());
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}
	
	public void deleteCar(String licensePlate) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"DELETE FROM [dbo].[car]\r\n"
					+ "      WHERE licensePlate = ?");
			prepareStatement.setString(1, licensePlate);
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}
	
}
