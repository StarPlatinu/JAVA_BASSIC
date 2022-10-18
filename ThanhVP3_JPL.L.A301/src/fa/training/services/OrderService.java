package fa.training.services;

import java.sql.SQLException;
import java.util.List;

import fa.training.dao.OrderDao;
import fa.training.daoimpl.OrderDaoImpl;
import fa.training.entities.Order;

public class OrderService {
	OrderDao orderDao;

	public OrderService() {
		orderDao = new OrderDaoImpl();
	}

	public boolean addOrder(Order order) {
		try {
			return orderDao.addOrder(order);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Order getOrderById(int orderId) {
		try {
			return orderDao.getOrderById(orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Order> getAllOrderByCustomerId(int customerId) {
		try {
			return orderDao.getAllOrdersByCustomer(customerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public double getTotalOfAllOrder() {
		try {
			return orderDao.computeAllOrders();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean updateTotalOrder(int orderId) {
		try {
			return orderDao.updateOrderTotal(orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}