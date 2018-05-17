package br.com.zup.cortana.interfaces.Mongo;

import br.com.zup.models.Meta;
import br.com.zup.models.Perfil;

public interface MinhaContaMongo {
	
	public Perfil getPerfil(String nr_pess);
	
	public Meta getMinhaMeta(String nr_pess);
	
}
