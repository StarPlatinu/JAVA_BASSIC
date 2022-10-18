package fa.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
protected Connection connection;

public DBConnection() throws SQLException {
	String user = "sa";
	String pass = "sa";
	String uri = "jdbc:sqlserver://Localhost:1433;databaseName=BillManagement";
    connection= DriverManager.getConnection(uri, user, pass);
	System.out.println(connection);
}

public static void main(String[] args) throws SQLException {
	DBConnection context = new DBConnection();
	
}
}
