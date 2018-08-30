package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@Named
@ViewScoped
public class LivroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LivroDao dao;
	
	@Inject
	private AutorDao autorDao;
	
	private Livro livro = new Livro();
	private Integer autorId;

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public Livro getLivro() {
		return livro;
	}

	public List<Livro> getLivros() {
		return this.dao.listaTodos();
	}

	public void gravarAutor() {
		Autor autor = this.autorDao.buscaPorId(autorId);
		this.livro.adicionaAutor(autor);
	}

	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			// throw new
			// RuntimeException("Livro deve ter pelo menos um Autor.");
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"autor",
							new FacesMessage(
									"O livro deve ter sido escrito por alguem"));
			return;

		}
		
		if(this.livro.getId() == null){
			this.dao.adiciona(this.livro);
			this.livro = new Livro(); 
		} else {
			this.dao.atualiza(this.livro);
			this.livro = new Livro(); 
		}

		
	}

	/*public List<Autor> getAutores() {
		return this.dao.listaTodos();
	}
*/
	public List<Autor> getAutoresDoLivro() {

		return this.livro.getAutores();

	}

	public void comecaComDigitoUm(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		String valor = value.toString();

		if (!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage(
					"O ISBN deve começar com o numero 1"));
		}
	}

	public void remover(Livro livro) {
		System.out.println("Removeno livros");
		this.dao.remove(livro);
	}

	public void carregarNoFomularioDeEdicao(Livro livro) {
		System.out.println("Carregando livro no fomrulario");
		this.livro = livro;
	}
	
	public void removeAutor(Autor autor){
		this.livro.remove(autor);
	}
}
