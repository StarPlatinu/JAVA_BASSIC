package fa.training.dao;

import java.sql.SQLException;

import fa.training.entities.Product;

public interface ProductDao {
	public Product getProductById(int productId) throws SQLException;
}