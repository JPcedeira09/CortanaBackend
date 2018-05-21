package br.com.zup.cortana.client.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.zup.cortana.client.GastosClient;
import br.com.zup.cortana.controller.rules.RulesController;
import br.com.zup.models.cortana.service.ResultJSON;

@Repository
public class ControlerGastos {
	
	private Logger logger = Logger.getLogger(RulesController.class);

	@Autowired
	private GastosClient gastosClient;
	
	public Long postGastosResult(String conta) {
		
		logger.info("inicio - postGastosResult");

		try {
			URL url = new URL("https://ussouthcentral.services.azureml.net/workspaces/36c116b8d1d94afda891fa44ab452961/services/666aa98646b04499bd07707e950c70d9/execute?api-version=2.0&format=swagger");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "Bearer 25Ux2TjsQ1wcnZ9VTq9LabexB7Z0aqpp5Sk1GE/tnhYjf2x5qnyuNctx6F9hQ3lKAVfo3vu3BCWn0BUqChmWOQ==");

			String postCortana = gastosClient.postCortana(conta);	
			OutputStream os = conn.getOutputStream();
			os.write(postCortana.getBytes());
			os.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			logger.info("Output from Server .... \n");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			ObjectMapper objectMapper = new ObjectMapper();
			ResultJSON results1 = objectMapper.readValue(br.readLine(), new TypeReference<ResultJSON>(){});
			logger.info("Results .... GASTOS \n");
			String scoredLabels = results1.getResults().getOutput1().get(0).getScoredLabels();
			logger.info("SCORE LABELS PURO:"+scoredLabels);

			//report.reportAcessos();
			Long score = (long) Double.parseDouble(scoredLabels);
			
			conn.disconnect();
			return score;
		} catch (MalformedURLException e) {
			logger.error(e.getMessage(), e);
			return (long) 0;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			return (long) 0;
		}
	}
	
}
