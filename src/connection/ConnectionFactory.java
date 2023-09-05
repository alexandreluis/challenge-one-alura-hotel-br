package connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory 
{
	private String address = "jdbc:mysql://localhost:3306/";
	private String serverConfig = "?useTimezone=true&serverTimezone=UTC";
	private String dbName = "alurahotela";
	private String url = address  + dbName + serverConfig;
	private String user = "root";
	private String password = "";
	private Connection connection = null;
	

	public ConnectionFactory(){}
	
	public Connection getConnection()
	{
		try 
		{
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return connection;
	}

	public void closeConnection()
	{
		try 
		{
			this.connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}