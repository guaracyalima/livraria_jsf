package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Livro;

public class LivroDao {

	@Inject
	EntityManager em;
	private DAO<Livro> dao;
	
	@PostConstruct
	void init(){
		this.dao = new DAO<Livro>(this.em, Livro.class);
	}
	

	public List<Livro> listaTodos() {
		// TODO Auto-generated method stub
		return null;
	}


	public void adiciona(Livro t) {
		dao.adiciona(t);
	}


	public void remove(Livro t) {
		dao.remove(t);
	}


	public void atualiza(Livro t) {
		dao.atualiza(t);
	}


	public Livro buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}


	public int contaTodos() {
		return dao.contaTodos();
	}


	public List<Livro> listaTodosPaginada(int firstResult, int maxResults) {
		return dao.listaTodosPaginada(firstResult, maxResults);
	}

	
}
