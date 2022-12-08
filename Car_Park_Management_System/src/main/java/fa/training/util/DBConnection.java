package fa.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public enum DBConnection {
	SQLCONNECTION;
	private static Connection connection;
	private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=Car_Park";
	private static final String name = "sa";
	private static final String password = "sa";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, name, password);
		}
		return connection;
	}
	
	public static void closeResource(Statement statement, PreparedStatement preparedStatement, ResultSet resultSet) {
		try {
			if(resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(preparedStatement != null && !preparedStatement.isClosed()) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			System.out.println("[ERORR]preparedStatement close faild ");
		}
		try {
			if(statement != null && !statement.isClosed()) {
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(DBConnection.getConnection());
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("not ok");
		}
	}
		
	
}