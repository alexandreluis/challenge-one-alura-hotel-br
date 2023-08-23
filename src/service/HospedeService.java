package service;

import java.util.List;

import model.Hospede;
import repository.HospedeRepository;
import repository.ReservaRepository;



public class HospedeService 
{
	private HospedeRepository hospedeRepository = new HospedeRepository();
	
	
	public Hospede cadastrar(Hospede hospede)
	{
		if(!hospede.equals(null))
		{
			return hospedeRepository.cadastrar(hospede);
		}
		
		return null;
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
