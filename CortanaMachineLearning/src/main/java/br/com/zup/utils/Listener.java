package br.com.zup.utils;

import javax.persistence.PrePersist;

public class Listener {

	@PrePersist
	public void prePersist(Object entidade) {
		System.out.println("Avisa que rolou algo aqui, faz um backup, qualquer parada");
	}


}
