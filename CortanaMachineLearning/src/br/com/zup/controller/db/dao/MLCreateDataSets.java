package br.com.zup.controller.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.zup.cortana.models.LancamentosQuinzenais;
import br.com.zup.models.LancamentosSemanais;
import br.com.zup.utils.ConnectionFactory;


@Repository
public class MLCreateDataSets {

	private Connection connection; 

	public  MLCreateDataSets() {
		this.connection = ConnectionFactory.getConnection();
		System.out.println(connection.toString());
	}
	public List<LancamentosSemanais> geradorGanhosSemanais(String nr_cnta_crrt) {

		List<LancamentosSemanais> historicoList = new ArrayList<LancamentosSemanais>();

		String query = "select " + 
				"Y.nr_cnta_crrt as 'N_CONTA'," + 
				"SUM(Y.vr_lancamento) as 'VL_LANCAMENTO'," + 
				"MONTH(Y.dt_carga)as 'MES' ," + 
				"year(Y.dt_carga)as 'ANO' ," + 
				"(select SUM(A.vr_lancamento) as 'valor' from tb_historico A  where A.tp_lancamento = 'H' and year(Y.dt_carga) = year(A.dt_carga) and MONTH(A.dt_carga) = MONTH(Y.dt_carga) and DAY(A.dt_carga)  in (1,2,3,4,5,6,7) and A.nr_cnta_crrt = Y.nr_cnta_crrt GROUP BY   A.nr_cnta_crrt ) as 'primeira_semana_entrada'," + 
				"(select SUM(B.vr_lancamento) as 'valor' from tb_historico B  where B.tp_lancamento = 'H' and year(Y.dt_carga) = year(B.dt_carga) and  MONTH(B.dt_carga) = MONTH(Y.dt_carga) and DAY(B.dt_carga) in (8,9,10,11,12,13,14)  and B.nr_cnta_crrt = Y.nr_cnta_crrt GROUP BY B.nr_cnta_crrt ) as 'segunda_semana_entrada'," + 
				"(select SUM(C.vr_lancamento) as 'valor' from tb_historico C  where C.tp_lancamento = 'H' and year(Y.dt_carga) = year(C.dt_carga) and  MONTH(C.dt_carga) = MONTH(Y.dt_carga) and DAY(C.dt_carga) in (15,16,17,18,19,20,21,22) and C.nr_cnta_crrt = Y.nr_cnta_crrt  GROUP BY C.nr_cnta_crrt ) as 'terceira_semana_entrada'," + 
				"(select SUM(D.vr_lancamento) as 'valor' from tb_historico D  where D.tp_lancamento = 'H' and year(Y.dt_carga) = year(D.dt_carga) and  MONTH(D.dt_carga) = MONTH(Y.dt_carga) and DAY(D.dt_carga) in (23,24,25,26,27,28,29,30,31)  and D.nr_cnta_crrt = Y.nr_cnta_crrt GROUP BY D.nr_cnta_crrt ) as 'quarta_semana_entrada',                " + 
				"(select SUM(A.vr_lancamento) as 'valor' from tb_historico A  where A.tp_lancamento = 'D' and year(Y.dt_carga) = year(A.dt_carga) and MONTH(A.dt_carga) = MONTH(Y.dt_carga) and DAY(A.dt_carga)  in (1,2,3,4,5,6,7) and A.nr_cnta_crrt = Y.nr_cnta_crrt GROUP BY   A.nr_cnta_crrt ) as 'primeira_semana_saida'," + 
				"(select SUM(B.vr_lancamento) as 'valor' from tb_historico B  where B.tp_lancamento = 'D' and year(Y.dt_carga) = year(B.dt_carga) and  MONTH(B.dt_carga) = MONTH(Y.dt_carga) and DAY(B.dt_carga) in (8,9,10,11,12,13,14)  and B.nr_cnta_crrt = Y.nr_cnta_crrt GROUP BY B.nr_cnta_crrt ) as 'segunda_semana_saida'," + 
				"(select SUM(C.vr_lancamento) as 'valor' from tb_historico C  where C.tp_lancamento = 'D' and year(Y.dt_carga) = year(C.dt_carga) and  MONTH(C.dt_carga) = MONTH(Y.dt_carga) and DAY(C.dt_carga) in (15,16,17,18,19,20,21,22) and C.nr_cnta_crrt = Y.nr_cnta_crrt  GROUP BY C.nr_cnta_crrt ) as 'terceira_semana_saida'," + 
				"(select SUM(D.vr_lancamento) as 'valor' from tb_historico D  where D.tp_lancamento = 'D' and year(Y.dt_carga) = year(D.dt_carga) and  MONTH(D.dt_carga) = MONTH(Y.dt_carga) and DAY(D.dt_carga) in (23,24,25,26,27,28,29,30,31)  and D.nr_cnta_crrt = Y.nr_cnta_crrt GROUP BY D.nr_cnta_crrt ) as 'quarta_semana_saida' " + 
				" from tb_historico Y where nr_cnta_crrt = ? " + 
				"GROUP BY  year(Y.dt_carga),MONTH(Y.dt_carga), Y.nr_cnta_crrt ";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, nr_cnta_crrt);
			ResultSet set = statement.executeQuery();

