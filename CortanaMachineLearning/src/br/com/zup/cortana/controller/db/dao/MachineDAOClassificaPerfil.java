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

		List<String> stringInput = new ArrayList<String>();
		Input1ClassificacaoPerfil input1Class = new Input1ClassificacaoPerfil(); 
		List<Long> resultG = new ArrayList<Long>();
		List<Long> resultR = new ArrayList<Long>();
		List<Long> querySaldo = new ArrayList<Long>();

		/* 
		 * Bloco que usa JPA para pegar os gastos do cliente
		 */
		String jpqlGastos = "select sum(h.vr_lancamento) from HistoricoBancario h where h.nr_cnta_crrt = :nr_cnta_crrt and h.tp_lancamento = :tp_lancamento "
				+ " group by  year(h.dt_carga), month(h.dt_carga), h.nr_cnta_crrt  "
				+ "order by  h.dt_carga DESC";

		System.out.println("======= Result JPA Gasto =========");
		TypedQuery<Long> queryG = manager.createQuery(jpqlGastos, Long.class)
				.setParameter("nr_cnta_crrt", conta)
				.setParameter("tp_lancamento", "D").setMaxResults(6);
		System.out.println(queryG.getResultList()+ " \n");
		resultG = queryG.getResultList();

		/* 
		 * Bloco que usa JPA para pegar os recebimentos do cliente
		 */
		String jpqlRecebimentos = "select sum(h.vr_lancamento) from HistoricoBancario h where h.nr_cnta_crrt = :nr_cnta_crrt and h.tp_lancamento = :tp_lancamento "
				+ " group by  year(h.dt_carga), month(h.dt_carga), h.nr_cnta_crrt  "
				+ "order by  h.dt_carga DESC";

		System.out.println("======= Result JPA Recebimentos =========");
		TypedQuery<Long> queryR = manager.createQuery(jpqlRecebimentos, Long.class)
				.setParameter("nr_cnta_crrt", conta)
				.setParameter("tp_lancamento", "H").setMaxResults(6);
		System.out.println(queryR.getResultList() + " \n");
		resultR = queryR.getResultList();

		for(int i = 0;i<6; i++) {
			querySaldo.add(i, (resultR.get(i) + resultG.get(i)));
			System.out.println(querySaldo.get(i));
		}

		System.out.println(querySaldo.toString());

		input1Class.setValor_saldo_mes_2(querySaldo.get(2));
		input1Class.setValor_saldo_mes_3(querySaldo.get(3));
		input1Class.setValor_saldo_mes_4(querySaldo.get(4));
		input1Class.setValor_saldo_mes_5(querySaldo.get(5));
		input1Class.setIndentificador(new Long(0));
		//Long postGastosResult = gastos.postGastosResult(conta);
		//Long postRecebimentosResult = recebimentos.postRecebimentosResult(conta);

	//	Long saldo_futuro = postGastosResult - postRecebimentosResult;
		input1Class.setValor_saldo_mes_futuro(new Long(0));

		stringInput.add(input1Class.toJSON());		 
		String input1 = "{\"Inputs\": { \"input1\":"+stringInput.toString() + " } }";

		System.out.println("-------------------------------------JSON INPUT1 TO STRING-------------------------------------------- \n ");
		System.out.println(input1.toString());
		String string = input1.toString();

		return string;	}

/*	public static void main(String[] args) {
		MachineDAOClassificaPerfil machineDAOClassificaPerfil = new MachineDAOClassificaPerfil();
		machineDAOClassificaPerfil.getDBhistoco("10010479");
	}*/

}
