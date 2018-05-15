package br.com.zup.models;

import java.sql.Blob;

public class Perfil {

	private String nr_pess;
	private String nome;
	private Blob imagemPerfi;
	private Double saldoContaCorrente;
	private Double valorCartaoCredito;
	private Double saldoEmprestimo;
	private Double saldoInvestimento;
	
	public String getNr_pess() {
		return nr_pess;
	}
	public void setNr_pess(String nr_pess) {
		this.nr_pess = nr_pess;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Blob getImagemPerfi() {
		return imagemPerfi;
	}
	public void setImagemPerfi(Blob imagemPerfi) {
		this.imagemPerfi = imagemPerfi;
	}
	public Double getSaldoContaCorrente() {
		return saldoContaCorrente;
	}
	public void setSaldoContaCorrente(Double saldoContaCorrente) {
		this.saldoContaCorrente = saldoContaCorrente;
	}
	public Double getValorCartaoCredito() {
		return valorCartaoCredito;
	}
	public void setValorCartaoCredito(Double valorCartaoCredito) {
		this.valorCartaoCredito = valorCartaoCredito;
	}
	public Double getSaldoEmprestimo() {
		return saldoEmprestimo;
	}
	public void setSaldoEmprestimo(Double saldoEmprestimo) {
		this.saldoEmprestimo = saldoEmprestimo;
	}
	public Double getSaldoInvestimento() {
		return saldoInvestimento;
	}
	public void setSaldoInvestimento(Double saldoInvestimento) {
		this.saldoInvestimento = saldoInvestimento;
	}
	
	@Override
	public String toString() {
		return "Perfil [nr_pess=" + nr_pess + ", nome=" + nome + ", imagemPerfi=" + imagemPerfi
				+ ", saldoContaCorrente=" + saldoContaCorrente + ", valorCartaoCredito=" + valorCartaoCredito
				+ ", saldoEmprestimo=" + saldoEmprestimo + ", saldoInvestimento=" + saldoInvestimento + "]";
	}
	
	public Perfil(String nr_pess, String nome, Blob imagemPerfi, Double saldoContaCorrente, Double valorCartaoCredito,
			Double saldoEmprestimo, Double saldoInvestimento) {
		super();
		this.nr_pess = nr_pess;
		this.nome = nome;
		this.imagemPerfi = imagemPerfi;
		this.saldoContaCorrente = saldoContaCorrente;
		this.valorCartaoCredito = valorCartaoCredito;
		this.saldoEmprestimo = saldoEmprestimo;
		this.saldoInvestimento = saldoInvestimento;
	}
	
	public Perfil() {
		super();
	}
	
}
