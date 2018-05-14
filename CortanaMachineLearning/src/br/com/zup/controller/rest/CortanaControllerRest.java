package br.com.zup.controller.rest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.controller.db.LancamentosQuinzenaisController;
import br.com.zup.controller.db.LancamentosSemanaisController;
import br.com.zup.controller.db.startup.BaseHistoricoStartup;
import br.com.zup.cortana.controller.rules.RulesController;
import br.com.zup.cortana.models.LancamentosQuinzenais;
import br.com.zup.cortana.models.MensagemPOPUP;
import br.com.zup.cortana.models.OutputCortanaPopUp;
import br.com.zup.models.Conta;
import br.com.zup.models.LancamentosSemanais;

@RestController
@RequestMapping(path = "/cortana",
produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CortanaControllerRest {

	@Autowired
	private LancamentosSemanaisController datasetsemanal;

	@Autowired
	private LancamentosQuinzenaisController datasetquinzena;

	@Autowired
	private RulesController rules;

	@PostConstruct
	private void getDBHistorico() {
		BaseHistoricoStartup startup  = new BaseHistoricoStartup();
		System.out.println("INFO:Startup Cortana Controller Rest.");
		startup.statupDBHistorico();
	}

	@GetMapping("/test")
	@ResponseBody
	public Conta sayPlainTextHello() {  
		System.out.println("Hello world");
		Conta conta = new Conta("joao", "461.878.888", "123456", "0109");
		return conta;
	} 	

	@PostMapping("/semanal")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<LancamentosSemanais> getHistoricoSemanal(@RequestBody LancamentosSemanais hist){
		System.out.println(hist.toJSON());
		return this.datasetsemanal.getDatset(hist.getConta());
	}

	@PostMapping("/quinzenal")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<LancamentosQuinzenais> getHistoricoquinzenal(@RequestBody LancamentosQuinzenais hist){
		System.out.println(hist.toJSON());
		return this.datasetquinzena.getDatset(hist.getConta());
	}

	@PostMapping("/popUP")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public MensagemPOPUP getPopUp(@RequestBody OutputCortanaPopUp ouput){

		MensagemPOPUP showRules = rules.showRules(ouput);
		return showRules;

	} 

}
