package br.com.zup.cortana.controller.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.zup.cortana.interfaces.db.MachineDAO;
import br.com.zup.models.cortana.service.Input1ClassificacaoPerfil;
import br.com.zup.utils.ConnectionFactoryJPA;

public class MachineDAOClassificaPerfil implements MachineDAO{

	private EntityManager manager = ConnectionFactoryJPA.getEntityManager();

	/*
	@Autowired
	private ControlerGastos gastos;

	@Autowired
	private ControllerRecebimentos recebimentos;
	 */
	public MachineDAOClassificaPerfil() {
		System.out.println("INFO:Começou a usar o MachineDAOClassificaPerfil.");
	}

	@Override
	public String getDBhistoco(String conta) {

		//List<String> stringInput = new ArrayList<String>();
		Input1ClassificacaoPerfil input1Class = new Input1ClassificacaoPerfil(); 
		List<Long> querySaldo = new ArrayList<Long>();

		try {
			Double mediaDeGastosR = mediaDeGastos(conta, "D");
			List<Long> validateSomaHistoricoR = validateSomaHistorico(mediaDeGastosR.longValue(), conta, "D");
			Double mediaDeGastosG = mediaDeGastos(conta, "H");
			List<Long> validateSomaHistoricoG = validateSomaHistorico(mediaDeGastosG.longValue(), conta, "H");

			/*
			 *  Loop com operadores ternarios que verificam a existencia do valor no indice do array, validando se há ou não 
			 *  valores existententes, quantidades de meses existentes.
			 */

			for(int i = 0;i<6; i++) {
				Long recebimento = (validateSomaHistoricoR.get(i));
				Long gasto = (validateSomaHistoricoG.get(i));
				Long saldo = (recebimento + gasto);
				if(recebimento == 0) {
					recebimento = new Long(1);
					Long porcentagem = ((saldo*100)/recebimento);
					querySaldo.add(i, porcentagem);
				}else {
					Long porcentagem = ((saldo*100)/recebimento);
					querySaldo.add(i, porcentagem);	
				}
			}
 
			
			/*
			 * Setando o valor os valores da input1Class.
			 */
			input1Class.setValor_saldo_mes0(querySaldo.get(0));
			input1Class.setValor_saldo_mes_1(querySaldo.get(1));
			input1Class.setValor_saldo_mes_2(querySaldo.get(2));
			input1Class.setValor_saldo_mes_3(querySaldo.get(3));
			input1Class.setValor_saldo_mes_4(querySaldo.get(4));
			input1Class.setValor_saldo_mes_5(querySaldo.get(5));
			input1Class.setIndentificador(new Long(0));
			//Long postGastosResult = gastos.postGastosResult(conta);
			//Long postRecebimentosResult = recebimentos.postRecebimentosResult(conta);
			//Long saldo_futuro = postGastosResult - postRecebimentosResult;
			input1Class.setValor_saldo_mes_futuro(new Long(0));

			/*	stringInput.add(input1Class.toJSON());		 
		String input1 = "{\"Inputs\": { \"input1\":"+stringInput.toString() + " } }";

		System.out.println("-------------------------------------JSON INPUT1 TO STRING-------------------------------------------- \n ");
		System.out.println(input1.toString());
		String string = input1.toString();*/

			//System.out.println(input1Class.toString());
			return input1Class.toString();
		}catch (NullPointerException e) {
			return "0;0;0;0;0;0;0;0";
		}

	}

	private List<String> getContas() {
		String jpqlContas = "select distinct h.nr_cnta_crrt from HistoricoBancario h ";
		TypedQuery<String> resultList = manager.createQuery(jpqlContas , String.class);
		return resultList.getResultList();
	}

	/*
	public static void main(String[] args) {
		MachineDAOClassificaPerfil machineDAOClassificaPerfil = new MachineDAOClassificaPerfil();
		machineDAOClassificaPerfil.getDBhistoco("10010479");
	}*/

	/* 
	 * Bloco que usa JPA para pegar a media de Recebimentos 
	 * caso não tenha valores.
	 */
	public List<Long> validateSomaHistorico(Long media, String conta, String tp_lancamento) {

		List<Long> array = new ArrayList<Long>();
		for (int i = 0; i < 8; i++) {
			array.add(new Long(0));
		}

		/* 
		 * Bloco que usa JPA para pegar os gastos e recebimentos dos clientes.
		 */
		String querySoma = "select sum(h.vr_lancamento) from HistoricoBancario h where h.nr_cnta_crrt = :nr_cnta_crrt and h.tp_lancamento = :tp_lancamento "
				+ " group by  year(h.dt_carga), month(h.dt_carga), h.nr_cnta_crrt  "
				+ "order by  h.dt_carga DESC";

		TypedQuery<Long> queryG = manager.createQuery(querySoma, Long.class)
				.setParameter("nr_cnta_crrt", conta)
				.setParameter("tp_lancamento", tp_lancamento);

		List<Long> resultList = queryG.getResultList();

		if(resultList!=null && !resultList.isEmpty() && resultList.size() >= 7){
			for(int i = 0 ; i < 7; i++) {
				if(resultList.get(i) != null) {
					array.set(i, resultList.get(i));
				}
			}
		}
		return array;
	}

	/* 
	 * Bloco que usa JPA para pegar a media de Recebimentos 
	 * caso não tenha valores.
	 */
	public Double mediaDeRecebimentos(String conta) {

		String media = "select AVG(h.vr_lancamento) from HistoricoBancario h where h.nr_cnta_crrt = :nr_cnta_crrt and h.tp_lancamento = :tp_lancamento ";

		TypedQuery<Double> queryMediaR = manager.createQuery(media, Double.class)
				.setParameter("nr_cnta_crrt", conta)
				.setParameter("tp_lancamento", "H");

		return queryMediaR.getSingleResult();
	}

	/*
	 * Bloco que usa JPA para pegar a media de Gastos 
	 * caso não tenha valores.
	 */
	public Double mediaDeGastos(String conta,String tp_lancamento) {

		String media = "select AVG(h.vr_lancamento) from HistoricoBancario h where h.nr_cnta_crrt = :nr_cnta_crrt and h.tp_lancamento = :tp_lancamento ";

		TypedQuery<Double> queryMediaG = manager.createQuery(media, Double.class)
				.setParameter("nr_cnta_crrt", conta)
				.setParameter("tp_lancamento", tp_lancamento);

		return queryMediaG.getSingleResult();
	}

	public static void main(String[] args) {

		System.out.println("");
		generetedCSV();
		System.out.println("");
	}

	public Boolean validadeExistencia(List<Long> list) {
		if(list != null && list.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	public static void generetedCSV() {
		MachineDAOClassificaPerfil predictModels = new MachineDAOClassificaPerfil();
		List<String> contas = predictModels.getContas();
		List<String> csvString = new ArrayList<>();
		int i = 0;
		for(String conta : contas) {
			i++;
			csvString.add(predictModels.getDBhistoco(conta));
		}

		System.out.println(i);
		System.out.println();
		System.out.println();
		for(String line : csvString) {
			System.out.println(line.toString());
		}

	}


}
