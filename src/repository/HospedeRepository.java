package repository;

import java.sql.Connection;
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
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private String sql = null;
	private Hospede hospede = new Hospede();
	private List<Hospede> hospedes = new ArrayList<>();
	
	
	public HospedeRepository() 
	{
		connection = connectionFactory.getConnection();
	}
	
	
	public Hospede cadastrar(Hospede hospede)
	{
		try
		{
			connection = connectionFactory.getConnection();
			
			
			sql = "INSERT INTO hospedes (NOME, SOBRENOME, DATA_NASCIMENTO, NACIONALIDADE, TELEFONE, ID_RESERVA) VALUES (?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, hospede.getNome());
			statement.setString(2, hospede.getSobrenome());
			statement.setDate(3, hospede.getDataNascimento());
			statement.setString(4, hospede.getNacionalidade());
			statement.setString(5, hospede.getTelefone());
			statement.setInt(6, hospede.getNumeroDeReserva());
			
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
			connectionFactory.closeConnection();
			try 
			{
				statement.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return hospede;
	}
	
	public Boolean atualizar(Hospede hospede)
	{
		try
		{
			connection = connectionFactory.getConnection();

			
			sql = "UPDATE hospedes SET NOME = ?, SOBRENOME = ?, DATA_NASCIMENTO = ?, NACIONALIDADE = ?, TELEFONE = ?, ID_RESERVA = ? WHERE ID = ?";

			statement = connection.prepareStatement(sql);

			statement.setString(1, hospede.getNome());
			statement.setString(2, hospede.getSobrenome());
			statement.setDate(3, hospede.getDataNascimento());
			statement.setString(4, hospede.getNacionalidade());
			statement.setString(5, hospede.getTelefone());
			statement.setInt(6, hospede.getNumeroDeReserva());
			statement.setInt(7, hospede.getId());
			
			int update = statement.executeUpdate();

			if(update == 0)
			{
				return false;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally 
		{
			connectionFactory.closeConnection();
			try
			{
				statement.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	public List<Hospede> listar()
	{
		try
		{
			connection = connectionFactory.getConnection();
			
			
			sql = "SELECT * FROM hospedes";
			statement = connection.prepareStatement(sql);
			
			statement.execute();
			
			resultSet = statement.getResultSet();
			
			while(resultSet.next())
			{
				hospede.setId(resultSet.getInt("ID"));
				hospede.setNome(resultSet.getString("NOME"));
				hospede.setSobrenome(resultSet.getString("SOBRENOME"));
				hospede.setDataNascimento(resultSet.getDate("DATA_NASCIMENTO"));
				hospede.setNacionalidade(resultSet.getString("NACIONALIDADE"));
				hospede.setTelefone(resultSet.getString("TELEFONE"));
				hospede.setNumeroDeReserva(resultSet.getInt("ID_RESERVA"));
				
				hospedes.add(hospede);
			}

		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally 
		{
			connectionFactory.closeConnection();
			try 
			{
				statement.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

		return hospedes;
	}
	
	public Hospede buscaPorSobreNome(String sobreNome)
	{		
		try
		{
			connection = connectionFactory.getConnection();
			
			
			sql = "SELECT * FROM hospedes WHERE SOBRENOME = ?";
			
			statement = connection.prepareStatement(sql);
			statement.setString(1, sobreNome);
			
			if(statement.execute())
			{
				resultSet = statement.getResultSet();
				
				while(resultSet.next())
				{
					hospede.setId(resultSet.getInt("ID"));
					hospede.setNome(resultSet.getString("NOME"));
					hospede.setSobrenome(resultSet.getString("SOBRENOME"));
					hospede.setDataNascimento(resultSet.getDate("DATA_NASCIMENTO"));
					hospede.setNacionalidade(resultSet.getString("NACIONALIDADE"));
					hospede.setTelefone(resultSet.getString("TELEFONE"));
					hospede.setNumeroDeReserva(resultSet.getInt("ID_RESERVA"));
				}
			}else
			{
				return null;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally 
		{
			connectionFactory.closeConnection();
			try 
			{
				statement.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return hospede;
	}
	
	public Hospede buscaPorIdReserva(Long id_reserva)
	{
		try
		{
			connection = connectionFactory.getConnection();
			
			
			sql = "SELECT * FROM hospedes WHERE id_reserva = ?";
			
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id_reserva);
			statement.execute();
			
			resultSet = statement.getResultSet();
	
			while(resultSet.next())
			{
				hospede.setId(resultSet.getInt("ID"));
				hospede.setNome(resultSet.getString("NOME"));
				hospede.setSobrenome(resultSet.getString("SOBRENOME"));
				hospede.setDataNascimento(resultSet.getDate("DATA_NASCIMENTO"));
				hospede.setNacionalidade(resultSet.getString("NACIONALIDADE"));
				hospede.setTelefone(resultSet.getString("TELEFONE"));
				hospede.setNumeroDeReserva(resultSet.getInt("ID_RESERVA"));
				
				return hospede;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally 
		{
			connectionFactory.closeConnection();
			try 
			{
				statement.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return  hospede;
	}
	
	public Boolean deletarHospede(Long id)
	{
		try
		{
			connection = connectionFactory.getConnection();
			
			
			sql = "DELETE FROM hospedes WHERE ID = ?";
			
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			
			int valor = statement.executeUpdate();
			
			if(valor >= 1)
			{
				return true;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			connectionFactory.closeConnection();
			try
			{
				statement.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return false;
	}
}