			while(set.next()) {

				LancamentosSemanais hBancario = new LancamentosSemanais();
				hBancario.setConta(set.getString("N_CONTA"));
				hBancario.setVl_lancamento(set.getBigDecimal("VL_LANCAMENTO"));
				hBancario.setMes(set.getInt("MES"));
				hBancario.setAno(set.getInt("ANO"));
				hBancario.setPrimeira_semana_entrada(set.getBigDecimal("primeira_semana_entrada"));
				hBancario.setSegunda_semana_entrada(set.getBigDecimal("segunda_semana_entrada"));
				hBancario.setTerceira_semana_entrada(set.getBigDecimal("terceira_semana_entrada"));
				hBancario.setQuarta_semana_entrada(set.getBigDecimal("quarta_semana_entrada"));
				hBancario.setPrimeira_semana_saida(set.getBigDecimal("primeira_semana_saida"));
				hBancario.setSegunda_semana_saida(set.getBigDecimal("segunda_semana_saida"));
				hBancario.setTerceira_semana_saida(set.getBigDecimal("terceira_semana_saida"));
				hBancario.setQuarta_semana_saida(set.getBigDecimal("quarta_semana_saida"));
				historicoList.add(hBancario);
			}

			return historicoList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	public List<LancamentosQuinzenais> geradorGanhosQuinzenais(String nr_cnta_crrt) {

		List<LancamentosQuinzenais> historicoList = new ArrayList<LancamentosQuinzenais>();

		String query = "select " + 
				"Y.nr_cnta_crrt as 'conta', " + 
				"SUM(Y.vr_lancamento) as 'vl_lancamento'," + 
				"MONTH(Y.dt_carga)as 'MES' ," + 
				"year(Y.dt_carga)as 'ANO' ," + 
				"(select SUM(A.vr_lancamento) as 'valor' from tb_historico A  where A.tp_lancamento = 'H' and year(Y.dt_carga) = year(A.dt_carga) and MONTH(A.dt_carga) = MONTH(Y.dt_carga) and DAY(A.dt_carga)  in (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15) and A.nr_cnta_crrt = Y.nr_cnta_crrt GROUP BY A.nr_cnta_crrt ) as 'primeira_quinzena_entrada', " + 
				"(select SUM(A.vr_lancamento) as 'valor' from tb_historico A  where A.tp_lancamento = 'D' and year(Y.dt_carga) = year(A.dt_carga) and MONTH(A.dt_carga) = MONTH(Y.dt_carga) and DAY(A.dt_carga)  in (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15) and A.nr_cnta_crrt = Y.nr_cnta_crrt GROUP BY A.nr_cnta_crrt ) as 'primeira_quinzena_saida', " + 
				"(select SUM(D.vr_lancamento) as 'valor' from tb_historico D  where D.tp_lancamento = 'H' and year(Y.dt_carga) = year(D.dt_carga) and  MONTH(D.dt_carga) = MONTH(Y.dt_carga) and DAY(D.dt_carga) in (16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31)  and D.nr_cnta_crrt = Y.nr_cnta_crrt GROUP BY D.nr_cnta_crrt ) as 'segunda_quinzena_entrada', " + 
				"(select SUM(D.vr_lancamento) as 'valor' from tb_historico D  where D.tp_lancamento = 'D' and year(Y.dt_carga) = year(D.dt_carga) and  MONTH(D.dt_carga) = MONTH(Y.dt_carga) and DAY(D.dt_carga) in (16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31)  and D.nr_cnta_crrt = Y.nr_cnta_crrt GROUP BY D.nr_cnta_crrt ) as 'segunda_quinzena_saida' " + 
				" from tb_historico Y where nr_cnta_crrt = ? " + 
				"GROUP BY year(Y.dt_carga), MONTH(Y.dt_carga), Y.nr_cnta_crrt";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, nr_cnta_crrt);
			ResultSet set = statement.executeQuery();

			while(set.next()) {

				LancamentosQuinzenais hBancario = new LancamentosQuinzenais();
				hBancario.setConta(set.getString("conta"));
				hBancario.setVl_lancamento(set.getBigDecimal("vl_lancamento"));
				hBancario.setMes(set.getInt("MES"));
				hBancario.setAno(set.getInt("ANO"));
				hBancario.setPrimeira_quinzena_entrada(set.getBigDecimal("primeira_quinzena_entrada"));
				hBancario.setSegunda_quinzena_entrada(set.getBigDecimal("segunda_quinzena_entrada"));
				hBancario.setPrimeira_quinzena_saida(set.getBigDecimal("primeira_quinzena_saida"));
				hBancario.setSegunda_quinzena_saida(set.getBigDecimal("segunda_quinzena_saida"));
				historicoList.add(hBancario);
			}

			return historicoList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
