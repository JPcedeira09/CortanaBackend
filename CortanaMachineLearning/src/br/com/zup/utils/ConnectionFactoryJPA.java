package br.com.zup.utils;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactoryJPA {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cortana");
	
	@Produces 
	@RequestScoped
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
/*	public static void main(String[] args) {
		System.out.println(ConnectionFactoryJPA.getEntityManager());
	}*/
}
