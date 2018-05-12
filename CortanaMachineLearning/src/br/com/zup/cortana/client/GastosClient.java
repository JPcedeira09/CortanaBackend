package br.com.zup.cortana.client;

import br.com.zup.controller.db.dao.MachineDAOGastos;
import br.com.zup.cortana.interfaces.db.MachineDAO;


public class GastosClient extends CortanaClient{

	private MachineDAO daoG;

	public GastosClient() {
		this.daoG = new MachineDAOGastos();
	}

	@Override
	public String postCortana(String conta) {

		String inputGastos = this.daoG.getDBhistoco(conta);
	    System.out.println("---------------------------RETORNO PARA O IMPUTS PARA POST----------------------------------------------------------- \n");
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
