package fa.training.dao;

import java.sql.SQLException;
import java.util.List;
import fa.training.entities.Customer;

public interface CustomerDao {
	public List<Customer> getAll() throws SQLException;

	public void insertCustomer(String customerName) throws SQLException;

	public void updateCustomer(Customer customer) throws SQLException;

	public Customer getCustomerById(int id) throws SQLException;

	public boolean deleteCustomer(int id) throws SQLException;

}