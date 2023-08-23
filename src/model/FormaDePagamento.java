package model;



public enum FormaDePagamento
{
	CREDITO("Cartão de Crédito"),
	DEBITO("Cartão de Débito"),
	BOLETO("Dinheiro");
	
	
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