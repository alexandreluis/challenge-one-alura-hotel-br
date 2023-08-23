package controller;

import java.util.Date;
import java.util.List;

import model.Reserva;
import service.ReservaService;



public class ReservaController
{
	private ReservaService service = new ReservaService();
	
	
	public Reserva cadastraReserva(Reserva reserva)
	{
		return service.CadastraReserva(reserva);
	}
	
	public Reserva buscaPorId(Long id)
	{
		return service.buscarPorId(id);
	}
	
	public List<Reserva> listaReservas()
	{
		return service.listar();
	}
	
	public Long calculaDiferenca(Long dataInicial, Long dataFinal)
	{
		return service.calculaValorDiarias(dataInicial, dataFinal);
	}
}