package br.com.zup.cortana.models;

import org.bson.types.ObjectId;

import com.google.gson.Gson;

public class DataSet {

	private ObjectId _id;
	private String nr_pess;
	private String ano_mes;
	private String tempo_cc	;
	private String segmento	;
	private String ds_timps_com	;
	private String qt_idad;
	private String cd_sexo;	
	private String cd_esta_civi	;
	private String qt_depe;	
	private String cd_esco;	
	private String cd_grau_seve	;
	private String cd_esco_cojg	;
	private String renda_final;	
	private String deb_total_cc;
	private String cr_total_cc	;
	private String qtde_cc	;
	private String vl_sald_disp_totl;	
	private String vl_cntr_csg;	
	private String vl_sld_dev_csg;	
	private String vl_sld_invest;	
	private String crt_qtd_crt_base	;
	private String crt_vl_limi_cnta	;
	private String crt_vl_limi_comprom;	
	private String crt_qtd_mcc_ag_tur;	
	private String crt_qtd_mcc_alug_carr;	
	private String crt_qtd_mcc_art_eletr;	
	private String crt_qtd_mcc_aut_pcas;	
	private String crt_qtd_mcc_cia_aerea;	
	private String crt_qtd_mcc_farmacia	;
	private String crt_qtd_mcc_hospital;	
	private String crt_qtd_mcc_hoteis;	
	private String crt_qtd_mcc_joalheria;	
	private String crt_qtd_mcc_loj_depar;	
	private String crt_qtd_mcc_mat_const;	
	private String crt_qtd_mcc_mkt_direto;	
	private String crt_qtd_mcc_moveis_deco;	
	private String crt_qtd_mcc_outros;	
	private String crt_qtd_mcc_pag_conta;	
	private String crt_qtd_mcc_post_gas;	
	private String crt_qtd_mcc_restaur;	
	private String crt_qtd_mcc_servico;	
	private String crt_qtd_mcc_supermerc;	
	private String crt_qtd_mcc_varejo;	
	private String crt_qtd_mcc_vestuario;	
	private String crt_vl_compra_exter;	
	private String crt_vl_mcc_ag_tur;	
	private String crt_vl_mcc_alug_carr;
	private String crt_vl_mcc_art_eletr;
	private String crt_vl_mcc_aut_pcas;	
	private String crt_vl_mcc_cia_aerea;
	private String crt_vl_mcc_farmacia;	
	private String crt_vl_mcc_hospital;	
	private String crt_vl_mcc_hoteis;	
	private String crt_vl_mcc_joalheria;
	private String crt_vl_mcc_loj_depar;	
	private String crt_vl_mcc_mat_const;
	private String crt_vl_mcc_mkt_direto;	
	private String crt_vl_mcc_moveis_deco;	
	private String crt_vl_mcc_outros;	
	private String crt_vl_mcc_pag_conta;
	private String crt_vl_mcc_post_gas;	
	private String crt_vl_mcc_restaur;	
	private String crt_vl_mcc_servico;	
	private String crt_vl_mcc_supermerc;	
	private String crt_vl_mcc_varejo;	
	private String crt_vl_mcc_vestuario;
	
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getNr_pess() {
		return nr_pess;
	}
	public void setNr_pess(String nr_pess) {
		this.nr_pess = nr_pess;
	}
	public String getAno_mes() {
		return ano_mes;
	}
	public void setAno_mes(String ano_mes) {
		this.ano_mes = ano_mes;
	}
	public String getTempo_cc() {
		return tempo_cc;
	}
	public void setTempo_cc(String tempo_cc) {
		this.tempo_cc = tempo_cc;
	}
	public String getSegmento() {
		return segmento;
	}
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	public String getDs_timps_com() {
		return ds_timps_com;
	}
	public void setDs_timps_com(String ds_timps_com) {
		this.ds_timps_com = ds_timps_com;
	}
	public String getQt_idad() {
		return qt_idad;
	}
	public void setQt_idad(String qt_idad) {
		this.qt_idad = qt_idad;
	}
	public String getCd_sexo() {
		return cd_sexo;
	}
	public void setCd_sexo(String cd_sexo) {
		this.cd_sexo = cd_sexo;
	}
	public String getCd_esta_civi() {
		return cd_esta_civi;
	}
	public void setCd_esta_civi(String cd_esta_civi) {
		this.cd_esta_civi = cd_esta_civi;
	}
	public String getQt_depe() {
		return qt_depe;
	}
	public void setQt_depe(String qt_depe) {
		this.qt_depe = qt_depe;
	}
	public String getCd_esco() {
		return cd_esco;
	}
	public void setCd_esco(String cd_esco) {
		this.cd_esco = cd_esco;
	}
	public String getCd_grau_seve() {
		return cd_grau_seve;
	}
	public void setCd_grau_seve(String cd_grau_seve) {
		this.cd_grau_seve = cd_grau_seve;
	}
	public String getCd_esco_cojg() {
		return cd_esco_cojg;
	}
	public void setCd_esco_cojg(String cd_esco_cojg) {
		this.cd_esco_cojg = cd_esco_cojg;
	}
	public String getRenda_final() {
		return renda_final;
	}
	public void setRenda_final(String renda_final) {
		this.renda_final = renda_final;
	}
	public String getDeb_total_cc() {
		return deb_total_cc;
	}
	public void setDeb_total_cc(String deb_total_cc) {
		this.deb_total_cc = deb_total_cc;
	}
	public String getCr_total_cc() {
		return cr_total_cc;
	}
	public void setCr_total_cc(String cr_total_cc) {
		this.cr_total_cc = cr_total_cc;
	}
	public String getQtde_cc() {
		return qtde_cc;
	}
	public void setQtde_cc(String qtde_cc) {
		this.qtde_cc = qtde_cc;
	}
	public String getVl_sald_disp_totl() {
		return vl_sald_disp_totl;
	}
	public void setVl_sald_disp_totl(String vl_sald_disp_totl) {
		this.vl_sald_disp_totl = vl_sald_disp_totl;
	}
	public String getVl_cntr_csg() {
		return vl_cntr_csg;
	}
	public void setVl_cntr_csg(String vl_cntr_csg) {
		this.vl_cntr_csg = vl_cntr_csg;
	}
	public String getVl_sld_dev_csg() {
		return vl_sld_dev_csg;
	}
	public void setVl_sld_dev_csg(String vl_sld_dev_csg) {
		this.vl_sld_dev_csg = vl_sld_dev_csg;
	}
	public String getVl_sld_invest() {
		return vl_sld_invest;
	}
	public void setVl_sld_invest(String vl_sld_invest) {
		this.vl_sld_invest = vl_sld_invest;
	}
	public String getCrt_qtd_crt_base() {
		return crt_qtd_crt_base;
	}
	public void setCrt_qtd_crt_base(String crt_qtd_crt_base) {
		this.crt_qtd_crt_base = crt_qtd_crt_base;
	}
	public String getCrt_vl_limi_cnta() {
		return crt_vl_limi_cnta;
	}
	public void setCrt_vl_limi_cnta(String crt_vl_limi_cnta) {
		this.crt_vl_limi_cnta = crt_vl_limi_cnta;
	}
	public String getCrt_vl_limi_comprom() {
		return crt_vl_limi_comprom;
	}
	public void setCrt_vl_limi_comprom(String crt_vl_limi_comprom) {
		this.crt_vl_limi_comprom = crt_vl_limi_comprom;
	}
	public String getCrt_qtd_mcc_ag_tur() {
		return crt_qtd_mcc_ag_tur;
	}
	public void setCrt_qtd_mcc_ag_tur(String crt_qtd_mcc_ag_tur) {
		this.crt_qtd_mcc_ag_tur = crt_qtd_mcc_ag_tur;
	}
	public String getCrt_qtd_mcc_alug_carr() {
		return crt_qtd_mcc_alug_carr;
	}
	public void setCrt_qtd_mcc_alug_carr(String crt_qtd_mcc_alug_carr) {
		this.crt_qtd_mcc_alug_carr = crt_qtd_mcc_alug_carr;
	}
	public String getCrt_qtd_mcc_art_eletr() {
		return crt_qtd_mcc_art_eletr;
	}
	public void setCrt_qtd_mcc_art_eletr(String crt_qtd_mcc_art_eletr) {
		this.crt_qtd_mcc_art_eletr = crt_qtd_mcc_art_eletr;
	}
	public String getCrt_qtd_mcc_aut_pcas() {
		return crt_qtd_mcc_aut_pcas;
	}
	public void setCrt_qtd_mcc_aut_pcas(String crt_qtd_mcc_aut_pcas) {
		this.crt_qtd_mcc_aut_pcas = crt_qtd_mcc_aut_pcas;
	}
	public String getCrt_qtd_mcc_cia_aerea() {
		return crt_qtd_mcc_cia_aerea;
	}
	public void setCrt_qtd_mcc_cia_aerea(String crt_qtd_mcc_cia_aerea) {
		this.crt_qtd_mcc_cia_aerea = crt_qtd_mcc_cia_aerea;
	}
	public String getCrt_qtd_mcc_farmacia() {
		return crt_qtd_mcc_farmacia;
	}
	public void setCrt_qtd_mcc_farmacia(String crt_qtd_mcc_farmacia) {
		this.crt_qtd_mcc_farmacia = crt_qtd_mcc_farmacia;
	}
	public String getCrt_qtd_mcc_hospital() {
		return crt_qtd_mcc_hospital;
	}
	public void setCrt_qtd_mcc_hospital(String crt_qtd_mcc_hospital) {
		this.crt_qtd_mcc_hospital = crt_qtd_mcc_hospital;
	}
	public String getCrt_qtd_mcc_hoteis() {
		return crt_qtd_mcc_hoteis;
	}
	public void setCrt_qtd_mcc_hoteis(String crt_qtd_mcc_hoteis) {
		this.crt_qtd_mcc_hoteis = crt_qtd_mcc_hoteis;
	}
	public String getCrt_qtd_mcc_joalheria() {
		return crt_qtd_mcc_joalheria;
	}
	public void setCrt_qtd_mcc_joalheria(String crt_qtd_mcc_joalheria) {
		this.crt_qtd_mcc_joalheria = crt_qtd_mcc_joalheria;
	}
	public String getCrt_qtd_mcc_loj_depar() {
		return crt_qtd_mcc_loj_depar;
	}
	public void setCrt_qtd_mcc_loj_depar(String crt_qtd_mcc_loj_depar) {
		this.crt_qtd_mcc_loj_depar = crt_qtd_mcc_loj_depar;
	}
	public String getCrt_qtd_mcc_mat_const() {
		return crt_qtd_mcc_mat_const;
	}
	public void setCrt_qtd_mcc_mat_const(String crt_qtd_mcc_mat_const) {
		this.crt_qtd_mcc_mat_const = crt_qtd_mcc_mat_const;
	}
	public String getCrt_qtd_mcc_mkt_direto() {
		return crt_qtd_mcc_mkt_direto;
	}
	public void setCrt_qtd_mcc_mkt_direto(String crt_qtd_mcc_mkt_direto) {
		this.crt_qtd_mcc_mkt_direto = crt_qtd_mcc_mkt_direto;
	}
	public String getCrt_qtd_mcc_moveis_deco() {
		return crt_qtd_mcc_moveis_deco;
	}
	public void setCrt_qtd_mcc_moveis_deco(String crt_qtd_mcc_moveis_deco) {
		this.crt_qtd_mcc_moveis_deco = crt_qtd_mcc_moveis_deco;
	}
	public String getCrt_qtd_mcc_outros() {
		return crt_qtd_mcc_outros;
	}
	public void setCrt_qtd_mcc_outros(String crt_qtd_mcc_outros) {
		this.crt_qtd_mcc_outros = crt_qtd_mcc_outros;
	}
	public String getCrt_qtd_mcc_pag_conta() {
		return crt_qtd_mcc_pag_conta;
	}
	public void setCrt_qtd_mcc_pag_conta(String crt_qtd_mcc_pag_conta) {
		this.crt_qtd_mcc_pag_conta = crt_qtd_mcc_pag_conta;
	}
	public String getCrt_qtd_mcc_post_gas() {
		return crt_qtd_mcc_post_gas;
	}
	public void setCrt_qtd_mcc_post_gas(String crt_qtd_mcc_post_gas) {
		this.crt_qtd_mcc_post_gas = crt_qtd_mcc_post_gas;
	}
	public String getCrt_qtd_mcc_restaur() {
		return crt_qtd_mcc_restaur;
	}
	public void setCrt_qtd_mcc_restaur(String crt_qtd_mcc_restaur) {
		this.crt_qtd_mcc_restaur = crt_qtd_mcc_restaur;
	}
	public String getCrt_qtd_mcc_servico() {
		return crt_qtd_mcc_servico;
	}
	public void setCrt_qtd_mcc_servico(String crt_qtd_mcc_servico) {
		this.crt_qtd_mcc_servico = crt_qtd_mcc_servico;
	}
	public String getCrt_qtd_mcc_supermerc() {
		return crt_qtd_mcc_supermerc;
	}
	public void setCrt_qtd_mcc_supermerc(String crt_qtd_mcc_supermerc) {
		this.crt_qtd_mcc_supermerc = crt_qtd_mcc_supermerc;
	}
	public String getCrt_qtd_mcc_varejo() {
		return crt_qtd_mcc_varejo;
	}
	public void setCrt_qtd_mcc_varejo(String crt_qtd_mcc_varejo) {
		this.crt_qtd_mcc_varejo = crt_qtd_mcc_varejo;
	}
	public String getCrt_qtd_mcc_vestuario() {
		return crt_qtd_mcc_vestuario;
	}
	public void setCrt_qtd_mcc_vestuario(String crt_qtd_mcc_vestuario) {
		this.crt_qtd_mcc_vestuario = crt_qtd_mcc_vestuario;
	}
	public String getCrt_vl_compra_exter() {
		return crt_vl_compra_exter;
	}
	public void setCrt_vl_compra_exter(String crt_vl_compra_exter) {
		this.crt_vl_compra_exter = crt_vl_compra_exter;
	}
	public String getCrt_vl_mcc_ag_tur() {
		return crt_vl_mcc_ag_tur;
	}
	public void setCrt_vl_mcc_ag_tur(String crt_vl_mcc_ag_tur) {
		this.crt_vl_mcc_ag_tur = crt_vl_mcc_ag_tur;
	}
	public String getCrt_vl_mcc_alug_carr() {
		return crt_vl_mcc_alug_carr;
	}
	public void setCrt_vl_mcc_alug_carr(String crt_vl_mcc_alug_carr) {
		this.crt_vl_mcc_alug_carr = crt_vl_mcc_alug_carr;
	}
	public String getCrt_vl_mcc_art_eletr() {
		return crt_vl_mcc_art_eletr;
	}
	public void setCrt_vl_mcc_art_eletr(String crt_vl_mcc_art_eletr) {
		this.crt_vl_mcc_art_eletr = crt_vl_mcc_art_eletr;
	}
	public String getCrt_vl_mcc_aut_pcas() {
		return crt_vl_mcc_aut_pcas;
	}
	public void setCrt_vl_mcc_aut_pcas(String crt_vl_mcc_aut_pcas) {
		this.crt_vl_mcc_aut_pcas = crt_vl_mcc_aut_pcas;
	}
	public String getCrt_vl_mcc_cia_aerea() {
		return crt_vl_mcc_cia_aerea;
	}
	public void setCrt_vl_mcc_cia_aerea(String crt_vl_mcc_cia_aerea) {
		this.crt_vl_mcc_cia_aerea = crt_vl_mcc_cia_aerea;
	}
	public String getCrt_vl_mcc_farmacia() {
		return crt_vl_mcc_farmacia;
	}
	public void setCrt_vl_mcc_farmacia(String crt_vl_mcc_farmacia) {
		this.crt_vl_mcc_farmacia = crt_vl_mcc_farmacia;
	}
	public String getCrt_vl_mcc_hospital() {
		return crt_vl_mcc_hospital;
	}
	public void setCrt_vl_mcc_hospital(String crt_vl_mcc_hospital) {
		this.crt_vl_mcc_hospital = crt_vl_mcc_hospital;
	}
	public String getCrt_vl_mcc_hoteis() {
		return crt_vl_mcc_hoteis;
	}
	public void setCrt_vl_mcc_hoteis(String crt_vl_mcc_hoteis) {
		this.crt_vl_mcc_hoteis = crt_vl_mcc_hoteis;
	}
	public String getCrt_vl_mcc_joalheria() {
		return crt_vl_mcc_joalheria;
	}
	public void setCrt_vl_mcc_joalheria(String crt_vl_mcc_joalheria) {
		this.crt_vl_mcc_joalheria = crt_vl_mcc_joalheria;
	}
	public String getCrt_vl_mcc_loj_depar() {
		return crt_vl_mcc_loj_depar;
	}
	public void setCrt_vl_mcc_loj_depar(String crt_vl_mcc_loj_depar) {
		this.crt_vl_mcc_loj_depar = crt_vl_mcc_loj_depar;
	}
	public String getCrt_vl_mcc_mat_const() {
		return crt_vl_mcc_mat_const;
	}
	public void setCrt_vl_mcc_mat_const(String crt_vl_mcc_mat_const) {
		this.crt_vl_mcc_mat_const = crt_vl_mcc_mat_const;
	}
	public String getCrt_vl_mcc_mkt_direto() {
		return crt_vl_mcc_mkt_direto;
	}
	public void setCrt_vl_mcc_mkt_direto(String crt_vl_mcc_mkt_direto) {
		this.crt_vl_mcc_mkt_direto = crt_vl_mcc_mkt_direto;
	}
	public String getCrt_vl_mcc_moveis_deco() {
		return crt_vl_mcc_moveis_deco;
	}
	public void setCrt_vl_mcc_moveis_deco(String crt_vl_mcc_moveis_deco) {
		this.crt_vl_mcc_moveis_deco = crt_vl_mcc_moveis_deco;
	}
	public String getCrt_vl_mcc_outros() {
		return crt_vl_mcc_outros;
	}
	public void setCrt_vl_mcc_outros(String crt_vl_mcc_outros) {
		this.crt_vl_mcc_outros = crt_vl_mcc_outros;
	}
	public String getCrt_vl_mcc_pag_conta() {
		return crt_vl_mcc_pag_conta;
	}
	public void setCrt_vl_mcc_pag_conta(String crt_vl_mcc_pag_conta) {
		this.crt_vl_mcc_pag_conta = crt_vl_mcc_pag_conta;
	}
	public String getCrt_vl_mcc_post_gas() {
		return crt_vl_mcc_post_gas;
	}
	public void setCrt_vl_mcc_post_gas(String crt_vl_mcc_post_gas) {
		this.crt_vl_mcc_post_gas = crt_vl_mcc_post_gas;
	}
	public String getCrt_vl_mcc_restaur() {
		return crt_vl_mcc_restaur;
	}
	public void setCrt_vl_mcc_restaur(String crt_vl_mcc_restaur) {
		this.crt_vl_mcc_restaur = crt_vl_mcc_restaur;
	}
	public String getCrt_vl_mcc_servico() {
		return crt_vl_mcc_servico;
	}
	public void setCrt_vl_mcc_servico(String crt_vl_mcc_servico) {
		this.crt_vl_mcc_servico = crt_vl_mcc_servico;
	}
	public String getCrt_vl_mcc_supermerc() {
		return crt_vl_mcc_supermerc;
	}
	public void setCrt_vl_mcc_supermerc(String crt_vl_mcc_supermerc) {
		this.crt_vl_mcc_supermerc = crt_vl_mcc_supermerc;
	}
	public String getCrt_vl_mcc_varejo() {
		return crt_vl_mcc_varejo;
	}
	public void setCrt_vl_mcc_varejo(String crt_vl_mcc_varejo) {
		this.crt_vl_mcc_varejo = crt_vl_mcc_varejo;
	}
	public String getCrt_vl_mcc_vestuario() {
		return crt_vl_mcc_vestuario;
	}
	public void setCrt_vl_mcc_vestuario(String crt_vl_mcc_vestuario) {
		this.crt_vl_mcc_vestuario = crt_vl_mcc_vestuario;
	}
	
