package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Autor;

public class AutorDao {

	@Inject
	EntityManager em;
	private DAO<Autor> dao; // == new ....;
	
	@PostConstruct
	void initi(){
		//é a mesma coisa.
		this.dao = new DAO<Autor>(this.em, Autor.class);
	}

	public void adiciona(Autor t) {
		dao.adiciona(t);
	}

	public void remove(Autor t) {
		dao.remove(t);
	}

	public void atualiza(Autor t) {
		dao.atualiza(t);
	}

	public List<Autor> listaTodos() {
		return dao.listaTodos();
	}

	public Autor buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}

	public int contaTodos() {
		return dao.contaTodos();
	}

	public List<Autor> listaTodosPaginada(int firstResult, int maxResults) {
		return dao.listaTodosPaginada(firstResult, maxResults);
	}
	


}