package br.com.zup.cortana.interfaces.db;

import java.util.List;

public interface ControllerDatasets <T,K>{

	public List<T> getDatset(K ID);
	
}
