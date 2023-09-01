package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.FormaDePagamento;
import model.Reserva;



public class ReservaRepository 
{
	private ConnectionFactory connectionFactory = new ConnectionFactory();
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private String sql = null;
	private Reserva reserva = new Reserva();
	
	
	public ReservaRepository() 
	{
		connection = connectionFactory.getConnection();
	}
	
	public Reserva cadastrar(Reserva reserva)
	{		
		try 
		{
			connection = connectionFactory.getConnection();
			
			sql = "INSERT INTO reservas (data_entrada, data_saida, valor, forma_pagamento) VALUES (?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			statement.setDate(1, reserva.getDataEntrada());
			statement.setDate(2, reserva.getDataSaida());
			statement.setDouble(3, reserva.getValor());
			statement.setString(4, reserva.getFormaDePagamento().getDescricao().toString());
			statement.execute();
			
			
			if(statement.getGeneratedKeys() == null)
			{
				return null;
			}

			resultSet = statement.getGeneratedKeys();
			
			
			while(resultSet.next())
			{
				reserva.setId(resultSet.getLong(1));
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
		
		return reserva;
	}
	
	public Reserva buscaPorId(Long id)
	{		
		try
		{
			connection = connectionFactory.getConnection();
			
			sql = "SELECT * FROM reservas WHERE id = ?";
			
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.execute();
			
			resultSet = statement.getResultSet();
			
			
			while(resultSet.next())
			{
				reserva.setId(resultSet.getLong("ID"));
				reserva.setDataEntrada(resultSet.getDate("DATA_ENTRADA"));
				reserva.setDataSaida(resultSet.getDate("DATA_SAIDA"));
				reserva.setValor(resultSet.getDouble("VALOR"));
				
				
				if(resultSet.getString("FORMA_PAGAMENTO").toString().equals("CREDITO"))
				{
					reserva.setFormaDePagamento(FormaDePagamento.CREDITO);
				}

				if(resultSet.getString("FORMA_PAGAMENTO").toString().equals("DEBITO"))
				{
					reserva.setFormaDePagamento(FormaDePagamento.DEBITO);
				}
				
				if(resultSet.getString("FORMA_PAGAMENTO").toString().equals("BOLETO"))
				{
					reserva.setFormaDePagamento(FormaDePagamento.BOLETO);
				}
			}
		}catch (SQLException e)
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
		
		return reserva;
	}
	
	public List<Reserva> listarReservas()
	{
		List<Reserva> lista = new ArrayList<>();
		Reserva reserva = new Reserva();
		
		
		try
		{
			connection = connectionFactory.getConnection();
			
			sql = "SELECT * FROM reservas";
			
			statement = connection.prepareStatement(sql);
			statement.execute();
			
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next())
			{
				reserva.setId(resultSet.getLong("ID"));
				reserva.setDataEntrada(resultSet.getDate("DATA_ENTRADA"));
				reserva.setDataSaida(resultSet.getDate("DATA_SAIDA"));
				reserva.setValor(resultSet.getDouble("VALOR"));
				
				if(resultSet.getString("FORMA_PAGAMENTO") == "CREDITO")
				{
					reserva.setFormaDePagamento(FormaDePagamento.CREDITO);
				}

				if(resultSet.getString("FORMA_PAGAMENTO") == "DEBITO")
				{
					reserva.setFormaDePagamento(FormaDePagamento.DEBITO);
				}
				
				if(resultSet.getString("FORMA_PAGAMENTO") == "BOLETO")
				{
					reserva.setFormaDePagamento(FormaDePagamento.BOLETO);
				}
				
				lista.add(reserva);
			}
		}catch (SQLException e)
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
		
		return lista;
	}

	public boolean atualizar(Reserva reserva) 
	{
		try
		{
			connection = connectionFactory.getConnection();
		 
			
			sql = "UPDATE reservas SET ID  = ?, DATA_ENTRADA = ?, DATA_SAIDA = ?, VALOR = ?, FORMA_PAGAMENTO = ? WHERE ID = ?";
			
			statement = connection.prepareStatement(sql);
		 
			statement.setLong(1, reserva.getId());
			statement.setDate(2, reserva.getDataEntrada());
			statement.setDate(3, reserva.getDataSaida());
			statement.setDouble(4, reserva.getValor());
			statement.setString(5, reserva.getFormaDePagamento().getDescricao().toString());
			statement.setLong(6, reserva.getId());
			
			int update = statement.executeUpdate();
			
			if(update == 0)
			{
				return false;
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
		
		return true;
	}
}