package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public enum DBConnection {
	SQLCONNECTION;

	private static Connection connection;
	private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=BankingDB1";
	private static final String name = "sa";
	private static final String password = "sa";

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, name, password);
		}
		return connection;
	}

	public static void closeResource(Statement statement, PreparedStatement preparedStatement, ResultSet resultSet) {
		try {
			if (resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (preparedStatement != null && !preparedStatement.isClosed()) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			System.out.println("[ERORR]preparedStatement close faild ");
		}
		try {
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}