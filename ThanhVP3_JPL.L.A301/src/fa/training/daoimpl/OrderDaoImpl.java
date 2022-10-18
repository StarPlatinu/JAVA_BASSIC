package fa.training.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.dao.OrderDao;
import fa.training.entities.Order;

public class OrderDaoImpl implements OrderDao {

	@Override
	public List<Order> getAllOrdersByCustomer(int customerId) throws SQLException {
		String sqlQuery = "SELECT OrderId, OrderDate, CustomerId, EmployeeId, Total FROM Orders where CustomerId = ?";
		List<Order> orders = new ArrayList<Order>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, customerId);
			rs = statement.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setOrderDate(rs.getDate(2));
				order.setCustomerId(rs.getInt(3));
				order.setEmployeeId(rs.getInt(4));
				order.setTotal(rs.getDouble(5));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("[ERROR] ", e);
		} finally {
			DatabaseConnection.close(statement, rs);
		}
		return orders.size() > 0 ? orders : null;
	}

	@Override
	public double computeAllOrders() throws SQLException {
		String sqlCall = "EXEC SP_Orders_ComputeAllOrders";
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			CallableStatement statement = connection.prepareCall(sqlCall);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getDouble(1);
			}
		}
		return 0;
	}

	@Override
	public boolean addOrder(Order order) throws SQLException {
		String sqlQuery = "INSERT INTO Orders(CustomerId, EmployeeId, OrderDate) VALUES(?, ?, ?)";
		PreparedStatement statement = null;
		boolean result = false;
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, order.getCustomerId());
			statement.setInt(2, order.getEmployeeId());
			statement.setDate(3, order.getOrderDate());
			result = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("[ERROR] ", e);
		} finally {
			DatabaseConnection.close(statement, null);
		}
		return result;
	}

	@Override
	public Order getOrderById(int id) throws SQLException {
		String sqlQuery = "SELECT OrderId, CustomerId, EmployeeId, Total, OrderDate FROM Orders WHERE OrderId = ?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if (rs.next()) {
				return new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("[ERROR] ", e);
		} finally {
			DatabaseConnection.close(statement, null);
		}
		return null;
	}

	@Override
	public boolean updateOrderTotal(int orderId) throws SQLException {
		String sqlCall = "EXEC SP_Orders_UpdateTotal ?";
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			CallableStatement statement = connection.prepareCall(sqlCall);
			statement.setInt(1, orderId);
			return statement.execute();
		}
	}

}
