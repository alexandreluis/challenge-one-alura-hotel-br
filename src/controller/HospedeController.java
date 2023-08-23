package controller;

import java.util.List;

import model.Hospede;
import service.HospedeService;



public class HospedeController 
{
	private HospedeService service = new HospedeService();
	
	
	public Hospede cadastraHospede(Hospede hospede)
	{
		return service.cadastrar(hospede);
	}
	
	public List<Hospede> listarHospedes()
	{
		return service.listar();
	}
}