package br.com.zup.cortana.controller.rules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.zup.cortana.client.GastosClient;
import br.com.zup.cortana.client.RecebimentosClient;
import br.com.zup.cortana.controller.popUp.PopUpCobre;
import br.com.zup.cortana.controller.popUp.PopUpEstavel;
import br.com.zup.cortana.controller.popUp.PopUpNegativo;
import br.com.zup.cortana.controller.popUp.PopUpPositivo;
import br.com.zup.cortana.interfaces.db.RulesPopUp;
import br.com.zup.cortana.interfaces.service.PopUp;
import br.com.zup.cortana.models.MensagemPOPUP;
import br.com.zup.cortana.models.OutputCortanaPopUp;
import br.com.zup.models.ResultJSON;

public class RulesController implements RulesPopUp{

	private PopUp popUp;
	
	@PostConstruct
	private void init() {
		System.out.println("INFO:Começou a usar o RulesControllerPositive.");
	}

	/*public static void main(String[] args) {

		RulesController rulesController = new RulesController();
		System.out.println("---------------------------------------------------------------------------------------");
		rulesController.postGastosResult("10010479");
		rulesController.postRecebimentosResult("10010479");
	}*/
	
	public static Long postGastosResult(String conta) {

		try {
			URL url = new URL("https://ussouthcentral.services.azureml.net/workspaces/36c116b8d1d94afda891fa44ab452961/services/666aa98646b04499bd07707e950c70d9/execute?api-version=2.0&format=swagger");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "Bearer 25Ux2TjsQ1wcnZ9VTq9LabexB7Z0aqpp5Sk1GE/tnhYjf2x5qnyuNctx6F9hQ3lKAVfo3vu3BCWn0BUqChmWOQ==");

			GastosClient gastosClient = new GastosClient();
			String postCortana = gastosClient .postCortana(conta);	
			OutputStream os = conn.getOutputStream();
			os.write(postCortana.getBytes());
			os.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			System.out.println("Output from Server .... \n");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			ObjectMapper objectMapper = new ObjectMapper();
			ResultJSON results1 = objectMapper.readValue(br.readLine(), new TypeReference<ResultJSON>(){});
			System.out.println("Results .... GASTOS \n");
			String scoredLabels = results1.getResults().getOutput1().get(0).getScoredLabels();
			System.out.println("SCORE LABELS PURO:"+scoredLabels);

			//report.reportAcessos();
			Long score = (long) Double.parseDouble(scoredLabels);
			
			conn.disconnect();
			return score;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return (long) 0;
		} catch (IOException e) {
			e.printStackTrace();
			return (long) 0;
		}
	}

	public static Long postRecebimentosResult(String conta) {

		try {
			URL url = new URL("https://ussouthcentral.services.azureml.net/workspaces/36c116b8d1d94afda891fa44ab452961/services/55d9d1f69a0a4831b165bba029cda7b9/execute?api-version=2.0&format=swagger");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "Bearer QV8sfSYAztmhx6l6XP5+qGUxzQYmXvTOo8ln7AaB1F3sKrW05zCYzaUxYrOx/27AEljBUYGLJTuuyB5pBcGuew==");

			RecebimentosClient recebimentosClient = new RecebimentosClient();
			String postCortana = recebimentosClient.postCortana(conta);	
			OutputStream os = conn.getOutputStream();
			os.write(postCortana.getBytes());
			os.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			System.out.println("Output from Server .... \n");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			ObjectMapper objectMapper = new ObjectMapper();
			ResultJSON results1 = objectMapper.readValue(br.readLine(), new TypeReference<ResultJSON>(){});
			System.out.println("Results .... RECEBIMENTOS \n");
			String scoredLabels = results1.getResults().getOutput1().get(0).getScoredLabels();
			System.out.println("SCORE LABELS PURO:"+scoredLabels);

			//report.reportAcessos();
			Long score = (long) Double.parseDouble(scoredLabels);
			
			conn.disconnect();
			return score;

		} catch (MalformedURLException e) {
			e.printStackTrace();
			return (long) 0;
		} catch (IOException e) {
			e.printStackTrace();
			return (long) 0;
		}
	}

	@Override
	public MensagemPOPUP showRules(OutputCortanaPopUp outputCortana) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("===============SHOW RULE EM EXECUCAO===============");

		System.out.println(outputCortana.toJSON());
		MensagemPOPUP mensagemPOPUP = new MensagemPOPUP();

		System.out.println("===============SHOW RULE EM EXECUCAO PREDICT GASTOS ===============");
		Long predictGastosMes = postGastosResult(outputCortana.getConta());
		System.out.println("RESPOSTA GASTOS: "+predictGastosMes); 
		
		System.out.println("===============SHOW RULE EM EXECUCAO PREDICT RECEBIMENTOS ===============");
		Long predictRecebimentoMes = postRecebimentosResult(outputCortana.getConta());
		System.out.println("RESPOSTA RECEBIMENTOS: "+predictRecebimentoMes);

		mensagemPOPUP.setPredictGasto(predictGastosMes);
		mensagemPOPUP.setPredictRecebimentos(predictRecebimentoMes);
		System.out.println(mensagemPOPUP.toJSON());
		Long saldoMesAnterior = outputCortana.getSaldoMesAnterior();

		if (predictRecebimentoMes.doubleValue() > predictGastosMes.doubleValue() && saldoMesAnterior.doubleValue() > 0 ) {
			this.popUp = new PopUpPositivo();

			mensagemPOPUP.setMsg(popUp.showPopUp(outputCortana));
			System.out.println(mensagemPOPUP.toJSON());
			return mensagemPOPUP;
		}

		else if (predictRecebimentoMes.doubleValue() < predictGastosMes.doubleValue() && saldoMesAnterior.doubleValue() < 0 ) {
			this.popUp = new PopUpNegativo();
			mensagemPOPUP.setMsg(popUp.showPopUp(outputCortana));
			System.out.println(mensagemPOPUP.toJSON());
			return mensagemPOPUP;
			}

		else if (predictRecebimentoMes.doubleValue() > predictGastosMes.doubleValue() && saldoMesAnterior.doubleValue() < 0 ) {
			this.popUp = new PopUpCobre();
			mensagemPOPUP.setMsg(popUp.showPopUp(outputCortana));
			System.out.println(mensagemPOPUP.toJSON());
			return mensagemPOPUP;
			}

		else if (predictRecebimentoMes.doubleValue() < predictGastosMes.doubleValue() && saldoMesAnterior.doubleValue() > 0 ) {
			this.popUp = new PopUpEstavel();
			mensagemPOPUP.setMsg(popUp.showPopUp(outputCortana));
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