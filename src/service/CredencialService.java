package service;

import model.Credencial;
import repository.CredencialRepository;
import utilities.Password;



public class CredencialService 
{
	CredencialRepository credencialRepository = new CredencialRepository();
	private Credencial credencialLocal = new Credencial();
	
	
	public CredencialService(){}
	
	public Boolean podeLogar(String login, String password)
	{
		if(!(login.isEmpty()))
		{
			this.credencialLocal = credencialRepository.buscaPorLogin(login);
		}
		
		if(!password.equals(null))
		{
			return comparaSenha(password, this.credencialLocal.getPassword());
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