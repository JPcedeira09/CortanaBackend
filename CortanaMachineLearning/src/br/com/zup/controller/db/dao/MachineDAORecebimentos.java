package br.com.zup.controller.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.zup.cortana.interfaces.db.MachineDAO;
import br.com.zup.cortana.models.Input1Recebimentos;
import br.com.zup.utils.ConnectionFactory;

@Repository
public class MachineDAORecebimentos implements MachineDAO{

	private Connection connection;
	
	public MachineDAORecebimentos() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	@Override
	public String getDBhistoco(String conta) {
		List<String> stringInput = new ArrayList<String>();
		Input1Recebimentos recebimentos = new Input1Recebimentos(); 
		List<Integer> IntegersR = new ArrayList<Integer>();

		String queryRecebimentos= "select  " +
				"SUM(Y.vr_lancamento) as 'VL_LANCAMENTO' " +
				" " +
				" from tb_historico Y  where nr_cnta_crrt = ? and Y.tp_lancamento = 'H' " +
				"GROUP BY  year(Y.dt_carga),MONTH(Y.dt_carga), Y.nr_cnta_crrt  " +
				" ORDER BY  Y.dt_carga DESC " +
				" LIMIT 10";
		try {

			// QUERY PARA RECEBIMENTOS
			PreparedStatement statement = connection.prepareStatement(queryRecebimentos);
			statement.setString(1, conta);
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				Integer soma = set.getInt("VL_LANCAMENTO");
				IntegersR.add(soma);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		recebimentos.setValor_recebido_mes(IntegersR.get(0));
		recebimentos.setValor_recebido_mes_anterior(IntegersR.get(1));
		recebimentos.setValor_recebido_mes_2(IntegersR.get(2));
		recebimentos.setValor_recebido_mes_3(IntegersR.get(3));
		recebimentos.setValor_recebido_mes_4(IntegersR.get(4));
		recebimentos.setValor_recebido_mes_5(IntegersR.get(5));
		recebimentos.setValor_recebido_mes_6(IntegersR.get(6));
		recebimentos.setValor_recebido_mes_7(IntegersR.get(7));
		recebimentos.setValor_recebido_mes_8(IntegersR.get(8));
		recebimentos.setValor_recebido_mes_9(IntegersR.get(9));

		stringInput.add(recebimentos.toJSON());		 
		String input1 = "{\"Inputs\": { \"input1\":"+stringInput.toString() + " } }";

		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("-------------------------------------JSON INPUT1 TO STRING--------------------------------------------");
		System.out.println(input1.toString());
		System.out.println("---------------------------------------------------------------------------------------");

		System.out.println("");
		String string = input1.toString();
		return string;
	}

	/*public static void main(String[] args) {
		MachineDAORecebimentos machineDAOGastos = new MachineDAORecebimentos();
		machineDAOGastos.getDBhistoco("10010479");
	}*/
	
}
