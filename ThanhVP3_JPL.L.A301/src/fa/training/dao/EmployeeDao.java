package fa.training.dao;

import java.sql.SQLException;
import java.util.List;

import fa.training.entities.Employee;

public interface EmployeeDao {
	public boolean insert(Employee employee) throws SQLException;

	public Employee getEmployeeById(int id) throws SQLException;
	
	public List<Employee> getAll() throws SQLException;
}