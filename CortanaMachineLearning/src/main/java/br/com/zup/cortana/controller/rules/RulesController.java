package br.com.zup.cortana.controller.rules;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.zup.cortana.client.controller.ControlerGastos;
import br.com.zup.cortana.client.controller.ControllerRecebimentos;
import br.com.zup.cortana.controller.popUp.PopUpCobre;
import br.com.zup.cortana.controller.popUp.PopUpEstavel;
import br.com.zup.cortana.controller.popUp.PopUpNegativo;
import br.com.zup.cortana.controller.popUp.PopUpPositivo;
import br.com.zup.cortana.interfaces.db.RulesPopUp;
import br.com.zup.models.cortana.service.MensagemPOPUP;
import br.com.zup.models.cortana.service.OutputCortanaPopUp;

@Repository
public class RulesController implements RulesPopUp{

	@Autowired
	private PopUpEstavel estavelPopup;
	
	@Autowired
	private PopUpCobre cobrePopup;
	
	@Autowired
	private PopUpPositivo positivoPopup;
	
	@Autowired
	private PopUpNegativo negativoPopup;
	
	@Autowired
	private ControlerGastos gastos;
	
	@Autowired
	private ControllerRecebimentos recebimentos;
	
	public RulesController() {
		System.out.println("INFO: RULES CONTROLLER.");
	}
		
	@PostConstruct
	private void init() {
		System.out.println("INFO:Começou a usar o RulesControllerPositive.");
	}

	/*	public static void main(String[] args) {
		RulesController rulesController = new RulesController();
		System.out.println("---------------------------------------------------------------------------------------");
		rulesController.postGastosResult("10010479");
		rulesController.postRecebimentosResult("10010479");
	}*/
	
	@Override
	public MensagemPOPUP showRules(OutputCortanaPopUp outputCortana) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("===============SHOW RULE EM EXECUCAO===============");

		System.out.println(outputCortana.toJSON());
		MensagemPOPUP mensagemPOPUP = new MensagemPOPUP();

		System.out.println("===============SHOW RULE EM EXECUCAO PREDICT GASTOS ===============");
		Long predictGastosMes = gastos.postGastosResult(outputCortana.getConta());
		System.out.println("RESPOSTA GASTOS: "+predictGastosMes); 
		
		System.out.println("===============SHOW RULE EM EXECUCAO PREDICT RECEBIMENTOS ===============");
		Long predictRecebimentoMes = recebimentos.postRecebimentosResult(outputCortana.getConta());
		System.out.println("RESPOSTA RECEBIMENTOS: "+predictRecebimentoMes);

		mensagemPOPUP.setPredictGasto(predictGastosMes);
		mensagemPOPUP.setPredictRecebimentos(predictRecebimentoMes);
		System.out.println(mensagemPOPUP.toJSON());
		Long saldoMesAnterior = outputCortana.getSaldoMesAnterior();

		if (predictRecebimentoMes.doubleValue() > predictGastosMes.doubleValue() && saldoMesAnterior.doubleValue() > 0 ) {

			mensagemPOPUP.setMsg(positivoPopup.showPopUp(outputCortana));
			System.out.println(mensagemPOPUP.toJSON());
			return mensagemPOPUP;
		}

		else if (predictRecebimentoMes.doubleValue() < predictGastosMes.doubleValue() && saldoMesAnterior.doubleValue() < 0 ) {
					
			mensagemPOPUP.setMsg(negativoPopup.showPopUp(outputCortana));
			System.out.println(mensagemPOPUP.toJSON());
			return mensagemPOPUP;
			}

		else if (predictRecebimentoMes.doubleValue() > predictGastosMes.doubleValue() && saldoMesAnterior.doubleValue() < 0 ) {

			mensagemPOPUP.setMsg(cobrePopup.showPopUp(outputCortana));
			System.out.println(mensagemPOPUP.toJSON());
			return mensagemPOPUP;
			}

		else if (predictRecebimentoMes.doubleValue() < predictGastosMes.doubleValue() && saldoMesAnterior.doubleValue() > 0 ) {
			
			
			mensagemPOPUP.setMsg(estavelPopup.showPopUp(outputCortana));
			mensagemPOPUP.setPredictGasto(predictGastosMes);
			mensagemPOPUP.setPredictRecebimentos(predictRecebimentoMes);
			System.out.println(mensagemPOPUP.toJSON());
			return mensagemPOPUP;
			}
		else {
			return null;
		}
	}

}