package br.com.zup.controller.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zup.cortana.models.Input1Gastos;
import br.com.zup.utils.ConnectionFactory;


public class MachineDAOGastos implements MachineDAO{

	private Connection connection; 

	public MachineDAOGastos() {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public String getDBhistoco(String conta) {

		List<String> stringInput = new ArrayList<String>();
		Input1Gastos input1Gastos = new Input1Gastos(); 
		List<Integer> IntegersG = new ArrayList<Integer>();
		List<Integer> IntegersR = new ArrayList<Integer>();

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
				Integer soma = set1.getInt("VL_LANCAMENTO");
				IntegersG.add(soma);
			}


			// QUERY PARA RECEBIMENTOS
			PreparedStatement statement2 = this.connection.prepareStatement(queryRecebimentos);
			statement2.setString(1, conta);
			ResultSet set2 = statement2.executeQuery();
			while(set2.next()) {
				Integer soma = set2.getInt("VL_LANCAMENTO");
				IntegersR.add(soma);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		input1Gastos.setValor_gasto_mes(IntegersG.get(0));
		input1Gastos.setValor_gasto_mes_anterior(IntegersG.get(1));
		input1Gastos.setValor_gasto_mes2(IntegersG.get(2));
		input1Gastos.setValor_gasto_mes3(IntegersG.get(3));
		input1Gastos.setValor_gasto_mes4(IntegersG.get(4));
		input1Gastos.setValor_gasto_mes5(IntegersG.get(5));
		input1Gastos.setValor_gasto_mes6(IntegersG.get(6));
		input1Gastos.setValor_recebido_mes_anterior(IntegersR.get(1));
		input1Gastos.setValor_recebido_mes2(IntegersR.get(2));
		input1Gastos.setValor_recebido_mes3(IntegersR.get(3));

		stringInput.add(input1Gastos.toJSON());		 
		String input1 = "{\"Inputs\": { \"input1\":"+stringInput.toString() + " } }";

		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("-------------------------------------JSON INPUT1 TO STRING--------------------------------------------");
		System.out.println(input1.toString());
		System.out.println("---------------------------------------------------------------------------------------");

		System.out.println("");
		String string = input1.toString();
		
		return string;
	}

	public static void main(String[] args) {
		MachineDAOGastos machineDAOGastos = new MachineDAOGastos();
		machineDAOGastos.getDBhistoco("10010479");

	}

}
