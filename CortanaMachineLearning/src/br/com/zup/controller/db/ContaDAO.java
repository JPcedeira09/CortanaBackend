package br.com.zup.controller.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zup.controller.db.dao.CRUDImplementacao;
import br.com.zup.models.Conta;


public class ContaDAO {

	@Autowired
	private CRUDImplementacao<Conta, Integer> crud;

	public void delete(Conta objeto) {
		crud.delete(objeto);
	}

	public void deleteById(Integer ID) {
		crud.deleteById(ID);
	}

	public List<Conta> getAll(Conta objeto) {
		return crud.getAll(objeto);
	}

	public Conta getByID(Integer ID) {
		return crud.getByID(ID);
	}

	public void persist(Conta objeto) {
		crud.persist(objeto);
	}

	public Conta update(Conta objeto,Integer ID) {
		return crud.update(objeto,ID);
	} 


}
