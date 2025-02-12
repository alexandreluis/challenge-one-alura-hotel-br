package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Credencial;



public class CredencialRepository 
{
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	private Connection connection = null;
	private PreparedStatement statement = null;
	private String sql = null;
	
	
	public CredencialRepository()
	{	 
		connection = connectionFactory.getConnection();
	}


	public Credencial buscaPorLogin(String login)
	{
		Credencial credencial = new Credencial();
		
		try
		{
			sql = "SELECT * FROM logins where login = ?";
			
			statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			statement.execute();
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next())
			{
				credencial.setId(resultSet.getInt("ID"));
				credencial.setLogin(resultSet.getString("LOGIN"));
				credencial.setPassword(resultSet.getString("PASS"));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			connectionFactory.closeConnection();
		}
		
		return credencial;
	}
}