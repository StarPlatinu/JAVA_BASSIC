package fa.training.dao;

import java.sql.SQLException;
import java.util.List;
import fa.training.entities.Order;

public interface OrderDao {
	public List<Order> getAllOrdersByCustomer(int customerId) throws SQLException;
	
	public double computeAllOrders() throws SQLException;
	
	public boolean addOrder(Order order) throws SQLException;
	
	public Order getOrderById(int id) throws SQLException;
	
	public boolean updateOrderTotal(int orderId) throws SQLException;
}