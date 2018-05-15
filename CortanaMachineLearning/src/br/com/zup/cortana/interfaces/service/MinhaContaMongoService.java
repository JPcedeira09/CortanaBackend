package br.com.zup.cortana.interfaces.service;

import br.com.zup.models.Meta;
import br.com.zup.models.Perfil;

public interface MinhaContaMongoService {

	public Perfil getPerfil(String nr_pess);
	
	public Meta getMinhaMeta(String nr_pess);
	
}
