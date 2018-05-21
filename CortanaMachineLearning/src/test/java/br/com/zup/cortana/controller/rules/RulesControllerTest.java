package br.com.zup.cortana.controller.rules;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.com.zup.cortana.client.controller.ControlerGastos;
import br.com.zup.cortana.client.controller.ControllerRecebimentos;
import br.com.zup.cortana.controller.popUp.PopUpCobre;
import br.com.zup.cortana.controller.popUp.PopUpEstavel;
import br.com.zup.cortana.controller.popUp.PopUpNegativo;
import br.com.zup.cortana.controller.popUp.PopUpPositivo;
import br.com.zup.models.cortana.service.MensagemPOPUP;
import br.com.zup.models.cortana.service.OutputCortanaPopUp;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RulesController.class })
public class RulesControllerTest {
	
	@Mock
	private PopUpEstavel popUpEstavel;
	
	@Mock
	private PopUpCobre popUpCobre;
	
	@Mock
	private PopUpNegativo popUpNegativo;
	
	@Mock
	private PopUpPositivo popUpPositivo;
	
	@Mock
	private ControlerGastos controlerGastos;
	
	@Mock
	private ControllerRecebimentos controllerRecebimentos;

	@InjectMocks
	RulesController rulesController;
	
	private ArgumentCaptor<String> stringContaGastoCaptor = ArgumentCaptor.forClass(String.class);
	
	private ArgumentCaptor<String> stringContaRecebimentoCaptor = ArgumentCaptor.forClass(String.class);
	
	@Test
	public void showRulesPopUpPositivoSuccessTest() {	
		String conta = "123456789";
		String nome = "Juca"; 
		Long gastosPredicao = -30000L;
		Long recebimentoPredicao = 30100L;	
		OutputCortanaPopUp outputCortanaPopUp = new OutputCortanaPopUp();
		outputCortanaPopUp.setConta(conta);
		outputCortanaPopUp.setNome(nome);
		outputCortanaPopUp.setSaldoMesAnterior(1000L);
		when(popUpPositivo.showPopUp(outputCortanaPopUp)).thenReturn(nome);
		when(controlerGastos.postGastosResult(conta)).thenReturn(gastosPredicao);
		when(controllerRecebimentos.postRecebimentosResult(conta)).thenReturn(recebimentoPredicao);

		MensagemPOPUP mensagemPOPUP = rulesController.showRules(outputCortanaPopUp);

		verify(controlerGastos, times(1)).postGastosResult(stringContaGastoCaptor.capture());
		verify(controllerRecebimentos, times(1)).postRecebimentosResult(stringContaRecebimentoCaptor.capture());
		
		assertEquals(conta, stringContaGastoCaptor.getValue());
		assertEquals(conta, stringContaRecebimentoCaptor.getValue());
		assertEquals(gastosPredicao, mensagemPOPUP.getPredictGasto());
		assertThat(mensagemPOPUP.getMsg(), containsString(nome));
		assertEquals(recebimentoPredicao, mensagemPOPUP.getPredictRecebimentos());
		assertNotNull(mensagemPOPUP);
	}
	
	@Test
	public void showRulesPopUpPositivoSaldoAnteriorZeroSuccessTest() {	
		String conta = "123456789";
		String nome = "Juca"; 
		Long gastosPredicao = -30000L;
		Long recebimentoPredicao = 30100L;	
		OutputCortanaPopUp outputCortanaPopUp = new OutputCortanaPopUp();
		outputCortanaPopUp.setConta(conta);
		outputCortanaPopUp.setNome(nome);
		outputCortanaPopUp.setSaldoMesAnterior(0L);
		when(popUpPositivo.showPopUp(outputCortanaPopUp)).thenReturn(nome);
		when(controlerGastos.postGastosResult(conta)).thenReturn(gastosPredicao);
		when(controllerRecebimentos.postRecebimentosResult(conta)).thenReturn(recebimentoPredicao);

		MensagemPOPUP mensagemPOPUP = rulesController.showRules(outputCortanaPopUp);

		verify(controlerGastos, times(1)).postGastosResult(stringContaGastoCaptor.capture());
		verify(controllerRecebimentos, times(1)).postRecebimentosResult(stringContaRecebimentoCaptor.capture());
		
		assertEquals(conta, stringContaGastoCaptor.getValue());
		assertEquals(conta, stringContaRecebimentoCaptor.getValue());
		assertEquals(gastosPredicao, mensagemPOPUP.getPredictGasto());
		assertThat(mensagemPOPUP.getMsg(), containsString(nome));
		assertEquals(recebimentoPredicao, mensagemPOPUP.getPredictRecebimentos());
		assertNotNull(mensagemPOPUP);
	}
	
