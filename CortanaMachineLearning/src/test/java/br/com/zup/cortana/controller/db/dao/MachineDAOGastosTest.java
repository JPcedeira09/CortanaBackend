package br.com.zup.cortana.controller.db.dao;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest({ MachineDAOGastos.class, ConnectionFactoryJPA.class, TypedQuery.class })
public class MachineDAOGastosTest {
	
	@Mock
	EntityManager managerMock;
	
	@Mock
	private TypedQuery<Long> queryRMock; 

	@Mock
	private TypedQuery<Long> queryGMock;

	@InjectMocks
	MachineDAOGastos machineDAOGastos;
	
	ArgumentCaptor<String> stringContaCaptor = ArgumentCaptor.forClass(String.class);
	
//	@Test
	@SuppressWarnings("unchecked")
	public void getDBhistocoSuccessTest() throws Exception {
		String jpqlRecebimentos = "select sum(h.vr_lancamento) from HistoricoBancario h where h.nr_cnta_crrt = :nr_cnta_crrt and h.tp_lancamento = :tp_lancamento "
			+ " group by  year(h.dt_carga), month(h.dt_carga), h.nr_cnta_crrt  "
			+ "order by  h.dt_carga DESC";
		String jpqlGastos = "select sum(h.vr_lancamento) from HistoricoBancario h where h.nr_cnta_crrt = :nr_cnta_crrt and h.tp_lancamento = :tp_lancamento "
				+ " group by  year(h.dt_carga), month(h.dt_carga), h.nr_cnta_crrt  "
				+ "order by  h.dt_carga DESC";
//	    PowerMockito.mockStatic(ConnectionFactoryJPA.class);
	    List<Long> listG = new ArrayList<>();
	    listG.add(-16435L);
	    listG.add(-40274L);
	    listG.add(-695188L);
	    listG.add(-42126L);
	    listG.add(-321190L);
	    listG.add(-431776L);
	    listG.add(-244625L);
	    List<Long> listR = new ArrayList<>();
	    listR.add(60979L);
	    listR.add(411069L);
	    listR.add(1094514L);
	    listR.add(466151L);	
		
		when(managerMock.createQuery(jpqlGastos, Long.class)).thenReturn(queryGMock);	
		when(queryGMock.setParameter(any(String.class), any())).thenReturn(queryGMock, queryGMock);	
//		when(queryGMock.setParameter(any(String.class), any())).thenReturn(queryGMock);	
//		when(queryGMock.setParameter("nr_cnta_crrt", "1234")).thenReturn(queryGMock);
//		when(queryGMock.setParameter("tp_lancamento", "D")).thenReturn(queryGMock);			
//		when(queryGMock.setMaxResults(anyInt())).thenReturn(queryGMock);	
//		when(queryGMock.setMaxResults(7)).thenReturn(queryGMock);	
		
		when(managerMock.createQuery(jpqlRecebimentos, Long.class)).thenReturn(queryRMock);
		when(queryRMock.setParameter("nr_cnta_crrt", "1234")).thenReturn(queryRMock);	
		when(queryRMock.setParameter("tp_lancamento", "H")).thenReturn(queryRMock);	
		when(queryRMock.setMaxResults(4)).thenReturn(queryGMock);	
		
//		verify(queryGMock, times(1)).getResultList();
		
		when(queryGMock.getResultList()).thenReturn(listG);
		when(queryRMock.getResultList()).thenReturn(listR);
		
		String getDBhistocoReturn = machineDAOGastos.getDBhistoco("1234");	
		
		assertNotNull(getDBhistocoReturn);
	}

}
