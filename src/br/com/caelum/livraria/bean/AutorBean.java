package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Named
@ViewScoped
public class AutorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject //injeta os baratos das dependencias - isso é o CDI ralando
	private AutorDao dao;

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}

	public void gravar() {

		if (this.autor.getId() == null) {
			this.dao.adiciona(this.autor);
			this.autor = new Autor();
		} else {
			this.dao.atualiza(this.autor);
			this.autor = new Autor();
		}

	}

	public List<Autor> getAutores() {
		return this.dao.listaTodos();
	}

	public void atualizaAutor(Autor autor) {
		System.out.println("Editando autor" + autor);
		this.autor = autor;
	}

	public void removerAutor(Autor autor) {
		System.out.println("removendo autor" + autor);
		this.dao.remove(autor);
	}

	public void testeXpto() {
		System.out.println("ta testado");
	}

}
