package model;

import java.sql.Date;
import java.util.Objects;



public class Hospede 
{
	private Long id;
	private String nome;
	private String ultimoNome;
	private Date dataNascimento;
	private String nacionalidade;
	private String telefone;
	
	
	public Hospede() {}
	
	public Hospede(String nome, String ultimoNome, Date dataNascimento, String nacionalidade, String telefone) 
	{
		this.nome = nome;
		this.ultimoNome = ultimoNome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
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
		Hospede other = (Hospede) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() 
	{
		return "Hospede [nome=" + nome + ", ultimoNome=" + ultimoNome + ", dataNascimento=" + dataNascimento
				+ ", nacionalidade=" + nacionalidade + ", telefone=" + telefone + "]";
	}
}