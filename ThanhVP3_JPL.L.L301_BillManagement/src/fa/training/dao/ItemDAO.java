package fa.training.dao;

import java.sql.SQLException;
import java.util.List;

import fa.training.model.Item;
/**
 * 
 * @author thanh
 *
 */

public interface ItemDAO {

	/**
	 * This method is for saving items to the database, using batch.
	 *
	 * @method addItems
	 * @param items
	 * @return true if saves success, else false
	 * @throws SQLException
	 */
	boolean addItems(List<Item> items) throws SQLException;

	/**
	 * This method is for deleting items from the database, using batch.
	 *
	 * @method deleteItems
	 * @param items
	 * @return true if deletes success, else false
	 * @throws SQLException
	 */
	boolean deleteItems(List<Item> items) throws SQLException;

	/**
	 * Execute a query to get all items of a specific bill, using batch.
	 *
	 * @method getAllByBillCode
	 * @param billCode
	 * @return list of items
	 * @throws SQLException
	 */
	List<Item> getAllByBillCode(String billCode) throws SQLException;

	/**
	 * Execute a query to check an item was exist or not.
	 *
	 * @method checkItemExist
	 * @param item
	 * @return true if exist, else false
	 * @throws SQLException
	 */
	boolean checkItemExist(Item item) throws SQLException;
}