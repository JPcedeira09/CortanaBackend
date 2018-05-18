package br.com.zup.cortana.controller.popUp;

import org.springframework.stereotype.Repository;

import br.com.zup.cortana.interfaces.service.PopUp;
import br.com.zup.models.cortana.service.OutputCortanaPopUp;

@Repository
public class PopUpPositivo implements PopUp{

	
	String MENSAGEMPOSITIVO = " Quando sobrar dinheiro, evite os gastos desnecessários! Parece que no "
			+ "próximo mês sua previsão de gastos está menor do que os recebimentos, "
			+ "aproveite o dinheiro que sobrar para garantir mais estabilidade, conheça "
			+ "alguns de nossos investimentos, ou crie novas metas!";
	
	@Override
	public String showPopUp( OutputCortanaPopUp output) {
		
		return "Olá "+output.getNome()+"," + MENSAGEMPOSITIVO;
	}



}
