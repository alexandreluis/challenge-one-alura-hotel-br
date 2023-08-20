package model;

import java.util.Objects;



public class Credencial
{
	private Integer id;
	private String login;
	private String password;
	
	
	public Credencial() {}
	
	public Credencial(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
		Credencial other = (Credencial) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Credenciais [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
}