package br.com.zup.cortana.controller.popUp;

import org.springframework.stereotype.Repository;

import br.com.zup.cortana.interfaces.service.PopUp;
import br.com.zup.cortana.models.OutputCortanaPopUp;

@Repository
public class PopUpCobre implements PopUp {

	String MENSAGEMCOBRE = " Parece que no mês que vem suas contas voltam ao normal. "
			+ "O ideal agora é fazer um planejamento financeiro para "
			+ "evitar possíveis gastos desnecessários. Veja uma relação "
			+ "dos seus gastos recorrentes, tente identificar o problema. "
			+ "Se organize e se possível faça alguns cortes";
	
	@Override
	public String showPopUp( OutputCortanaPopUp output) {
		
		return "Olá "+output.getNome()+"," + MENSAGEMCOBRE;
	}

}
