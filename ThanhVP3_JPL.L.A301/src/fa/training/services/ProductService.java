package fa.training.services;

import java.sql.SQLException;

import fa.training.dao.ProductDao;
import fa.training.daoimpl.ProductDaoImpl;
import fa.training.entities.Product;

public class ProductService {
	ProductDao productDao;

	public ProductService() {
		productDao = new ProductDaoImpl();
	}

	public Product getProductById(int productId) {
		try {
			return productDao.getProductById(productId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}