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
	
	public DefaultTableModel buscaPorId(Long id, DefaultTableModel modelo)
	{
		return service.buscarPorId(id, modelo);
	}
	
	public DefaultTableModel buscaPorIdReserva(Long id_reserva, DefaultTableModel modelo)
	{
		return service.buscaPorIdReserva(id_reserva, modelo);
	}
	
	public List<Hospede> listarHospedes()
	{
		return service.listar();
	}
}