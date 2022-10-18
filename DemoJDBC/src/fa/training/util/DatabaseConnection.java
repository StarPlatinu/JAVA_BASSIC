package fa.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum DatabaseConnection {
	DBConnection;

	private Connection connection;

	public Connection getConnection() throws SQLException {

		if (connection == null || connection.isClosed()) {
			String user = "sa";
			String pass = "sa";
			String url = "jdbc:sqlserver://LocalHost:1433;databaseName=GuitarShopDB";
			connection = DriverManager.getConnection(url, user, pass);
		}
		return connection;
	}

	public static void close(PreparedStatement preparedStatement, ResultSet resultSet) {
		try {
			if (resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
		} catch (SQLException e) {
			System.out.println("[ERROR] close resultSet");
		}
		
		try {
			if (preparedStatement != null && !preparedStatement.isClosed()) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			System.out.println("[ERROR] close preparedStatement");
		}
	}
}
