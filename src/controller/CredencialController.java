package controller;

import model.Credencial;
import service.LogarService;

public class CredencialController 
{
	private Credencial credencial = new Credencial();
	
	
	public Boolean logar(String login, String password)
	{
		credencial.setLogin(login);
		credencial.setPassword(password);
		
		LogarService logar = new LogarService();
		
		if(logar.podeLogar(credencial))
		{
			return true;
		}
		
		return false;
	}
}