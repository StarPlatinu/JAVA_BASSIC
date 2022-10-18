package fa.training.dao;

import java.sql.SQLException;
import java.util.List;

import fa.training.model.Bill;
/**
 * 
 * @author thanh
 *
 */
public interface BillDAO {

	/**
	 * Execute a query to get all bills from database.
	 *
	 * @method getAll
	 * @return list of bills
	 * @throws SQLException
	 */
	List<Bill> getAll() throws SQLException;

	/**
	 * Call a stored procedure to save a bill to database.
	 *
	 * @method saveBill
	 * @param bill
	 * 
	 * 
	 * @return true if inserts success to database, else false
	 * @throws SQLException
	 */
	boolean saveBill(Bill bill) throws SQLException;

	/**
	 * Execute a query to retrieve a bill by its code.
	 *
	 * @method findBillsByBillCode
	 * @param billCode
	 * @return bill if found, else null
	 * @throws SQLException
	 */
	Bill findBillsByBillCode(String billCode) throws SQLException;

	/**
	 * Execute a query to retrieve bills by its customer name.
	 *
	 * @method findBillsByCustomerName
	 * @param customerName
	 * @return list of bills
	 * @throws SQLException
	 */
	List<Bill> findBillsByCustomerName(String customerName) throws SQLException;
}