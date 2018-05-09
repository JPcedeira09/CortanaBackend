package br.com.zup.cortana.controller.popUp;

import br.com.zup.cortana.interfaces.service.PopUp;
import br.com.zup.cortana.models.OutputCortanaPopUp;

public class PopUpEstavel implements PopUp {

	String MENSAGEMESTAVEL = " Parece que no você tem chances de entrar no vermelho esse mês. "
			+ "O ideal agora é fazer um planejamento financeiro para "
			+ "evitar possíveis gastos desnecessários e começar a suas criar metas. Veja uma relação "
			+ "dos seus gastos recorrentes, tente identificar qual a razão do problema. "
			+ " organize-se e se possível faça alguns cortes neste mês e no proximo.";

	@Override
	public String showPopUp( OutputCortanaPopUp output) {
		
		return "Olá "+output.getNome()+"," + MENSAGEMESTAVEL;
	}


}
