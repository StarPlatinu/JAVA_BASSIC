package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Product;



public class ProductDao {
public List<Product> getAllProducts(){
	List<Product> list = new ArrayList<>();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query = "select*from products";
	
	try {
		Connection connection = DBConnection.SQLCONNECTION.getConnection();
		ps = connection.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new Product(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("category"),
					rs.getString("price"),
					rs.getString("image")
					));
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return list;
}
}
