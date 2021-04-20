package br.com.task.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectionFactory {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("TaskPersistence");

	public static EntityManager getManager() {
		return factory.createEntityManager();
	}

	
	
	
}
