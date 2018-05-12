package br.com.zup.cortana.client;

import br.com.zup.controller.db.dao.MachineDAORecebimentos;
import br.com.zup.cortana.interfaces.db.MachineDAO;

public class RecebimentosClient extends CortanaClient{

	private MachineDAO daoR;

	public RecebimentosClient() {
		this.daoR = new MachineDAORecebimentos();
	}

	@Override
	public String postCortana(String conta) {

		String inputGastos = this.daoR.getDBhistoco(conta);
	    System.out.println("---------------------------RETORNO PARA O IMPUTS  PARA POST----------------------------------------------------------- \n");
		System.out.println(inputGastos);
		return inputGastos;
	}

	public static void main(String[] args) {
		GastosClient gastosClient = new GastosClient();
		String postCortana = gastosClient.postCortana("10010479");
	    System.out.println("---------------------------RETORNO PARA O POSTCORTANA DO JSON PRONTO-----------------------------------------------------------");
		System.out.println(postCortana);
	    System.out.println("---------------------------------------------------------------------------------------");
	}
	
	
	
}
