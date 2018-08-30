package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;

@Named
@ViewScoped
public class AutorBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}

	public void gravar() {
		
		if(this.autor.getId() == null){
			new DAO<Autor>(Autor.class).adiciona(this.autor);
			this.autor = new Autor();
		} else {
			new DAO<Autor>(Autor.class).atualiza(this.autor);
			this.autor = new Autor();
		}
		
	}
	
	public List<Autor> getAutores(){
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public void atualizaAutor(Autor autor){
		System.out.println("Editando autor" + autor);
		this.autor = autor;
	}
	
	public void removerAutor(Autor autor){
		System.out.println("removendo autor" + autor);
		new DAO<Autor>(Autor.class).remove(autor);
	}
	
	public void testeXpto(){
		System.out.println("ta testado");
	}
	
	
}
