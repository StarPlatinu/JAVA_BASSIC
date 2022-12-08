package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Account;

public class AccountDao {

	public Account getAnAccount(String account, String password) {
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("select * from Account where account = ? and password = ?");
			prepareStatement.setString(1, account);
			prepareStatement.setString(2, password);
			rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Account acc  = new Account(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4));
				return acc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return null;
	}

	public List<Account> getAllAccount() {
		
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("select * from Account");
			rs = prepareStatement.executeQuery();
			List<Account> list = new ArrayList<>();
			while (rs.next()) {
				Account acc  = new Account(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4));
				list.add(acc);			
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return null;
	}


	public static Account getAnAccountByAccName(String acctransfer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
