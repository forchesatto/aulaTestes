package br.edu.unoesc.bibliotecaPessoal.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.unoesc.bibliotecaPessoal.model.Material;

public class MaterialService {

	private EntityManager em;
	private static EntityManagerFactory factory;

	static{
		factory = Persistence
				.createEntityManagerFactory("Trabalho");
	}
	
	public void initEm(){
		em = factory.createEntityManager();
	}
	
	public void salvar(Material material) {
		initEm();
		em.getTransaction().begin();
		em.persist(material);
		em.getTransaction().commit();
	}

	public Material find(Integer codigo) {
		initEm();
		return em.find(Material.class, codigo);
	}

}
