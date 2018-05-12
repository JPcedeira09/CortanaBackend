package br.com.zup.controller.db;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.zup.controller.db.dao.CRUDImplementacao;
import br.com.zup.models.Conta;

public class ContaDAO extends CRUDImplementacao<Conta, Integer> {

	public ContaDAO(EntityManager manager) {
		super(Conta.class, manager);
	}
	
	@Override
	public void delete(Conta objeto) {
		super.delete(objeto);
	}

	@Override
	public void deleteById(Integer ID) {
		super.deleteById(ID);
	}

	@Override
	public List<Conta> getAll(Conta objeto) {
		return super.getAll(objeto);
	}

	@Override
	public Conta getByID(Integer ID) {
		return super.getByID(ID);
	}
	
	@Override
	public void persist(Conta objeto) {
		super.persist(objeto);
	}
	
	@Override
	public Conta update(Conta objeto,Integer ID) {
		return super.update(objeto,ID);
	} 


}
