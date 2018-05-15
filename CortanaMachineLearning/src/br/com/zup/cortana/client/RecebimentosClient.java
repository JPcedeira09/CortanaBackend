package br.com.zup.cortana.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.zup.cortana.controller.db.dao.MachineDAORecebimentos;

@Repository
public class RecebimentosClient implements CortanaClient{

	@Autowired
	private MachineDAORecebimentos daoR;

	public RecebimentosClient() {
		System.out.println("INFO:Começou a usar o RecebimentosClient.");
	}

	@Override
	public String postCortana(String conta) {

		String inputGastos = daoR.getDBhistoco(conta);
		System.out.println("---------------------------RETORNO PARA O IMPUTS  PARA POST----------------------------------------------------------- \n");
		System.out.println(inputGastos);
		return inputGastos;
	}

	/*public static void main(String[] args) {
		GastosClient gastosClient = new GastosClient();
		String postCortana = gastosClient.postCortana("10010479");
	    System.out.println("---------------------------RETORNO PARA O POSTCORTANA DO JSON PRONTO-----------------------------------------------------------");
		System.out.println(postCortana);
	    System.out.println("---------------------------------------------------------------------------------------");
	}*/



}
