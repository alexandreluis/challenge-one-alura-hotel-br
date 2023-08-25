package controller;


import service.CredencialService;



public class CredencialController 
{
	private CredencialService service;
	
	
	public Boolean logar(String login, String password)
	{
		return service.podeLogar(login, password);
	}
}