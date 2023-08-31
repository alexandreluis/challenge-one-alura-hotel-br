package service;

import java.sql.SQLException;
import java.util.List;

import model.Hospede;
import javax.swing.table.DefaultTableModel;
import repository.HospedeRepository;



public class HospedeService 
{
	private HospedeRepository hospedeRepository = new HospedeRepository();
	private Hospede hospede;
	private Object[] rowData = new Object[7];
	
	
	public Hospede cadastrar(Hospede hospede)
	{
		if(!hospede.equals(null))
		{
			return hospedeRepository.cadastrar(hospede);
		}
		
		return null;
	}
	
	
	public DefaultTableModel buscaPorIdReserva(Long id_reserva, DefaultTableModel modelo)
	{
		if(id_reserva >= 0)
		{
			hospede = hospedeRepository.buscaPorIdReserva(id_reserva);
		}
		
		if(hospede == null)
		{
			rowData[0] = "";
			rowData[1] = "";
			rowData[2] = "";
			rowData[3] = "";
			rowData[4] = "";
			rowData[5] = "";
			rowData[6] = "";
			
			modelo.addRow(rowData);
		}else
		{
			rowData[0] = hospede.getId();
			rowData[1] = hospede.getNome();
			rowData[2] = hospede.getSobrenome();
			rowData[3] = hospede.getDataNascimento();
			rowData[4] = hospede.getNacionalidade();
			rowData[5] = hospede.getTelefone();
			rowData[6] = hospede.getNumeroDeReserva();
			
			modelo.addRow(rowData);
		}
		
		return modelo;
	}
	
	public DefaultTableModel buscarPorId(Long id, DefaultTableModel modelo)
	{
		if(id >= 0)
		{
			try 
			{
				hospede = hospedeRepository.buscaPorId(id);
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		if(hospede == null)
		{		
			rowData[0] = "";
			rowData[1] = "";
			rowData[2] = "";
			rowData[3] = "";
			rowData[4] = "";
			rowData[5] = "";
			rowData[6] = "";
			
			modelo.addRow(rowData);
		}else
		{
			rowData[0] = hospede.getId();
			rowData[1] = hospede.getNome();
			rowData[2] = hospede.getSobrenome();
			rowData[3] = hospede.getDataNascimento();
			rowData[4] = hospede.getNacionalidade();
			rowData[5] = hospede.getTelefone();
			rowData[6] = hospede.getNumeroDeReserva();
			
			modelo.addRow(rowData);
		}
		
		return modelo;
	}
	
	
	public Boolean atualizar(Hospede hospede)
	{
		if(hospede.getId() >= 0)
		{
			return hospedeRepository.atualizar(hospede);
		}

		return false;
	}
	
	
	public List<Hospede> listar()
	{
		if(!hospedeRepository.listar().isEmpty())
		{
			return hospedeRepository.listar();
		}
		
		return null;
	}
}