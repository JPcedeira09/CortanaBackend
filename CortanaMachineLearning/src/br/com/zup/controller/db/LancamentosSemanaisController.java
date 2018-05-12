package br.com.zup.controller.db;

import java.util.List;

import br.com.zup.controller.db.dao.MLCreateDataSets;
import br.com.zup.cortana.interfaces.db.ControllerDatasets;
import br.com.zup.models.LancamentosSemanais;


public class LancamentosSemanaisController implements ControllerDatasets<LancamentosSemanais, String>{

	public MLCreateDataSets mlSets;
	
	//private static List<LancamentosSemanais> datset;
	
	public LancamentosSemanaisController() {
		this.mlSets = new MLCreateDataSets();
		System.out.println("MLCreateDataSets construido");
	}
	
	@Override
	public List<LancamentosSemanais> getDatset( String nr_cnta_crrt) {
		
		List<LancamentosSemanais> list = mlSets.geradorGanhosSemanais(nr_cnta_crrt);
		for(LancamentosSemanais hist : list) {System.out.println(hist); }
		return list;
	}

	/*public static void main(String[] args) {
		LancamentosSemanaisController ct = new LancamentosSemanaisController();
		datset = ct.getDatset("10001445");
		for(LancamentosHistorico h : datset) {
			System.out.println(h.toString());
		}
	}*/
	
}
