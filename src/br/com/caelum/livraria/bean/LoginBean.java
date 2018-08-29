package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.modelo.Usuario;

@ManagedBean(name="LoginBean")
@ViewScoped
public class LoginBean {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public String efetuarLogin(){
		System.out.println("loging....");
		return "livro?faces-redirect=true";
	}
	
	
}
