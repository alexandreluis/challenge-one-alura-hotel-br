package service;

import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Reserva;
import repository.ReservaRepository;
import utilities.Calcular;



public class ReservaService
{
	private ReservaRepository reservaRepository = new ReservaRepository();
	private Reserva reserva = null;
	private Calcular calcula = new Calcular();
	private Long valorDaDiaria = 10L;
	private Object[] rowData = new Object[5];
	
	
	public ReservaService() {}
	
	public Reserva CadastraReserva(Reserva reserva)
	{
		if(reserva == null)
		{
			return null;
		}else 
		{
			this.reserva = reservaRepository.cadastrar(reserva);
		}

		return reserva;
	}
	
	public DefaultTableModel buscarPorId(Long id, DefaultTableModel modelo)
	{
		if(id >= 0)
		{
			reserva = reservaRepository.buscaPorId(id);
		}

		if(reserva == null)
		{		
			rowData[0] = "";
			rowData[1] = "";
			rowData[2] = "";
			rowData[3] = "";
			rowData[4] = "";
		}else
		{
			rowData[0] = reserva.getId();
			rowData[1] = reserva.getDataEntrada();
			rowData[2] = reserva.getDataSaida();
			rowData[3] = reserva.getValor();
			rowData[4] = reserva.getFormaDePagamento();
		}
		
		modelo.addRow(rowData);
		
		return modelo;
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

	public boolean atualizaReserva(Reserva reserva) 
	{
		if(reserva.getId() >= 0)
		{
			return reservaRepository.atualizar(reserva);
		}
		
		return false;
	}
}