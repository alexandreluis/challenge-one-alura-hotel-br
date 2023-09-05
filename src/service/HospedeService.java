package service;


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
	
	public Hospede cadastrarHospedeSemReserva(Hospede hospede)
	{
		if(!hospede.equals(null))
		{
			return hospedeRepository.cadastrarHospedeSemReserva(hospede);
		}
		
		return null;
	}	
	
	public DefaultTableModel buscaPorSobreNome(String sobreNome, DefaultTableModel modelo)
	{
		if(!sobreNome.equals(""))
		{
			hospede = hospedeRepository.buscaPorSobreNome(sobreNome);
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
		}else
		{
			rowData[0] = hospede.getId();
			rowData[1] = hospede.getNome();
			rowData[2] = hospede.getSobrenome();
			rowData[3] = hospede.getDataNascimento();
			rowData[4] = hospede.getNacionalidade();
			rowData[5] = hospede.getTelefone();
			rowData[6] = hospede.getNumeroDeReserva();
		}
		
		modelo.addRow(rowData);
		
		return modelo;
	}

	public DefaultTableModel buscaPorIdReserva(Long id, DefaultTableModel modelo)
	{
		if(id >= 0)
		{
			hospede = hospedeRepository.buscaPorIdReserva(id);
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
		}else
		{
			rowData[0] = hospede.getId();
			rowData[1] = hospede.getNome();
			rowData[2] = hospede.getSobrenome();
			rowData[3] = hospede.getDataNascimento();
			rowData[4] = hospede.getNacionalidade();
			rowData[5] = hospede.getTelefone();
			rowData[6] = hospede.getNumeroDeReserva();
		}
		
		modelo.addRow(rowData);
		
		return modelo;
	}
	
	
	public Hospede buscaPorIdReserva(Long id)
	{
		if(id >= 0)
		{
			return hospedeRepository.buscaPorIdReserva(id);
		}
		
		return null;
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
	
	public Boolean deletarHospede(Hospede hospede)
	{
		if(hospede.getId() >= 0)
		{
			return hospedeRepository.deletarHospede(Long.parseUnsignedLong(hospede.getId().toString()));
		}
		
		return false;
	}
}