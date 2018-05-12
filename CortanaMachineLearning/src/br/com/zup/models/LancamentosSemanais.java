package br.com.zup.models;

import java.math.BigDecimal;

import com.google.gson.Gson;



public class LancamentosSemanais {

	private String conta;
	private BigDecimal vl_lancamento;
	private Integer mes;
	private Integer ano;
	private BigDecimal primeira_semana_entrada;
	private BigDecimal segunda_semana_entrada;
	private BigDecimal terceira_semana_entrada;
	private BigDecimal quarta_semana_entrada;
	private BigDecimal primeira_semana_saida;
	private BigDecimal segunda_semana_saida;
	private BigDecimal terceira_semana_saida;
	private BigDecimal quarta_semana_saida;

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


	public BigDecimal getPrimeira_semana_entrada() {
		return primeira_semana_entrada;
	}


	public void setPrimeira_semana_entrada(BigDecimal primeira_semana_entrada) {
		this.primeira_semana_entrada = primeira_semana_entrada;
	}


	public BigDecimal getSegunda_semana_entrada() {
		return segunda_semana_entrada;
	}


	public void setSegunda_semana_entrada(BigDecimal segunda_semana_entrada) {
		this.segunda_semana_entrada = segunda_semana_entrada;
	}


	public BigDecimal getTerceira_semana_entrada() {
		return terceira_semana_entrada;
	}


	public void setTerceira_semana_entrada(BigDecimal terceira_semana_entrada) {
		this.terceira_semana_entrada = terceira_semana_entrada;
	}


	public BigDecimal getQuarta_semana_entrada() {
		return quarta_semana_entrada;
	}


	public void setQuarta_semana_entrada(BigDecimal quarta_semana_entrada) {
		this.quarta_semana_entrada = quarta_semana_entrada;
	}


	public BigDecimal getPrimeira_semana_saida() {
		return primeira_semana_saida;
	}


	public void setPrimeira_semana_saida(BigDecimal primeira_semana_saida) {
		this.primeira_semana_saida = primeira_semana_saida;
	}


	public BigDecimal getSegunda_semana_saida() {
		return segunda_semana_saida;
	}


	public void setSegunda_semana_saida(BigDecimal segunda_semana_saida) {
		this.segunda_semana_saida = segunda_semana_saida;
	}


	public BigDecimal getTerceira_semana_saida() {
		return terceira_semana_saida;
	}


	public void setTerceira_semana_saida(BigDecimal terceira_semana_saida) {
		this.terceira_semana_saida = terceira_semana_saida;
	}


	public BigDecimal getQuarta_semana_saida() {
		return quarta_semana_saida;
	}


	public void setQuarta_semana_saida(BigDecimal quarta_semana_saida) {
		this.quarta_semana_saida = quarta_semana_saida;
	}


	public String toJSON() {
		return new Gson().toJson(this);
	}


	public LancamentosSemanais(String conta, BigDecimal vl_lancamento, Integer mes, Integer ano,
			BigDecimal primeira_semana_entrada, BigDecimal segunda_semana_entrada, BigDecimal terceira_semana_entrada,
			BigDecimal quarta_semana_entrada, BigDecimal primeira_semana_saida, BigDecimal segunda_semana_saida,
			BigDecimal terceira_semana_saida, BigDecimal quarta_semana_saida) {
		super();
		this.conta = conta;
		this.vl_lancamento = vl_lancamento;
		this.mes = mes;
		this.ano = ano;
		this.primeira_semana_entrada = primeira_semana_entrada;
		this.segunda_semana_entrada = segunda_semana_entrada;
		this.terceira_semana_entrada = terceira_semana_entrada;
		this.quarta_semana_entrada = quarta_semana_entrada;
		this.primeira_semana_saida = primeira_semana_saida;
		this.segunda_semana_saida = segunda_semana_saida;
		this.terceira_semana_saida = terceira_semana_saida;
		this.quarta_semana_saida = quarta_semana_saida;
	}
	
	

	public LancamentosSemanais() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		LancamentosSemanais historico = new LancamentosSemanais("9000", new BigDecimal(89.98), new Integer(8), new Integer(2018), new BigDecimal(89.98), new BigDecimal(89.98), new BigDecimal(89.98), new BigDecimal(89.98), new BigDecimal(89.98), new BigDecimal(89.98), new BigDecimal(89.98), new BigDecimal(89.98));
		System.out.println(historico.toJSON());
	}

	@Override
	public String toString() {
		return "LancamentosHistorico [conta=" + conta + ", vl_lancamento=" + vl_lancamento + ", mes=" + mes + ", ano="
				+ ano + ", primeira_semana_entrada=" + primeira_semana_entrada + ", segunda_semana_entrada="
				+ segunda_semana_entrada + ", terceira_semana_entrada=" + terceira_semana_entrada
				+ ", quarta_semana_entrada=" + quarta_semana_entrada + ", primeira_semana_saida="
				+ primeira_semana_saida + ", segunda_semana_saida=" + segunda_semana_saida + ", terceira_semana_saida="
				+ terceira_semana_saida + ", quarta_semana_saida=" + quarta_semana_saida + "]";
	}
	
	
	
}
