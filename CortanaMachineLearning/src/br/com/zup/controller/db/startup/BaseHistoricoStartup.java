package br.com.zup.controller.db.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.zup.utils.ReaderCSVHistorico;


//@Singleton
//@Startup
@Repository
public class BaseHistoricoStartup {

	public BaseHistoricoStartup() {
		System.out.println("INFO:BaseHistoricoStartup contruida");
	}

	@Autowired
	private ReaderCSVHistorico reader;

	//@Schedule(dayOfWeek="Mon,Wed", hour="12", minute="00", persistent = true)
	public void statupDBHistorico() {
		reader.createDBHist();
	}

}