	public DataSet() {
		super();
	}
		
	public DataSet(ObjectId _id, String nr_pess, String ano_mes, String tempo_cc, String segmento, String ds_timps_com,
			String qt_idad, String cd_sexo, String cd_esta_civi, String qt_depe, String cd_esco, String cd_grau_seve,
			String cd_esco_cojg, String renda_final, String deb_total_cc, String cr_total_cc, String qtde_cc,
			String vl_sald_disp_totl, String vl_cntr_csg, String vl_sld_dev_csg, String vl_sld_invest,
			String crt_qtd_crt_base, String crt_vl_limi_cnta, String crt_vl_limi_comprom, String crt_qtd_mcc_ag_tur,
			String crt_qtd_mcc_alug_carr, String crt_qtd_mcc_art_eletr, String crt_qtd_mcc_aut_pcas,
			String crt_qtd_mcc_cia_aerea, String crt_qtd_mcc_farmacia, String crt_qtd_mcc_hospital,
			String crt_qtd_mcc_hoteis, String crt_qtd_mcc_joalheria, String crt_qtd_mcc_loj_depar,
			String crt_qtd_mcc_mat_const, String crt_qtd_mcc_mkt_direto, String crt_qtd_mcc_moveis_deco,
			String crt_qtd_mcc_outros, String crt_qtd_mcc_pag_conta, String crt_qtd_mcc_post_gas,
			String crt_qtd_mcc_restaur, String crt_qtd_mcc_servico, String crt_qtd_mcc_supermerc,
			String crt_qtd_mcc_varejo, String crt_qtd_mcc_vestuario, String crt_vl_compra_exter,
			String crt_vl_mcc_ag_tur, String crt_vl_mcc_alug_carr, String crt_vl_mcc_art_eletr,
			String crt_vl_mcc_aut_pcas, String crt_vl_mcc_cia_aerea, String crt_vl_mcc_farmacia,
			String crt_vl_mcc_hospital, String crt_vl_mcc_hoteis, String crt_vl_mcc_joalheria,
			String crt_vl_mcc_loj_depar, String crt_vl_mcc_mat_const, String crt_vl_mcc_mkt_direto,
			String crt_vl_mcc_moveis_deco, String crt_vl_mcc_outros, String crt_vl_mcc_pag_conta,
			String crt_vl_mcc_post_gas, String crt_vl_mcc_restaur, String crt_vl_mcc_servico,
			String crt_vl_mcc_supermerc, String crt_vl_mcc_varejo, String crt_vl_mcc_vestuario) {
		super();
		this._id = _id;
		this.nr_pess = nr_pess;
		this.ano_mes = ano_mes;
		this.tempo_cc = tempo_cc;
		this.segmento = segmento;
		this.ds_timps_com = ds_timps_com;
		this.qt_idad = qt_idad;
		this.cd_sexo = cd_sexo;
		this.cd_esta_civi = cd_esta_civi;
		this.qt_depe = qt_depe;
		this.cd_esco = cd_esco;
		this.cd_grau_seve = cd_grau_seve;
		this.cd_esco_cojg = cd_esco_cojg;
		this.renda_final = renda_final;
		this.deb_total_cc = deb_total_cc;
		this.cr_total_cc = cr_total_cc;
		this.qtde_cc = qtde_cc;
		this.vl_sald_disp_totl = vl_sald_disp_totl;
		this.vl_cntr_csg = vl_cntr_csg;
		this.vl_sld_dev_csg = vl_sld_dev_csg;
		this.vl_sld_invest = vl_sld_invest;
		this.crt_qtd_crt_base = crt_qtd_crt_base;
		this.crt_vl_limi_cnta = crt_vl_limi_cnta;
		this.crt_vl_limi_comprom = crt_vl_limi_comprom;
		this.crt_qtd_mcc_ag_tur = crt_qtd_mcc_ag_tur;
		this.crt_qtd_mcc_alug_carr = crt_qtd_mcc_alug_carr;
		this.crt_qtd_mcc_art_eletr = crt_qtd_mcc_art_eletr;
		this.crt_qtd_mcc_aut_pcas = crt_qtd_mcc_aut_pcas;
		this.crt_qtd_mcc_cia_aerea = crt_qtd_mcc_cia_aerea;
		this.crt_qtd_mcc_farmacia = crt_qtd_mcc_farmacia;
		this.crt_qtd_mcc_hospital = crt_qtd_mcc_hospital;
		this.crt_qtd_mcc_hoteis = crt_qtd_mcc_hoteis;
		this.crt_qtd_mcc_joalheria = crt_qtd_mcc_joalheria;
		this.crt_qtd_mcc_loj_depar = crt_qtd_mcc_loj_depar;
		this.crt_qtd_mcc_mat_const = crt_qtd_mcc_mat_const;
		this.crt_qtd_mcc_mkt_direto = crt_qtd_mcc_mkt_direto;
		this.crt_qtd_mcc_moveis_deco = crt_qtd_mcc_moveis_deco;
		this.crt_qtd_mcc_outros = crt_qtd_mcc_outros;
		this.crt_qtd_mcc_pag_conta = crt_qtd_mcc_pag_conta;
		this.crt_qtd_mcc_post_gas = crt_qtd_mcc_post_gas;
		this.crt_qtd_mcc_restaur = crt_qtd_mcc_restaur;
		this.crt_qtd_mcc_servico = crt_qtd_mcc_servico;
		this.crt_qtd_mcc_supermerc = crt_qtd_mcc_supermerc;
		this.crt_qtd_mcc_varejo = crt_qtd_mcc_varejo;
		this.crt_qtd_mcc_vestuario = crt_qtd_mcc_vestuario;
		this.crt_vl_compra_exter = crt_vl_compra_exter;
		this.crt_vl_mcc_ag_tur = crt_vl_mcc_ag_tur;
		this.crt_vl_mcc_alug_carr = crt_vl_mcc_alug_carr;
		this.crt_vl_mcc_art_eletr = crt_vl_mcc_art_eletr;
		this.crt_vl_mcc_aut_pcas = crt_vl_mcc_aut_pcas;
		this.crt_vl_mcc_cia_aerea = crt_vl_mcc_cia_aerea;
		this.crt_vl_mcc_farmacia = crt_vl_mcc_farmacia;
		this.crt_vl_mcc_hospital = crt_vl_mcc_hospital;
		this.crt_vl_mcc_hoteis = crt_vl_mcc_hoteis;
		this.crt_vl_mcc_joalheria = crt_vl_mcc_joalheria;
		this.crt_vl_mcc_loj_depar = crt_vl_mcc_loj_depar;
		this.crt_vl_mcc_mat_const = crt_vl_mcc_mat_const;
		this.crt_vl_mcc_mkt_direto = crt_vl_mcc_mkt_direto;
		this.crt_vl_mcc_moveis_deco = crt_vl_mcc_moveis_deco;
		this.crt_vl_mcc_outros = crt_vl_mcc_outros;
		this.crt_vl_mcc_pag_conta = crt_vl_mcc_pag_conta;
		this.crt_vl_mcc_post_gas = crt_vl_mcc_post_gas;
		this.crt_vl_mcc_restaur = crt_vl_mcc_restaur;
		this.crt_vl_mcc_servico = crt_vl_mcc_servico;
		this.crt_vl_mcc_supermerc = crt_vl_mcc_supermerc;
		this.crt_vl_mcc_varejo = crt_vl_mcc_varejo;
		this.crt_vl_mcc_vestuario = crt_vl_mcc_vestuario;
	}
	public String toJSON() {
		return new Gson().toJson(this);
	}
	
	public DataSet criaId() {
		  set_id(new ObjectId());
		  return this;
		}
}
