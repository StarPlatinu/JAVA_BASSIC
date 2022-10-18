package fa.training.services;

import java.sql.SQLException;
import java.util.List;
import fa.training.dao.CustomerDao;
import fa.training.daoimpl.CustomerDaoImpl;
import fa.training.entities.Customer;

public class CustomerService {
	CustomerDao customerDao;

	public CustomerService() {
		customerDao = new CustomerDaoImpl();
	}

	public boolean addCustomer(String customerName) {
		try {
			customerDao.insertCustomer(customerName);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteCustomer(int customerId) {
		try {
			Customer customer = customerDao.getCustomerById(customerId);
			if (customer == null) {
				return false;
			}
			return customerDao.deleteCustomer(customer.getCustomerId());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean updateCustomer(Customer customer) {
		try {
			if (customer == null) {
				return false;
			}
			customerDao.updateCustomer(customer);
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public List<Customer> getAllCustomer() {
		try {
			return customerDao.getAll();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Customer getCustomerById(int id) {
		try {
			return customerDao.getCustomerById(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
