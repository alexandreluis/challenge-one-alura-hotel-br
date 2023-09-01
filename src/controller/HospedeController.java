package controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Hospede;
import service.HospedeService;



public class HospedeController 
{
	private HospedeService service = new HospedeService();
	
	
	public Hospede cadastraHospede(Hospede hospede)
	{
		return service.cadastrar(hospede);
	}

	public DefaultTableModel buscaPorIdReserva(Long id, DefaultTableModel modelo)
	{
		return service.buscaPorIdReserva(id, modelo);
	}

	public DefaultTableModel buscaPorSobreNome(String sobreNome, DefaultTableModel modelo)
	{
		return service.buscaPorSobreNome(sobreNome, modelo);
	}
	
	public List<Hospede> listarHospedes()
	{
		return service.listar();
	}

	public Boolean atualizarHospede(Hospede modelo) 
	{
		return service.atualizar(modelo);
	}
}