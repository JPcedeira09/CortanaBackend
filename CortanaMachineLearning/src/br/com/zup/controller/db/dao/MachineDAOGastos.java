package br.com.zup.controller.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.zup.cortana.interfaces.db.MachineDAO;
import br.com.zup.cortana.models.Input1Gastos;
import br.com.zup.utils.ConnectionFactoryJPA;

@Repository
public class MachineDAOGastos implements MachineDAO{

	private EntityManager manager;

	public MachineDAOGastos() {
		this.manager = ConnectionFactoryJPA.getEntityManager();
	}

	@Override
	public String getDBhistoco(String conta) {

		List<String> stringInput = new ArrayList<String>();
		Input1Gastos input1Gastos = new Input1Gastos(); 
		List<Long> LongsG = new ArrayList<Long>();
		List<Long> LongsR = new ArrayList<Long>();

		/* 
		 * Bloco que usa JPA para pegar os gastos do cliente
		 */
		String jpqlGastos = "select sum(h.vr_lancamento) from HistoricoBancario h where h.nr_cnta_crrt = :nr_cnta_crrt and h.tp_lancamento = :tp_lancamento "
				+ " group by  year(h.dt_carga), month(h.dt_carga), h.nr_cnta_crrt  "
				+ "order by  h.dt_carga DESC";

		System.out.println("======= Result JPA Gasto =========");
		TypedQuery<Long> queryG = manager.createQuery(jpqlGastos, Long.class)
				.setParameter("nr_cnta_crrt", conta)
				.setParameter("tp_lancamento", "D").setMaxResults(7);
		System.out.println(queryG.getResultList()+ " \n");
		LongsG = queryG.getResultList();

		/* 
		 * Bloco que usa JPA para pegar os recebimentos do cliente
		 */
		String jpqlRecebimentos = "select sum(h.vr_lancamento) from HistoricoBancario h where h.nr_cnta_crrt = :nr_cnta_crrt and h.tp_lancamento = :tp_lancamento "
				+ " group by  year(h.dt_carga), month(h.dt_carga), h.nr_cnta_crrt  "
				+ "order by  h.dt_carga DESC";

		System.out.println("======= Result JPA Recebimentos =========");
		TypedQuery<Long> queryR = manager.createQuery(jpqlRecebimentos, Long.class)
				.setParameter("nr_cnta_crrt", conta)
				.setParameter("tp_lancamento", "H").setMaxResults(4);
		System.out.println(queryR.getResultList() + " \n");
		LongsR = queryR.getResultList();


		input1Gastos.setValor_gasto_mes(LongsG.get(0));
		input1Gastos.setValor_gasto_mes_anterior(LongsG.get(1));
		input1Gastos.setValor_gasto_mes2(LongsG.get(2));
		input1Gastos.setValor_gasto_mes3(LongsG.get(3));
		input1Gastos.setValor_gasto_mes4(LongsG.get(4));
		input1Gastos.setValor_gasto_mes5(LongsG.get(5));
		input1Gastos.setValor_gasto_mes6(LongsG.get(6));
		input1Gastos.setValor_recebido_mes_anterior(LongsR.get(1));
		input1Gastos.setValor_recebido_mes2(LongsR.get(2));
		input1Gastos.setValor_recebido_mes3(LongsR.get(3));

		stringInput.add(input1Gastos.toJSON());		 
		String input1 = "{\"Inputs\": { \"input1\":"+stringInput.toString() + " } }";

		System.out.println("-------------------------------------JSON INPUT1 TO STRING-------------------------------------------- \n ");
		System.out.println(input1.toString());
		String string = input1.toString();

		return string;
	}

	/*
	public static void main(String[] args) {
		MachineDAOGastos machineDAOGastos = new MachineDAOGastos();
		machineDAOGastos.getDBhistoco("10010479");
	}*/

}

/*
 * 
 * 	//private Connection connection; 
//this.connection = ConnectionFactory.getConnection();

String queryGastos = "select  " +
		" SUM(Y.vr_lancamento) as 'VL_LANCAMENTO' " +
		" from tb_historico Y  where nr_cnta_crrt = ? and Y.tp_lancamento = 'D' " +
		" GROUP BY  year(Y.dt_carga),MONTH(Y.dt_carga), Y.nr_cnta_crrt  " +
		" ORDER BY  Y.dt_carga DESC " +
		" LIMIT 7";

String queryRecebimentos= "select  " +
		"SUM(Y.vr_lancamento) as 'VL_LANCAMENTO' " +
		" " +
		" from tb_historico Y  where nr_cnta_crrt = ? and Y.tp_lancamento = 'H' " +
		"GROUP BY  year(Y.dt_carga),MONTH(Y.dt_carga), Y.nr_cnta_crrt  " +
		" ORDER BY  Y.dt_carga DESC " +
		" LIMIT 4";

try {

	// QUERY PARA GASTOS
	PreparedStatement statement1 = this.connection.prepareStatement(queryGastos);
	statement1.setString(1, conta);

	ResultSet set1 = statement1.executeQuery();
	while(set1.next()) {
		Long soma = set1.getLong("VL_LANCAMENTO");
		IntegersG.add(soma);
	}

	// QUERY PARA RECEBIMENTOS
	PreparedStatement statement2 = this.connection.prepareStatement(queryRecebimentos);
	statement2.setString(1, conta);
	ResultSet set2 = statement2.executeQuery();
	while(set2.next()) {
		Long soma = set2.getLong("VL_LANCAMENTO");
		IntegersR.add(soma);
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 */

