package br.com.zup.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Table(name="tb_historico")
@Entity
public class HistoricoBancario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id_transacao")
	private Long ID;
	
	private String cd_unorg_agen;
	private String nr_cnta_crrt;
	private String cd_empresa;
	private String nr_seq_lancamento;	
	private String nr_ptenv;
	private String cd_lancamento;	
	private Long vr_lancamento;	
	private String tp_lancamento;
	private String tp_debito;
	private String cd_tipo_ptenv;	
	private String nm_lancamento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dt_contabil;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dt_lancamento;	

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dt_carga;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getCd_unorg_agen() {
		return cd_unorg_agen;
	}
	public void setCd_unorg_agen(String cd_unorg_agen) {
		this.cd_unorg_agen = cd_unorg_agen;
	}
	public String getNr_cnta_crrt() {
		return nr_cnta_crrt;
	}
	public void setNr_cnta_crrt(String nr_cnta_crrt) {
		this.nr_cnta_crrt = nr_cnta_crrt;
	}
	public String getCd_empresa() {
		return cd_empresa;
	}
	public void setCd_empresa(String cd_empresa) {
		this.cd_empresa = cd_empresa;
	}
	public String getNr_seq_lancamento() {
		return nr_seq_lancamento;
	}
	public void setNr_seq_lancamento(String nr_seq_lancamento) {
		this.nr_seq_lancamento = nr_seq_lancamento;
	}
	public String getNr_ptenv() {
		return nr_ptenv;
	}
	public void setNr_ptenv(String nr_ptenv) {
		this.nr_ptenv = nr_ptenv;
	}
	public String getCd_lancamento() {
		return cd_lancamento;
	}
	public void setCd_lancamento(String cd_lancamento) {
		this.cd_lancamento = cd_lancamento;
	}
	public Long getVr_lancamento() {
		return vr_lancamento;
	}
	public void setVr_lancamento(Long vr_lancamento) {
		this.vr_lancamento = vr_lancamento;
	}
	public Calendar getDt_contabil() {
		return dt_contabil;
	}
	public void setDt_contabil(Calendar dt_contabil) {
		this.dt_contabil = dt_contabil;
	}
	public Calendar getDt_lancamento() {
		return dt_lancamento;
	}
	public void setDt_lancamento(Calendar dt_lancamento) {
		this.dt_lancamento = dt_lancamento;
	}
	public String getTp_lancamento() {
		return tp_lancamento;
	}
	public void setTp_lancamento(String tp_lancamento) {
		this.tp_lancamento = tp_lancamento;
	}
	public String getTp_debito() {
		return tp_debito;
	}
	public void setTp_debito(String tp_debito) {
		this.tp_debito = tp_debito;
	}
	public String getCd_tipo_ptenv() {
		return cd_tipo_ptenv;
	}
	public void setCd_tipo_ptenv(String cd_tipo_ptenv) {
		this.cd_tipo_ptenv = cd_tipo_ptenv;
	}
	public Calendar getDt_carga() {
		return dt_carga;
	}
	public void setDt_carga(Calendar dt_carga) {
		this.dt_carga = dt_carga;
	}
	public String getNm_lancamento() {
		return nm_lancamento;
	}
	public void setNm_lancamento(String nm_lancamento) {
		this.nm_lancamento = nm_lancamento;
	}
	
	public HistoricoBancario() {
		super();

	}
	@Override
	public String toString() {
		return "HistoricoBancario [ID=" + ID + ", cd_unorg_agen=" + cd_unorg_agen + ", nr_cnta_crrt=" + nr_cnta_crrt
				+ ", cd_empresa=" + cd_empresa + ", nr_seq_lancamento=" + nr_seq_lancamento + ", nr_ptenv=" + nr_ptenv
				+ ", cd_lancamento=" + cd_lancamento + ", vr_lancamento=" + vr_lancamento + ", tp_lancamento="
				+ tp_lancamento + ", tp_debito=" + tp_debito + ", cd_tipo_ptenv=" + cd_tipo_ptenv + ", nm_lancamento="
				+ nm_lancamento + ", dt_contabil=" + dt_contabil + ", dt_lancamento=" + dt_lancamento + ", dt_carga="
				+ dt_carga + "]";
	}
	
	
}
