package br.com.zup.cortana.models;

import java.math.BigDecimal;

import com.google.gson.Gson;

public class OutputCortanaPopUp {

	
	private String nome;
	private String conta;
	private String mes; 
	private BigDecimal saldoMesAnterior;
	private BigDecimal recebimentoMes;
	private BigDecimal gastosMes;
		
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

	public BigDecimal getSaldoMesAnterior() {
		return saldoMesAnterior;
	}

	public void setSaldoMesAnterior(BigDecimal saldoMesAnterior) {
		this.saldoMesAnterior = saldoMesAnterior;
	}

	public BigDecimal getRecebimentoMes() {
		return recebimentoMes;
	}

	public void setRecebimentoMes(BigDecimal recebimentoMes) {
		this.recebimentoMes = recebimentoMes;
	}

	public BigDecimal getGastosMes() {
		return gastosMes;
	}

	public void setGastosMes(BigDecimal gastosMes) {
		this.gastosMes = gastosMes;
	}	

	public String toJSON(){
		return new Gson().toJson(this);
	}
		
	public OutputCortanaPopUp(String nome, String conta, String mes, BigDecimal saldoMesAnterior,
			BigDecimal recebimentoMes, BigDecimal gastosMes) {
		super();
		this.nome = nome;
		this.conta = conta;
		this.mes = mes;
		this.saldoMesAnterior = saldoMesAnterior;
		this.recebimentoMes = recebimentoMes;
		this.gastosMes = gastosMes;
	}

	public static void main(String[] args) {
		OutputCortanaPopUp outputCortanaPopUp = new OutputCortanaPopUp("João Paulo", "123456", "12", new BigDecimal(-200.00), new BigDecimal(800.00), new BigDecimal(700.00));
		System.out.println(outputCortanaPopUp.toJSON());
	}
}
