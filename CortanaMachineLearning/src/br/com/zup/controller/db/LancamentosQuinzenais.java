package br.com.zup.controller.db;

import java.math.BigDecimal;

import com.google.gson.Gson;

public class LancamentosQuinzenais {

	private String conta;	
	private BigDecimal vl_lancamento; 
	private Integer mes;
	private Integer ano;	
	private BigDecimal primeira_quinzena_entrada; 
	private BigDecimal primeira_quinzena_saida; 	
	private BigDecimal segunda_quinzena_entrada; 	 
	private BigDecimal segunda_quinzena_saida;

	
	public String getConta() {
		return conta;
	}


	public void setConta(String conta) {
		this.conta = conta;
	}


	public BigDecimal getVl_lancamento() {
		return vl_lancamento;
	}


	public void setVl_lancamento(BigDecimal vl_lancamento) {
		this.vl_lancamento = vl_lancamento;
	}


	public Integer getMes() {
		return mes;
	}


	public void setMes(Integer mes) {
		this.mes = mes;
	}


	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}


	public BigDecimal getPrimeira_quinzena_entrada() {
		return primeira_quinzena_entrada;
	}


	public void setPrimeira_quinzena_entrada(BigDecimal primeira_quinzena_entrada) {
		this.primeira_quinzena_entrada = primeira_quinzena_entrada;
	}


	public BigDecimal getPrimeira_quinzena_saida() {
		return primeira_quinzena_saida;
	}


	public void setPrimeira_quinzena_saida(BigDecimal primeira_quinzena_saida) {
		this.primeira_quinzena_saida = primeira_quinzena_saida;
	}


	public BigDecimal getSegunda_quinzena_entrada() {
		return segunda_quinzena_entrada;
	}


	public void setSegunda_quinzena_entrada(BigDecimal segunda_quinzena_entrada) {
		this.segunda_quinzena_entrada = segunda_quinzena_entrada;
	}


	public BigDecimal getSegunda_quinzena_saida() {
		return segunda_quinzena_saida;
	}


	public void setSegunda_quinzena_saida(BigDecimal segunda_quinzena_saida) {
		this.segunda_quinzena_saida = segunda_quinzena_saida;
	}

	public LancamentosQuinzenais() {
		super();
	}

	public LancamentosQuinzenais(String conta, BigDecimal vl_lancamento, Integer mes, Integer ano,
			BigDecimal primeira_quinzena_entrada, BigDecimal primeira_quinzena_saida,
			BigDecimal segunda_quinzena_entrada, BigDecimal segunda_quinzena_saida) {
		super();
		this.conta = conta;
		this.vl_lancamento = vl_lancamento;
		this.mes = mes;
		this.ano = ano;
		this.primeira_quinzena_entrada = primeira_quinzena_entrada;
		this.primeira_quinzena_saida = primeira_quinzena_saida;
		this.segunda_quinzena_entrada = segunda_quinzena_entrada;
		this.segunda_quinzena_saida = segunda_quinzena_saida;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}


	@Override
	public String toString() {
		return "LancamentosQuinzenais [conta=" + conta + ", vl_lancamento=" + vl_lancamento + ", mes=" + mes + ", ano="
				+ ano + ", primeira_quinzena_entrada=" + primeira_quinzena_entrada + ", primeira_quinzena_saida="
				+ primeira_quinzena_saida + ", segunda_quinzena_entrada=" + segunda_quinzena_entrada
				+ ", segunda_quinzena_saida=" + segunda_quinzena_saida + "]";
	}	
	
}