	@Test
	public void showRulesNegativoPopupSuccessTest() {	
		String conta = "123456789";
		String nome = "Juca"; 
		Long gastosPredicao = -30100L;
		Long recebimentoPredicao = 30000L;	
		OutputCortanaPopUp outputCortanaPopUp = new OutputCortanaPopUp();
		outputCortanaPopUp.setConta(conta);
		outputCortanaPopUp.setNome(nome);
		outputCortanaPopUp.setSaldoMesAnterior(-1000L);
		when(popUpNegativo.showPopUp(outputCortanaPopUp)).thenReturn(nome);
		when(controlerGastos.postGastosResult(conta)).thenReturn(gastosPredicao);
		when(controllerRecebimentos.postRecebimentosResult(conta)).thenReturn(recebimentoPredicao);

		MensagemPOPUP mensagemPOPUP = rulesController.showRules(outputCortanaPopUp);

		verify(controlerGastos, times(1)).postGastosResult(stringContaGastoCaptor.capture());
		verify(controllerRecebimentos, times(1)).postRecebimentosResult(stringContaRecebimentoCaptor.capture());
		
		assertEquals(conta, stringContaGastoCaptor.getValue());
		assertEquals(conta, stringContaRecebimentoCaptor.getValue());
		assertEquals(gastosPredicao, mensagemPOPUP.getPredictGasto());
		assertThat(mensagemPOPUP.getMsg(), containsString(nome));
		assertEquals(recebimentoPredicao, mensagemPOPUP.getPredictRecebimentos());
		assertNotNull(mensagemPOPUP);
	}
	
	@Test
	public void showRulesPopUpCobreSuccessTest() {	
		String conta = "123456789";
		String nome = "Juca"; 
		Long gastosPredicao = -30000L;
		Long recebimentoPredicao = 30100L;	
		OutputCortanaPopUp outputCortanaPopUp = new OutputCortanaPopUp();
		outputCortanaPopUp.setConta(conta);
		outputCortanaPopUp.setNome(nome);
		outputCortanaPopUp.setSaldoMesAnterior(-1000L);
		when(popUpCobre.showPopUp(outputCortanaPopUp)).thenReturn(nome);
		when(controlerGastos.postGastosResult(conta)).thenReturn(gastosPredicao);
		when(controllerRecebimentos.postRecebimentosResult(conta)).thenReturn(recebimentoPredicao);

		MensagemPOPUP mensagemPOPUP = rulesController.showRules(outputCortanaPopUp);

		verify(controlerGastos, times(1)).postGastosResult(stringContaGastoCaptor.capture());
		verify(controllerRecebimentos, times(1)).postRecebimentosResult(stringContaRecebimentoCaptor.capture());
		
		assertEquals(conta, stringContaGastoCaptor.getValue());
		assertEquals(conta, stringContaRecebimentoCaptor.getValue());
		assertEquals(gastosPredicao, mensagemPOPUP.getPredictGasto());
		assertThat(mensagemPOPUP.getMsg(), containsString(nome));
		assertEquals(recebimentoPredicao, mensagemPOPUP.getPredictRecebimentos());
		assertNotNull(mensagemPOPUP);
	}
	
	@Test
	public void showRulesEstavelPopupSuccessTest() {	
		String conta = "123456789";
		String nome = "Juca"; 
		Long gastosPredicao = -30100L;
		Long recebimentoPredicao = 30000L;	
		OutputCortanaPopUp outputCortanaPopUp = new OutputCortanaPopUp();
		outputCortanaPopUp.setConta(conta);
		outputCortanaPopUp.setNome(nome);
		outputCortanaPopUp.setSaldoMesAnterior(1000L);
		when(popUpEstavel.showPopUp(outputCortanaPopUp)).thenReturn(nome);
		when(controlerGastos.postGastosResult(conta)).thenReturn(gastosPredicao);
		when(controllerRecebimentos.postRecebimentosResult(conta)).thenReturn(recebimentoPredicao);

		MensagemPOPUP mensagemPOPUP = rulesController.showRules(outputCortanaPopUp);

		verify(controlerGastos, times(1)).postGastosResult(stringContaGastoCaptor.capture());
		verify(controllerRecebimentos, times(1)).postRecebimentosResult(stringContaRecebimentoCaptor.capture());
		
		assertEquals(conta, stringContaGastoCaptor.getValue());
		assertEquals(conta, stringContaRecebimentoCaptor.getValue());
		assertEquals(gastosPredicao, mensagemPOPUP.getPredictGasto());
		assertThat(mensagemPOPUP.getMsg(), containsString(nome));
		assertEquals(recebimentoPredicao, mensagemPOPUP.getPredictRecebimentos());
		assertNotNull(mensagemPOPUP);
	}
}
