package br.com.zup.cortana.controller.rules;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
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
	
	private Logger logger = Logger.getLogger(RulesController.class);

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
		logger.info("RULES CONTROLLER.");
	}
		
	@PostConstruct
	private void init() {
		logger.info("Começou a usar o RulesControllerPositive.");
	}

	/*	public static void main(String[] args) {
		RulesController rulesController = new RulesController();
		System.out.println("---------------------------------------------------------------------------------------");
		rulesController.postGastosResult("10010479");
		rulesController.postRecebimentosResult("10010479");
	}*/
	
	@Override
	public MensagemPOPUP showRules(OutputCortanaPopUp outputCortana) {
//		System.out.println();
//		System.out.println();
//		System.out.println();
		logger.info("===============SHOW RULE EM EXECUCAO===============");

		logger.info(outputCortana.toJSON());
		MensagemPOPUP mensagemPOPUP = new MensagemPOPUP();

		logger.info("===============SHOW RULE EM EXECUCAO PREDICT GASTOS ===============");
		Long predictGastosMes = gastos.postGastosResult(outputCortana.getConta());
		logger.info("RESPOSTA GASTOS: "+predictGastosMes); 
		
		logger.info("===============SHOW RULE EM EXECUCAO PREDICT RECEBIMENTOS ===============");
		Long predictRecebimentoMes = recebimentos.postRecebimentosResult(outputCortana.getConta());
		logger.info("RESPOSTA RECEBIMENTOS: "+predictRecebimentoMes);

		mensagemPOPUP.setPredictGasto(predictGastosMes);
		mensagemPOPUP.setPredictRecebimentos(predictRecebimentoMes);
		logger.info(mensagemPOPUP.toJSON());
		Long saldoMesAnterior = outputCortana.getSaldoMesAnterior();

		if (predictRecebimentoMes.doubleValue() > Math.abs(predictGastosMes.doubleValue())
				&& saldoMesAnterior.doubleValue() >= 0) {

			mensagemPOPUP.setMsg(positivoPopup.showPopUp(outputCortana));
			logger.info(mensagemPOPUP.toJSON());
			return mensagemPOPUP;
		}

		else if (predictRecebimentoMes.doubleValue() < Math.abs(predictGastosMes.doubleValue())
				&& saldoMesAnterior.doubleValue() < 0) {

			mensagemPOPUP.setMsg(negativoPopup.showPopUp(outputCortana));
			logger.info(mensagemPOPUP.toJSON());
			return mensagemPOPUP;
		}

		else if (predictRecebimentoMes.doubleValue() >= Math.abs(predictGastosMes.doubleValue())
				&& saldoMesAnterior.doubleValue() <= 0) {

			mensagemPOPUP.setMsg(cobrePopup.showPopUp(outputCortana));
			logger.info(mensagemPOPUP.toJSON());
			return mensagemPOPUP;
		}

		else if (predictRecebimentoMes.doubleValue() <= Math.abs(predictGastosMes.doubleValue())
				&& saldoMesAnterior.doubleValue() >= 0) {

			mensagemPOPUP.setMsg(estavelPopup.showPopUp(outputCortana));
			logger.info(mensagemPOPUP.toJSON());
			return mensagemPOPUP;
		} else {
			return null;
		}
	}

}