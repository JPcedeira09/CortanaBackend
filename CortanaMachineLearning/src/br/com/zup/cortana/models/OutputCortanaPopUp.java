package br.com.zup.cortana.models;

import com.google.gson.Gson;

public class OutputCortanaPopUp {

	
	private String nome;
	private String conta;
	private String mes; 
	private Long saldoMesAnterior;
	private Long recebimentoMes;
	private Long gastosMes;
		
	public OutputCortanaPopUp() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Long getSaldoMesAnterior() {
		return saldoMesAnterior;
	}

	public void setSaldoMesAnterior(Long saldoMesAnterior) {
		this.saldoMesAnterior = saldoMesAnterior;
	}

	public Long getRecebimentoMes() {
		return recebimentoMes;
	}

	public void setRecebimentoMes(Long recebimentoMes) {
		this.recebimentoMes = recebimentoMes;
	}

	public Long getGastosMes() {
		return gastosMes;
	}

	public void setGastosMes(Long gastosMes) {
		this.gastosMes = gastosMes;
	}	

	public String toJSON(){
		return new Gson().toJson(this);
	}
		
	public OutputCortanaPopUp(String nome, String conta, String mes, Long saldoMesAnterior,
			Long recebimentoMes, Long gastosMes) {
		super();
		this.nome = nome;
		this.conta = conta;
		this.mes = mes;
		this.saldoMesAnterior = saldoMesAnterior;
		this.recebimentoMes = recebimentoMes;
		this.gastosMes = gastosMes;
	}

}
