package fa.training.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import fa.training.dao.CusSuperDao;
import fa.training.entities.CusSuper;
import fa.training.entities.Customer;

public class CusSuperDaoImpl implements CusSuperDao{

	@Override
	public List<CusSuper> getCusSuperByCusId(int cid) throws SQLException {
		List<CusSuper> list = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		String sqlQuery = "SELECT  e.EmployeeName,sp.EmployeeName as SupervisorName, dbo.Orders.OrderId, dbo.Orders.Total\r\n"
				+ "FROM     dbo.Employee e INNER JOIN\r\n"
				+ "                  dbo.Employee AS sp ON e.SupervisorId = sp.EmployeeId INNER JOIN\r\n"
				+ "                  dbo.Orders ON e.EmployeeId = dbo.Orders.EmployeeId AND e.EmployeeId = dbo.Orders.EmployeeId INNER JOIN\r\n"
				+ "                  dbo.Customer ON dbo.Orders.CustomerId = dbo.Customer.CustomerId\r\n"
				+ "where dbo.Customer.CustomerId = ?";
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, cid);
			rs = statement.executeQuery();
			if (rs.next()) {
				list.add(new CusSuper(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4))) ;
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("[ERROR] ", e);
		} finally {
			DatabaseConnection.close(statement, rs);
		}
		return null;
	}

}
