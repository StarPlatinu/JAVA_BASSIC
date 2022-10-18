package fa.training.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.dao.EmployeeDao;
import fa.training.entities.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public boolean insert(Employee employee) throws SQLException {
		if (employee == null) {
			return false;
		}
		PreparedStatement statement = null;
		boolean result = false;

		String sqlQuery = "INSERT INTO Employee VALUES (?, ?, ?)";
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, employee.getEmployeeName());
			statement.setDouble(2, employee.getSalary());
			statement.setInt(3, employee.getSpvrId());
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
	public Employee getEmployeeById(int id) throws SQLException {
		if (id < 0) {
			return null;
		}
		PreparedStatement statement = null;
		ResultSet rs = null;
		String sqlQuery = "SELECT EmployeeId, EmployeeName, Salary, SupervisorId FROM Employee WHERE EmployeeId = ?";
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if (rs.next()) {
				return new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
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
	public List<Employee> getAll() throws SQLException {
		String sqlQuery = "SELECT EmployeeId, EmployeeName, Salary, SupervisorId FROM Employee";
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Employee> employees = new ArrayList<Employee>();
		try (Connection connection = DatabaseConnection.DBConnection.getConnection()) {
			statement = connection.prepareStatement(sqlQuery);
			rs = statement.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("[ERROR] ", e);
		} finally {
			DatabaseConnection.close(statement, rs);
		}
		return employees.size() > 0 ? employees : null;
	}

}
