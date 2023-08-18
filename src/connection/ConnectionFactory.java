package connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory 
{
	private String address = "jdbc:mysql://localhost:3306/";
	private String serverConfig = "?useTimezone=true&serverTimezone=UTC";
	private String dbName = "alurahotel";
	private String url = address  + dbName + serverConfig;
	private String user = "root";
	private String password = "";
	private Connection connection = null;
	

	public ConnectionFactory(){}
	
	public Connection getConnection() throws SQLException
	{
		connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}

	public void closeConnection() throws SQLException
	{
		this.connection.close();
	}
}