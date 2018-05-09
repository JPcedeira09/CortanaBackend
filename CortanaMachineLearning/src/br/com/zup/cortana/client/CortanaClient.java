package br.com.zup.cortana.client;

import br.com.zup.controller.db.MachineDAORecebimentos;



public abstract class CortanaClient {

	
	private MachineDAORecebimentos daoR;
	
	public String getRecebimento(String conta){
		String dBhistoco = daoR.getDBhistoco(conta);
		return dBhistoco;
	}
	
	public abstract String postCortana(String conta);
	
}
