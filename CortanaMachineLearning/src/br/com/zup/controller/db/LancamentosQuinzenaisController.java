package br.com.zup.controller.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.zup.cortana.controller.db.dao.MLCreateDataSets;
import br.com.zup.cortana.interfaces.db.ControllerDatasets;
import br.com.zup.models.LancamentosQuinzenais;

@Repository
public class LancamentosQuinzenaisController implements ControllerDatasets<LancamentosQuinzenais, String> {

	public LancamentosQuinzenaisController() {
		System.out.println("INFO:Começou a usar o LancamentosQuinzenaisController.");
	}
	
	@Autowired
	public MLCreateDataSets mlSets;

	@Override
	public List<LancamentosQuinzenais> getDatset( String nr_cnta_crrt) {

		List<LancamentosQuinzenais> list = mlSets.geradorGanhosQuinzenais(nr_cnta_crrt);
		for(LancamentosQuinzenais hist : list) {System.out.println(hist); }
		return list;
	}


	/*
	 * 	//private static List<LancamentosQuinzenais> datset;

	public static void main(String[] args) {
		LancamentosQuinzenaisController ct = new LancamentosQuinzenaisController();
		datset = ct.getDatset("10001445");
		for(LancamentosQuinzenais h : datset) {
			System.out.println(h.toString());
		}
	}
	 */
}
