package br.com.zup.models;

public class Meta {

	private String nr_pess;
	private Double valorMeta;
	private int porcentagemMeta;
	private Double seuSaving;
	private int quantidadeDeMeses;
	private Double savingDoMes;

	
	public String getNr_pess() {
		return nr_pess;
	}
	public void setNr_pess(String nr_pess) {
		this.nr_pess = nr_pess;
	}
	public Double getValorMeta() {
		return valorMeta;
	}
	public void setValorMeta(Double valorMeta) {
		this.valorMeta = valorMeta;
	}
	public int getPorcentagemMeta() {
		return porcentagemMeta;
	}
	public void setPorcentagemMeta(int porcentagemMeta) {
		this.porcentagemMeta = porcentagemMeta;
	}
	public Double getSeuSaving() {
		return seuSaving;
	}
	public void setSeuSaving(Double seuSaving) {
		this.seuSaving = seuSaving;
	}
	public int getQuantidadeDeMeses() {
		return quantidadeDeMeses;
	}
	public void setQuantidadeDeMeses(int quantidadeDeMeses) {
		this.quantidadeDeMeses = quantidadeDeMeses;
	}
	public Double getSavingDoMes() {
		return savingDoMes;
	}
	public void setSavingDoMes(Double savingDoMes) {
		this.savingDoMes = savingDoMes;
	}
	
	public Meta() {
		super();
	}
	
	public Meta(String nr_pess, Double valorMeta, int porcentagemMeta, Double seuSaving, int quantidadeDeMeses,
			Double savingDoMes) {
		super();
		this.nr_pess = nr_pess;
		this.valorMeta = valorMeta;
		this.porcentagemMeta = porcentagemMeta;
		this.seuSaving = seuSaving;
		this.quantidadeDeMeses = quantidadeDeMeses;
		this.savingDoMes = savingDoMes;
	}
	
	@Override
	public String toString() {
		return "Meta [nr_pess=" + nr_pess + ", valorMeta=" + valorMeta + ", porcentagemMeta=" + porcentagemMeta
				+ ", seuSaving=" + seuSaving + ", quantidadeDeMeses=" + quantidadeDeMeses + ", savingDoMes="
				+ savingDoMes + "]";
	}

	
}
