package br.com.zup.models.cortana.service;

import com.google.gson.Gson;

public class Input1ClassificacaoPerfil {

	private Long valor_saldo_mes_2;
	private Long valor_saldo_mes_3;
	private Long valor_saldo_mes_4;
	private Long valor_saldo_mes_5;
	private Long valor_saldo_mes_futuro;
	private Long indentificador; // = 0
	
	public Long getValor_saldo_mes_2() {
		return valor_saldo_mes_2;
	}
	public void setValor_saldo_mes_2(Long valor_saldo_mes_2) {
		this.valor_saldo_mes_2 = valor_saldo_mes_2;
	}
	public Long getValor_saldo_mes_3() {
		return valor_saldo_mes_3;
	}
	public void setValor_saldo_mes_3(Long valor_saldo_mes_3) {
		this.valor_saldo_mes_3 = valor_saldo_mes_3;
	}
	public Long getValor_saldo_mes_4() {
		return valor_saldo_mes_4;
	}
	public void setValor_saldo_mes_4(Long valor_saldo_mes_4) {
		this.valor_saldo_mes_4 = valor_saldo_mes_4;
	}
	public Long getValor_saldo_mes_5() {
		return valor_saldo_mes_5;
	}
	public void setValor_saldo_mes_5(Long valor_saldo_mes_5) {
		this.valor_saldo_mes_5 = valor_saldo_mes_5;
	}
	public Long getValor_saldo_mes_futuro() {
		return valor_saldo_mes_futuro;
	}
	public void setValor_saldo_mes_futuro(Long valor_saldo_mes_futuro) {
		this.valor_saldo_mes_futuro = valor_saldo_mes_futuro;
	}
	public Long getIndentificador() {
		return indentificador;
	}
	public void setIndentificador(Long indentificador) {
		this.indentificador = indentificador;
	}
	
	public Input1ClassificacaoPerfil(Long valor_saldo_mes_2, Long valor_saldo_mes_3, Long valor_saldo_mes_4,
			Long valor_saldo_mes_5, Long valor_saldo_mes_futuro, Long indentificador) {
		super();
		this.valor_saldo_mes_2 = valor_saldo_mes_2;
		this.valor_saldo_mes_3 = valor_saldo_mes_3;
		this.valor_saldo_mes_4 = valor_saldo_mes_4;
		this.valor_saldo_mes_5 = valor_saldo_mes_5;
		this.valor_saldo_mes_futuro = valor_saldo_mes_futuro;
		this.indentificador = indentificador;
	}
	
	public Input1ClassificacaoPerfil() {
		super();
	}

	
	public String toJSON() {
		return new Gson().toJson(this);
	}
	
}
