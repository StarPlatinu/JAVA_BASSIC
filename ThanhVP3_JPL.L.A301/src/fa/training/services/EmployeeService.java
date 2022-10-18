package fa.training.services;

import java.sql.SQLException;
import java.util.List;
import fa.training.dao.EmployeeDao;
import fa.training.daoimpl.EmployeeDaoImpl;
import fa.training.entities.Employee;

public class EmployeeService {
	EmployeeDao employeeDao;

	public EmployeeService() {
		employeeDao = new EmployeeDaoImpl();
	}

	public boolean insertEmployee(Employee employee) {
		try {
			return employeeDao.insert(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Employee> getAllEmployee() {
		try {
			return employeeDao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee getEmployeeById(int id) {
		try {
			return employeeDao.getEmployeeById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}