package br.com.zup.cortana.models;

import com.google.gson.Gson;

public class OutputCortanaPopUp {

	
	private String nome;
	private String conta;
	private String mes; 
	private Integer saldoMesAnterior;
	private Integer recebimentoMes;
	private Integer gastosMes;
		
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

	public Integer getSaldoMesAnterior() {
		return saldoMesAnterior;
	}

	public void setSaldoMesAnterior(Integer saldoMesAnterior) {
		this.saldoMesAnterior = saldoMesAnterior;
	}

	public Integer getRecebimentoMes() {
		return recebimentoMes;
	}

	public void setRecebimentoMes(Integer recebimentoMes) {
		this.recebimentoMes = recebimentoMes;
	}

	public Integer getGastosMes() {
		return gastosMes;
	}

	public void setGastosMes(Integer gastosMes) {
		this.gastosMes = gastosMes;
	}	

	public String toJSON(){
		return new Gson().toJson(this);
	}
		
	public OutputCortanaPopUp(String nome, String conta, String mes, Integer saldoMesAnterior,
			Integer recebimentoMes, Integer gastosMes) {
		super();
		this.nome = nome;
		this.conta = conta;
		this.mes = mes;
		this.saldoMesAnterior = saldoMesAnterior;
		this.recebimentoMes = recebimentoMes;
		this.gastosMes = gastosMes;
	}

}
