package br.com.zup.cortana.client;

import br.com.zup.controller.db.MachineDAO;
import br.com.zup.controller.db.MachineDAOGastos;


public class GastosClient extends CortanaClient{

	private MachineDAO daoG;

	public GastosClient() {
		this.daoG = new MachineDAOGastos();
	}

	@Override
	public String postCortana(String conta) {

		String inputGastos = this.daoG.getDBhistoco(conta);

	    System.out.println("---------------------------RETORNO PARA O IMPUTS-----------------------------------------------------------");
		System.out.println(inputGastos);
	    System.out.println("---------------------------------------------------------------------------------------");

		return inputGastos;
		/*	Inputs inputs = new Inputs();
		inputs.setInputs(inputGastos);
	    System.out.println("---------------------------------------------------------------------------------------");
	    System.out.println("-------------------------------------INPUTS--------------------------------------------");
	    String json = inputs.toJSON();
	    System.out.println(json.toString());
	    System.out.println("---------------------------------------------------------------------------------------");
*/
	}

	public static void main(String[] args) {
		GastosClient gastosClient = new GastosClient();
		

		String postCortana = gastosClient.postCortana("10010479");
		
	    System.out.println("---------------------------RETORNO PARA O POSTCORTANA DO JSON PRONTO-----------------------------------------------------------");

		System.out.println(postCortana);
		
	    System.out.println("---------------------------------------------------------------------------------------");

	}

}
