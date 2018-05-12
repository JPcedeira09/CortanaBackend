package br.com.zup.controller.db;

import java.util.List;

import br.com.zup.controller.db.dao.MLCreateDataSets;
import br.com.zup.cortana.interfaces.db.ControllerDatasets;
import br.com.zup.cortana.models.LancamentosQuinzenais;

public class LancamentosQuinzenaisController implements ControllerDatasets<LancamentosQuinzenais, String> {

	public MLCreateDataSets mlSets;

	//private static List<LancamentosQuinzenais> datset;

	public LancamentosQuinzenaisController() {
		this.mlSets = new MLCreateDataSets();
		System.out.println("MLCreateDataSets construido");
	}

	@Override
	public List<LancamentosQuinzenais> getDatset( String nr_cnta_crrt) {

		List<LancamentosQuinzenais> list = mlSets.geradorGanhosQuinzenais(nr_cnta_crrt);
		for(LancamentosQuinzenais hist : list) {System.out.println(hist); }
		return list;
	}

	/*
	public static void main(String[] args) {
		LancamentosQuinzenaisController ct = new LancamentosQuinzenaisController();
		datset = ct.getDatset("10001445");
		for(LancamentosQuinzenais h : datset) {
			System.out.println(h.toString());
		}
	}
	 */
}
