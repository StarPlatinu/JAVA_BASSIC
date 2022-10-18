package fa.training.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fa.training.dao.ItemDao;
import fa.training.entities.Item;
import fa.training.util.DatabaseConnection;
import fa.training.impl.*;
public class ItemDaoImpl implements ItemDao {

	@Override
	public boolean save(Item item) {

		if(item == null) {
			return false;
		}
		
		PreparedStatement prepareStatement = null;
		boolean result = false;
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {

			prepareStatement = connection.prepareStatement("insert into item(id, name,quantity,price, createdOn) "
																		+ "values (?,?,?,?,?)");
			prepareStatement.setInt(1, item.getId());
			prepareStatement.setString(2, item.getName());
			prepareStatement.setInt(3, item.getQuantity());
			prepareStatement.setFloat(4, item.getPrice());
			
			
			DateTimeFormatter  dateFormat= DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String date = dateFormat.format(item.getCreatedOn());
			prepareStatement.setString(5, date);
			

			result =  prepareStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("[ERROR] ", e);
		} finally {
			DatabaseConnection.close(prepareStatement, null);
		}

		return result;
	}

	
	public static void main(String[] args) {
		ItemDao itemDao = new ItemDaoImpl();
		itemDao.save(new Item(14, "iteam 14", 0, 0, LocalDate.of(2022, 12, 12), null));
		System.out.println(itemDao.getById(14));
	}
	
	@Override
	public Item getById(int id) {
		if(id<0) {
			return null;
		}
		
		PreparedStatement prepareStatement = null;
		ResultSet resultSet= null;
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {

			prepareStatement = connection.prepareStatement("select * from item where id = ?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			Item item = null;
			
			if(resultSet.next()) {
				item = new Item(resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getInt("quantity"),
						resultSet.getFloat("price"), 
						resultSet.getDate("createdOn") == null? null : resultSet.getDate("createdOn").toLocalDate(), 
						resultSet.getDate("modifiedDate") == null? null : resultSet.getDate("createdOn").toLocalDate());
			}
			return item;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("[ERROR] ", e);
		} finally {
			DatabaseConnection.close(prepareStatement, resultSet);
		}

		return null;
	}

	@Override
	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Item item) {
		// TODO Auto-generated method stub
		return false;
	}
}
