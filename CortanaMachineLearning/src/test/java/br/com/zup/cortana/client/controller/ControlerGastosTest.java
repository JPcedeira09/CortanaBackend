package br.com.zup.cortana.client.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpMethod;

import br.com.zup.cortana.client.GastosClient;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ControlerGastos.class })
public class ControlerGastosTest {
	
	@Mock
	private GastosClient gastosClient;
	
	@InjectMocks
	private ControlerGastos controlerGastos;

	@Test
	public void postGastosResultSuccessTest() throws Exception {
		String predict = "-366063.65612509";
		Long scoreExpected = (long) Double.parseDouble(predict);

		URL url = PowerMockito.mock(URL.class);
		PowerMockito.whenNew(URL.class).withArguments(Mockito.anyString()).thenReturn(url);
		
		ByteArrayOutputStream outputStream = PowerMockito.mock(ByteArrayOutputStream.class);
		PowerMockito.whenNew(URL.class).withArguments(Mockito.anyString()).thenReturn(url);
		HttpURLConnection connection = PowerMockito.mock(HttpURLConnection.class);

		PowerMockito.when(url.openConnection()).thenReturn(connection);

		String postCortana = "{\"Inputs\": { \"input1\":[{\"valor_gasto_mes\":-16435,"
				+ "\"valor_gasto_mes_anterior\":-402749,\"valor_recebido_mes_anterior\":411069,"
				+ "\"valor_gasto_mes2\":-695188,\"valor_gasto_mes3\":-42126,\"valor_gasto_mes4\":-321190,"
				+ "\"valor_gasto_mes5\":-431776,\"valor_gasto_mes6\":-244625,"
				+ "\"valor_recebido_mes2\":1094514,\"valor_recebido_mes3\":466151}] } }";

		when(gastosClient.postCortana(any())).thenReturn(postCortana);

		String input = "{\"Results\":{\"output1\":[{\"valor_gasto_mes\":\"-16435\","
				+ "\"valor_gasto_mes_anterior\":\"-402749\",\"valor_recebido_mes_anterior\":\"411069\","
				+ "\"valor_gasto_mes2\":\"-695188\",\"valor_gasto_mes3\":\"-42126\",\"valor_gasto_mes4\":\"-321190\","
				+ "\"valor_gasto_mes5\":\"-431776\",\"valor_gasto_mes6\":\"-244625\","
				+ "\"valor_recebido_mes2\":\"1094514\",\"valor_recebido_mes3\":\"466151\","
				+ "\"Scored Labels\":\"-366063.65612509\"}]}}";

		PowerMockito.when(connection.getOutputStream()).thenReturn(outputStream);

		ByteArrayInputStream contents = new ByteArrayInputStream(input.getBytes());
		PowerMockito.when(connection.getInputStream()).thenReturn(contents);
		PowerMockito.when(connection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
		Long predictvalue = controlerGastos.postGastosResult("1234");
		
		verify(outputStream, times(1)).write(postCortana.getBytes());
		verify(outputStream, times(1)).flush();
		verify(connection, times(1)).disconnect();
		verify(connection, times(1)).setRequestMethod(HttpMethod.POST.name());
		verify(connection, times(1)).setDoOutput(true);
		verify(connection, times(1)).setRequestProperty("Content-Type", "application/json");
		verify(connection, times(1)).setRequestProperty("Accept", "application/json");
		verify(connection, times(1)).setRequestProperty("Authorization", "Bearer 25Ux2TjsQ1wcnZ9VTq9LabexB7Z0aqpp5Sk1GE/tnhYjf2x5qnyuNctx6F9hQ3lKAVfo3vu3BCWn0BUqChmWOQ==");
		assertEquals(scoreExpected, predictvalue);
	}

	@Test
	public void postGastosResultIOExceptionTest() throws Exception {
		Long scoreExpected = 0L;

		URL url = PowerMockito.mock(URL.class);
		PowerMockito.whenNew(URL.class).withArguments(Mockito.anyString()).thenReturn(url);
		
		HttpURLConnection connection = PowerMockito.mock(HttpURLConnection.class);
		PowerMockito.when(url.openConnection()).thenReturn(connection);

		String postCortana = "{\"Inputs\": { \"input1\":[{\"valor_gasto_mes\":-16435,"
				+ "\"valor_gasto_mes_anterior\":-402749,\"valor_recebido_mes_anterior\":411069,"
				+ "\"valor_gasto_mes2\":-695188,\"valor_gasto_mes3\":-42126,\"valor_gasto_mes4\":-321190,"
				+ "\"valor_gasto_mes5\":-431776,\"valor_gasto_mes6\":-244625,"
				+ "\"valor_recebido_mes2\":1094514,\"valor_recebido_mes3\":466151}] } }";

		when(gastosClient.postCortana(any())).thenReturn(postCortana);

		PowerMockito.when(connection.getOutputStream()).thenThrow(new IOException("IOException"));

		Long predictvalue = controlerGastos.postGastosResult("1234");

		verify(connection, times(1)).setRequestMethod(HttpMethod.POST.name());
		verify(connection, times(1)).setDoOutput(true);
		verify(connection, times(1)).setRequestProperty("Content-Type", "application/json");
		verify(connection, times(1)).setRequestProperty("Accept", "application/json");
		verify(connection, times(1)).setRequestProperty("Authorization", "Bearer 25Ux2TjsQ1wcnZ9VTq9LabexB7Z0aqpp5Sk1GE/tnhYjf2x5qnyuNctx6F9hQ3lKAVfo3vu3BCWn0BUqChmWOQ==");
		assertEquals(scoreExpected, predictvalue);
	}
}
