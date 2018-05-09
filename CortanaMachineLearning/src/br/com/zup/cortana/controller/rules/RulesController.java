package br.com.zup.cortana.controller.rules;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import br.com.zup.cortana.client.GastosClient;
import br.com.zup.cortana.controller.popUp.PopUpCobre;
import br.com.zup.cortana.controller.popUp.PopUpEstavel;
import br.com.zup.cortana.controller.popUp.PopUpNegativo;
import br.com.zup.cortana.controller.popUp.PopUpPositivo;
import br.com.zup.cortana.interfaces.db.RulesPopUp;
import br.com.zup.cortana.interfaces.service.PopUp;
import br.com.zup.cortana.models.Inputs;
import br.com.zup.cortana.models.OutputCortanaPopUp;


public class RulesController implements RulesPopUp{


	private PopUp popUp;

	@PostConstruct
	private void init() {
		System.out.println("INFO:Começou a usar o RulesControllerPositive.");
	}

	@Inject
	private GastosClient gastosClient;
	
	public BigDecimal predictGastos(OutputCortanaPopUp outputCortana){
		
		String postCortana = gastosClient.postCortana(outputCortana.getConta());
		
		
	    CloseableHttpClient client = HttpClients.createDefault();
	    HttpPost httpPost = new HttpPost("http://www.example.com");
	 
	    StringEntity entity;
		try {
			entity = new StringEntity(postCortana);
		    httpPost.setEntity(entity);
		    httpPost.setHeader("Accept", "application/json");
		    httpPost.setHeader("Content-type", "application/json");
		    httpPost.setHeader("Authorization", "Bearer 25Ux2TjsQ1wcnZ9VTq9LabexB7Z0aqpp5Sk1GE/tnhYjf2x5qnyuNctx6F9hQ3lKAVfo3vu3BCWn0BUqChmWOQ==");

		    CloseableHttpResponse response = client.execute(httpPost);
		   
		    System.out.println("---------------------------------------------------------------------------------------");
		    System.out.println("-------------------------------------STATUS--------------------------------------------");
		    System.out.println(response.getStatusLine().getStatusCode());
		    System.out.println("---------------------------------------------------------------------------------------");
		    System.out.println("--------------------------------------RESPONSE------------------------------------------");
		    System.out.println(response.toString());
		    System.out.println("---------------------------------------------------------------------------------------");
		    System.out.println("-----------------------------------ENTITY-------------------------------------------");
		    System.out.println(response.getEntity());

		    client.close();
		    
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public String showRules(OutputCortanaPopUp outputCortana) {

		BigDecimal gastosMes = outputCortana.getGastosMes();
		BigDecimal recebimentoMes = outputCortana.getRecebimentoMes();
		BigDecimal saldoMesAnterior = outputCortana.getSaldoMesAnterior();

		if (recebimentoMes.doubleValue() > gastosMes.doubleValue() && saldoMesAnterior.doubleValue() > 0 ) {
			this.popUp = new PopUpPositivo();
			return popUp.showPopUp(outputCortana);
		}
		
		else if (recebimentoMes.doubleValue() < gastosMes.doubleValue() && saldoMesAnterior.doubleValue() < 0 ) {
			this.popUp = new PopUpNegativo();
			return popUp.showPopUp(outputCortana);
		}
		
		else if (recebimentoMes.doubleValue() > gastosMes.doubleValue() && saldoMesAnterior.doubleValue() < 0 ) {
			this.popUp = new PopUpCobre();
			return popUp.showPopUp(outputCortana);
		}
		
		else if (recebimentoMes.doubleValue() < gastosMes.doubleValue() && saldoMesAnterior.doubleValue() > 0 ) {
			this.popUp = new PopUpEstavel();
			return popUp.showPopUp(outputCortana);
		}
		else {
			return "OUT";
		}
	}

}
