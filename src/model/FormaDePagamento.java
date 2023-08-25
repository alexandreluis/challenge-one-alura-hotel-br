package model;



public enum FormaDePagamento
{
	CREDITO("CREDITO"),
	DEBITO("DEBITO"),
	BOLETO("BOLETO");
	
	
	private String descricao;
	
	FormaDePagamento(String descricao) 
	{
		this.descricao = descricao;
	}
	
	public String getDescricao() 
	{
		return this.descricao;
	}
}