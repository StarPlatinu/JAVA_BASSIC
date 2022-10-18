package fa.training.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.dao.LineItemDao;
import fa.training.entities.LineItem;

public class LineItemDaoImpl implements LineItemDao {

	@Override
	public List<LineItem> getAllItemsByOrderId(int orderId) throws SQLException {
		String sqlQuery = "SELECT OrderId, ProductId, Quantity, Price FROM LineItem WHERE OrderId = ?";
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<LineItem> lineItems = new ArrayList<LineItem>();
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, orderId);
			rs = statement.executeQuery();
			while (rs.next()) {
				LineItem lineItem = new LineItem();
				lineItem.setOrderId(rs.getInt(1));
				lineItem.setProductId(rs.getInt(2));
				lineItem.setQuantity(rs.getInt(3));
				lineItem.setPrice(rs.getDouble(4));
				lineItems.add(lineItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("[ERROR] ", e);
		} finally {
			DatabaseConnection.close(statement, null);
		}
		return lineItems.size() > 0 ? lineItems : null;
	}

	@Override
	public boolean addLineItem(LineItem lineItem) throws SQLException {
		String sqlQuery = "INSERT INTO LineItem(OrderId, ProductId, Quantity) VALUES (?, ?, ?)";
		PreparedStatement statement = null;
		boolean result = false;
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, lineItem.getOrderId());
			statement.setInt(2, lineItem.getProductId());
			statement.setInt(3, lineItem.getQuantity());
			result = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("[ERROR] ", e);
		} finally {
			DatabaseConnection.close(statement, null);
		}
		return result;
	}

}
