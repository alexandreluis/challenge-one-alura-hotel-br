package service;

import model.Credencial;
import repository.CredencialRepository;
import utilities.Password;



public class LogarService 
{
	CredencialRepository credencialRepository = new CredencialRepository();
	Credencial credencialLocal = null;
	
	
	public LogarService(){}
	
	public Boolean podeLogar(Credencial credencial)
	{
		if(!(credencial.getLogin().isEmpty()))
		{
			this.credencialLocal = credencialRepository.buscaPorLogin(credencial.getLogin());
		}
		
		if(!credencial.getPassword().equals(null))
		{
			return comparaSenha(credencial.getPassword(), this.credencialLocal.getPassword());
		}
		
		return false;
	}
	
	public Boolean comparaSenha(String senhaDigitada, String senhaArmazenada)
	{
		Password password = new Password();
		
		return password.checkPassword(senhaDigitada, senhaArmazenada);
	}
	
	public String geraSenhaHash(String senha)
	{
		Password password = new Password();
		
		return password.hashPassword(senha);
	}
}