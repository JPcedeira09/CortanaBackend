package br.com.zup.controller.db.dao;

import java.math.BigDecimal;

public class SomaDoConta {

	private BigDecimal vr_lancamento;

	public BigDecimal getVr_lancamento() {
		return vr_lancamento;
	}

	public void setVr_lancamento(BigDecimal vr_lancamento) {
		this.vr_lancamento = vr_lancamento;
	}

	public SomaDoConta(BigDecimal vr_lancamento) {
		super();
		this.vr_lancamento = vr_lancamento;
	}

	public SomaDoConta() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SomaDoConta [vr_lancamento=" + vr_lancamento + "]";
	}
	
	
}
