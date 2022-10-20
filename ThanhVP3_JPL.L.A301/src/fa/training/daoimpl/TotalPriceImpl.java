package fa.training.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fa.training.dao.TotalPriceDao;
import fa.training.entities.Order;
import fa.training.entities.TotalPrice;

public class TotalPriceImpl implements TotalPriceDao{

@Override
public TotalPrice getTotalPrice(int cusId) throws SQLException {
	String sqlQuery = "select CustomerId,SUM(Total) as  Total_Price\r\n"
			+ "from Orders \r\n"
			+ "where CustomerId = ?\r\n"
			+ "group by CustomerId";
	PreparedStatement statement = null;
	ResultSet rs = null;
	try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
		statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, cusId);
		rs = statement.executeQuery();
		if (rs.next()) {
			return new TotalPrice(rs.getInt(1),rs.getDouble(2));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.printf("[ERROR] ", e);
	} finally {
		DatabaseConnection.close(statement, null);
	}
	return null;
}

   
}
