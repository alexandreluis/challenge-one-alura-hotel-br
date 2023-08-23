package service;

import java.util.Date;
import java.util.List;

import model.Reserva;
import repository.ReservaRepository;
import utilities.Calcular;

public class ReservaService
{
	private ReservaRepository reservaRepository = new ReservaRepository();
	private Reserva reserva = null;
	private Calcular calcula = new Calcular();
	private Long valorDaDiaria = 10L;
	
	
	public ReservaService() {}
	
	public Reserva CadastraReserva(Reserva reserva)
	{
		if(reserva.equals(null))
		{
			return null;
		}else 
		{
			this.reserva = reservaRepository.cadastrar(reserva);
		}

		return reserva;
	}
	
	public Reserva buscarPorId(Long id)
	{
		if(id >= 0)
		{
			return reservaRepository.buscaPorId(id);
		}
		
		return null;
	}
	
	public List<Reserva> listar()
	{
		List<Reserva> lista = reservaRepository.listarReservas();
		
		if(lista.isEmpty())
		{
			return null;
		}
		
		return lista;
	}
	
	public Long calculaValorDiarias(Long dataInicial, Long dataFinal)
	{
		Long diaI = 0L;
		Long diaF = 0L;
		Long diferencaEmDias = 0L;
		
		
		if(dataInicial > 0 && dataFinal > 0)
		{
			diaI = calcula.calculaTempoEmDias(dataInicial);
			diaF = calcula.calculaTempoEmDias(dataFinal);
			diferencaEmDias = diaF - diaI;
			
			
			if(diferencaEmDias < 0)
			{
				return 0L;
			}
			
			if(diferencaEmDias == 0)
			{
				return valorDaDiaria;
			}else
			{
				return diferencaEmDias * valorDaDiaria;
			}
		}
		
		return null;
	}
}