package br.com.caelum.livraria.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("livraria");

	@Produces //diz para o CDI que esse é um metodo produtor
	@RequestScoped //diz para o CDI que o entity manager vai ser criado a cada request
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	
	//O @Disposes ensina ao CDI como deve fechrar as conexoes
	public void close(@Disposes EntityManager em) {
		em.close();
	}
}
