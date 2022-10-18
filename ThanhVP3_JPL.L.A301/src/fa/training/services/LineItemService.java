package fa.training.services;

import java.sql.SQLException;
import java.util.List;

import fa.training.dao.LineItemDao;
import fa.training.daoimpl.LineItemDaoImpl;
import fa.training.entities.LineItem;

public class LineItemService {
	LineItemDao lineItemDao;

	public LineItemService() {
		lineItemDao = new LineItemDaoImpl();
	}

	public boolean addLineItem(LineItem lineItem) {
		try {
			return lineItemDao.addLineItem(lineItem);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<LineItem> getAllLineItemById(int lineItemId) {
		try {
			return lineItemDao.getAllItemsByOrderId(lineItemId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}