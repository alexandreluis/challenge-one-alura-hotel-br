package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Hospede;



public class HospedeRepository 
{
	private ConnectionFactory connectionFactory = null;
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private String sql = null;
	private Hospede hospede;
	private List<Hospede> hospedes = new ArrayList<>();
	
	
	public HospedeRepository()
	{
		connectionFactory = new ConnectionFactory();
		
		try 
		{
			connection = connectionFactory.getConnection();
		} catch (SQLException e) 
		{
			System.out.println("Não foi possível estabelecer uma conexão!");
			e.printStackTrace();
		}
	}
	
	
	public Hospede guardar(Hospede hospede)
	{
		try
		{
			sql = "INSERT INTO hospedes (NOME, SOBRE_NOME, DATA_NASCIMENTO, NACIONALIDADE, TELEFONE) VALUES (?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, hospede.getNome());
			statement.setString(2, hospede.getSobrenome());
			statement.setDate(3, hospede.getDataNascimento());
			statement.setString(4, hospede.getNacionalidade());
			statement.setString(5, hospede.getTelefone());
			
			statement.execute();
			
			if(statement.getGeneratedKeys() == null)
			{
				return null;
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally 
		{
			try 
			{
				connectionFactory.closeConnection();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return hospede;
	}
	
	public List<Hospede> listar()
	{
		try
		{
			sql = "SELECT * FROM hospedes";
			statement = connection.prepareStatement(sql);
			
			statement.execute();
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next())
			{
				hospede.setId(resultSet.getInt("ID"));
				hospede.setNome(resultSet.getString("NOME"));
				hospede.setSobrenome(resultSet.getString("SOBRENOME"));
				hospede.setDataNascimento(resultSet.getDate("DATA_NASCIMENTO"));
				hospede.setNacionalidade(resultSet.getString("NACIONALIDADE"));
				hospede.setTelefone(resultSet.getString("TELEFONE"));
				
				hospedes.add(hospede);
			}

		}catch(SQLException e)
		{
			e.printStackTrace();
		}

		return hospedes;
	}
}