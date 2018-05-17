package br.com.zup.controller.startup;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class ReportCortana {

	@Schedule(hour="*", minute = "*/1" , second="*/1", persistent = false)
	public void reportAcessos() {
		//TODO a fazer o metodo de auditoria do sistema cognitivo, like e dislike e avaliação , tags mapeadas no front etc.
		System.out.println("Report");
	}

}
