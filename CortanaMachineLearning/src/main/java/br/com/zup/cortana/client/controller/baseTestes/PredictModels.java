package br.com.zup.cortana.client.controller.baseTestes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.zup.models.MLTest.PredicaoGastos;
import br.com.zup.utils.ConnectionFactoryJPA;

public class PredictModels {
	
	public static void main(String[] args) {
		
		System.out.println("");

		generetedCSV();
		
		System.out.println("");
	}
		    
		public static void generetedCSV() {
			PredictModels predictModels = new PredictModels();
			List<String> contas = predictModels.getContas();
			List<String> csvString = new ArrayList<>();
			int i = 0;
			for(String conta : contas) {
				i++;
				csvString.add(predictModels.BasepredictGastos(conta));
			}
			
			System.out.println(i);
			System.out.println();
			System.out.println();
			for(String line : csvString) {
				System.out.println(line.toString());
			}
			
		}
		
	
	private EntityManager manager = ConnectionFactoryJPA.getEntityManager();

	private String BasepredictGastos(String conta) {
		
		List<String> stringInput = new ArrayList<String>();
		PredicaoGastos input1Gastos = new PredicaoGastos(); 
		List<Long> LongsG = new ArrayList<Long>();
		List<Long> LongsR = new ArrayList<Long>();
		
		/* 
		 * Bloco que usa JPA para pegar os gastos do cliente
		 */
		String jpqlExt = "select sum(h.vr_lancamento) from HistoricoBancario h where h.nr_cnta_crrt = :nr_cnta_crrt and h.tp_lancamento = :tp_lancamento "
				+ " group by  year(h.dt_carga), month(h.dt_carga), h.nr_cnta_crrt  "
				+ "order by  h.dt_carga DESC";

	//	System.out.println("======= Result JPA Gasto =========");
		TypedQuery<Long> queryG = manager.createQuery(jpqlExt, Long.class)
				.setParameter("nr_cnta_crrt", conta)
				.setParameter("tp_lancamento", "D");
		
		List<Long> resultList = queryG.getResultList();
		if(resultList.size() >= 8) {
		LongsG = queryG.setMaxResults(8).getResultList();
		//System.out.println(queryG.getResultList()+ " \n");
		
		input1Gastos.setValor_gasto_mesAtual(LongsG.get(0));
		input1Gastos.setValor_gasto_mes(LongsG.get(1));
		input1Gastos.setValor_gasto_mes_anterior(LongsG.get(2));
		input1Gastos.setValor_gasto_mes2(LongsG.get(3));
		input1Gastos.setValor_gasto_mes3(LongsG.get(4));
		input1Gastos.setValor_gasto_mes4(LongsG.get(5));
		input1Gastos.setValor_gasto_mes5(LongsG.get(6));
		input1Gastos.setValor_gasto_mes6(LongsG.get(7));
		}
		/* 
		 * Bloco que usa JPA para pegar os recebimentos do cliente.
		 * 
		 */
		//System.out.println("========= Result JPA Recebimentos =========");
		TypedQuery<Long> queryR = manager.createQuery(jpqlExt, Long.class)
				.setParameter("nr_cnta_crrt", conta)
				.setParameter("tp_lancamento", "H").setMaxResults(4);
		
		List<Long> resultList2 = queryG.getResultList();
		if(resultList2.size() >= 4) {
		//System.out.println(queryR.getResultList() + " \n");
		LongsR = queryR.getResultList();
		
		input1Gastos.setValor_recebido_mes_anterior(LongsR.get(1));
		input1Gastos.setValor_recebido_mes2(LongsR.get(2));
		input1Gastos.setValor_recebido_mes3(LongsR.get(3));
		}

		stringInput.add(input1Gastos.toJSON());		
		
	//	System.out.println(input1Gastos.toString());		
		return input1Gastos.toString();
	}
	
	private List<String> getContas() {
		String jpqlContas = "select distinct h.nr_cnta_crrt from HistoricoBancario h ";
		TypedQuery<String> resultList = manager.createQuery(jpqlContas , String.class);
		return resultList.getResultList();
	}
	
}
