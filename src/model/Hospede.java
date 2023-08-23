package model;

import java.sql.Date;
import java.util.Objects;



public class Hospede 
{
	private Integer id;
	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	private String nacionalidade;
	private String telefone;
	private Integer numeroDeReserva;
	
	
	public Hospede() {}
	
	public Hospede(String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone) 
	{
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
	}

	public Hospede(String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone, Integer numeroDeReserva) 
	{
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
		this.numeroDeReserva = numeroDeReserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getNumeroDeReserva() {
		return numeroDeReserva;
	}

	public void setNumeroDeReserva(Integer numeroDeReserva) {
		this.numeroDeReserva = numeroDeReserva;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospede other = (Hospede) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Hospede [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataNascimento="
				+ dataNascimento + ", nacionalidade=" + nacionalidade + ", telefone=" + telefone + ", numeroDeReserva="
				+ numeroDeReserva + "]";
	}
}