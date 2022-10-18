package fa.training.daoimpl;
import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.dao.CustomerDao;
import fa.training.entities.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> getAll() throws SQLException {
		String sqlQuery = "SELECT CustomerId, CustomerName FROM Customer";
		List<Customer> customers = new ArrayList<Customer>();
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customers.add(customer);
			}
		}
		return customers.size() > 0 ? customers : null;
	}

	@Override
	public void insertCustomer(String customerName) throws SQLException {
		PreparedStatement statement = null;
		String sqlQuery = "INSERT INTO Customer (CustomerName) Values (?)";
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, customerName);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("[ERROR] ", e);
		} finally {
			DatabaseConnection.close(statement, null);
		}
	}

	@Override
	public void updateCustomer(Customer customer) throws SQLException {
		PreparedStatement statement = null;
		String sqlQuery = "UPDATE Customer SET CustomerName = ? WHERE CustomerId = ?";
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, customer.getCustomerName());
			statement.setInt(2, customer.getCustomerId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("[ERROR] ", e);
		} finally {
			DatabaseConnection.close(statement, null);
		}
	}

	@Override
	public Customer getCustomerById(int id) throws SQLException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		String sqlQuery = "SELECT CustomerId, CustomerName FROM Customer WHERE CustomerId = ?";
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if (rs.next()) {
				return new Customer(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("[ERROR] ", e);
		} finally {
			DatabaseConnection.close(statement, rs);
		}
		return null;
	}

	@Override
	public boolean deleteCustomer(int id) throws SQLException {
		String sqlQuery = "EXEC SP_Customer_DeleteCustomer ?";
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			CallableStatement statement = connection.prepareCall(sqlQuery);
			statement.setInt(1, id);
			return statement.executeUpdate() == 1 ? true : false;
		}
	}

}
