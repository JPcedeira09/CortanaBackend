package br.com.zup.cortana.controller.popUp;

import br.com.zup.cortana.interfaces.service.PopUp;
import br.com.zup.cortana.models.OutputCortanaPopUp;

public class PopUpNegativo implements PopUp {

	String MENSAGEMNEGATIVO = "Percebo que tem boas chances de você equilibrar seus gastos em breve, "
			+ "apesar de notarmos que este mês seu saldo ainda será devedor. Veja algumas "
			+ "dicas do que pode fazer para organizar suas finanças";
	
	@Override
	public String showPopUp( OutputCortanaPopUp output) {
		
		return "Olá "+output.getNome()+"," + MENSAGEMNEGATIVO;
	}

}
