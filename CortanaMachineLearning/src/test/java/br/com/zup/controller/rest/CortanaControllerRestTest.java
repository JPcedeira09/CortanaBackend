package br.com.zup.controller.rest;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;

import br.com.zup.controller.db.LancamentosQuinzenaisController;
import br.com.zup.controller.db.LancamentosSemanaisController;
import br.com.zup.cortana.controller.rules.RulesController;
import br.com.zup.models.cortana.service.OutputCortanaPopUp;

public class CortanaControllerRestTest {

	private MockMvc mockMvc;
	
	@Mock
	private LancamentosSemanaisController datasetsemanal;

	@Mock
	private LancamentosQuinzenaisController datasetquinzena;

	@Mock
	private RulesController rules;

	@InjectMocks
	private CortanaControllerRest cortanaControllerRest;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(cortanaControllerRest).build();
	}

	@Test
	public void getPopUpSuccessTest() throws Exception {
		// User user = new User("Arya Stark");
		when(rules.showRules(any(OutputCortanaPopUp.class))).thenReturn(null);
		// doNothing().when(userService).create(user);
		OutputCortanaPopUp ouput = new OutputCortanaPopUp();
		ouput.setNome("Juca");
		ouput.setConta("123");
		ouput.setSaldoMesAnterior(1000L);
		mockMvc.perform(post("/cortana/popUP")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(ouput)))
				.andExpect(status().isOk());
//				.andExpect(header().string("location", 
//						containsString("http://localhost/CortanaMachineLearning/cortana/popUP")));
//		mockMvc.perform(requestBuilder);
		verify(rules, times(1)).showRules(any(OutputCortanaPopUp.class));
		verifyNoMoreInteractions(rules);
	}

}
