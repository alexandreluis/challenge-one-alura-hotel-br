package controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;
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
	
	public DefaultTableModel buscaPorId(Long id, DefaultTableModel modelo)
	{
		return service.buscarPorId(id, modelo);
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