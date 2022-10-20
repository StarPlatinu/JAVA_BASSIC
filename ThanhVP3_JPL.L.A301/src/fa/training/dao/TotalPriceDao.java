package fa.training.dao;

import java.sql.SQLException;

import fa.training.entities.TotalPrice;

public interface TotalPriceDao {
	public TotalPrice getTotalPrice(int cusId) throws SQLException;
}
