package br.com.zup.controller.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.zup.controller.db.dao.MLCreateDataSets;
import br.com.zup.cortana.interfaces.db.ControllerDatasets;
import br.com.zup.models.LancamentosSemanais;


@Repository
public class LancamentosSemanaisController implements ControllerDatasets<LancamentosSemanais, String>{

	@Autowired
	public MLCreateDataSets mlSets;

	public LancamentosSemanaisController() {
		System.out.println("INFO:Começou a usar o LancamentosSemanaisController.");
	}

	@Override
	public List<LancamentosSemanais> getDatset( String nr_cnta_crrt) {

		List<LancamentosSemanais> list = mlSets.geradorGanhosSemanais(nr_cnta_crrt);
		for(LancamentosSemanais hist : list) {System.out.println(hist); }
		return list;
	}

	/*
	 * 	//private static List<LancamentosSemanais> datset;

		public static void main(String[] args) {
		LancamentosSemanaisController ct = new LancamentosSemanaisController();
		datset = ct.getDatset("10001445");
		for(LancamentosHistorico h : datset) {
			System.out.println(h.toString());
		}
	}*/

}
