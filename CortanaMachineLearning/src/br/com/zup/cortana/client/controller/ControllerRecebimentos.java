package br.com.zup.cortana.client.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.zup.cortana.client.RecebimentosClient;
import br.com.zup.models.cortana.service.ResultJSON;

@Repository
public class ControllerRecebimentos {

	@Autowired
	private RecebimentosClient recebimentosClient;
	
	public Long postRecebimentosResult(String conta) {

		try {
			URL url = new URL("https://ussouthcentral.services.azureml.net/workspaces/36c116b8d1d94afda891fa44ab452961/services/55d9d1f69a0a4831b165bba029cda7b9/execute?api-version=2.0&format=swagger");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "Bearer QV8sfSYAztmhx6l6XP5+qGUxzQYmXvTOo8ln7AaB1F3sKrW05zCYzaUxYrOx/27AEljBUYGLJTuuyB5pBcGuew==");

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
	
}
