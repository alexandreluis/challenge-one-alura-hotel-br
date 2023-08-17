package model;

import java.sql.Date;
import java.util.Objects;



public class Reserva 
{
	private Long id;
	private Date dataEntrada;
	private Date dataSaida;
	private Double valor;
	
	private FormaDePagamento formaDePagamento;
	private Hospede hospede;
	
	
	public Reserva() {}
	
	public Reserva(Date dataEntrada, Date dataSaida, Double valor, FormaDePagamento formaDePagamento, Hospede hospede) 
	{
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.formaDePagamento = formaDePagamento;
		this.hospede = hospede;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDataEntrada() {
		return dataEntrada;
	}
	
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public Date getDataSaida() {
		return dataSaida;
	}
	
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}
	
	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
	public Hospede getHospede() {
		return hospede;
	}
	
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Reserva [dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + ", valor=" + valor
				+ ", formaDePagamento=" + formaDePagamento + ", hospede=" + hospede + "]";
	}
}