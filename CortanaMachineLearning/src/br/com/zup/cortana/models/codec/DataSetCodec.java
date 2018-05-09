package br.com.zup.cortana.models.codec;

import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

import br.com.zup.cortana.models.DataSet;

public class DataSetCodec implements CollectibleCodec<DataSet> {

	private Codec<Document> codec;

	public DataSetCodec(Codec<Document> codec) {
		this.codec = codec;
	}
	@Override
	public void encode(BsonWriter writer, DataSet data, EncoderContext encoder) {

		ObjectId id = data.get_id();
		String nr_pess = data.getNr_pess();
		String ano_mes = data.getAno_mes();
		String tempo_cc	 = data.getTempo_cc();
		String segmento	 = data.getSegmento();
		String ds_timps_com	 = data.getDs_timps_com();
		String qt_idad = data.getQt_idad();
		String cd_sexo = data.getCd_sexo();
		String cd_esta_civi	= data.getCd_esta_civi();
		String qt_depe = data.getQt_depe();
		String cd_esco = data.getCd_esco();
		String cd_grau_seve	= data.getCd_grau_seve();
		String cd_esco_cojg	= data.getCd_esco_cojg();
		String renda_final = data.getRenda_final();
		String deb_total_cc = data.getDeb_total_cc();
		String cr_total_cc = data.getCr_total_cc();
		String qtde_cc = data.getQtde_cc();
		String vl_sald_disp_totl = data.getVl_sald_disp_totl();
		String vl_cntr_csg = data.getVl_cntr_csg();
		String vl_sld_dev_csg = data.getVl_cntr_csg();
		String vl_sld_invest = data.getVl_sld_invest();
		String crt_qtd_crt_base	= data.getCrt_qtd_crt_base();
		String crt_vl_limi_cnta	= data.getCrt_vl_limi_cnta();
		String crt_vl_limi_comprom = data.getCrt_vl_limi_comprom();
		String crt_qtd_mcc_ag_tur = data.getCrt_qtd_mcc_ag_tur();
		String crt_qtd_mcc_alug_carr = data.getCrt_qtd_mcc_alug_carr();
		String crt_qtd_mcc_art_eletr = data.getCrt_qtd_mcc_art_eletr();	
		String crt_qtd_mcc_aut_pcas = data.getCrt_qtd_mcc_aut_pcas();
		String crt_qtd_mcc_cia_aerea = data.getCrt_qtd_mcc_cia_aerea();
		String crt_qtd_mcc_farmacia	= data.getCrt_qtd_mcc_farmacia();
		String crt_qtd_mcc_hospital = data.getCrt_qtd_mcc_hospital();
		String crt_qtd_mcc_hoteis = data.getCrt_qtd_mcc_hoteis();
		String crt_qtd_mcc_joalheria = data.getCrt_qtd_mcc_joalheria();
		String crt_qtd_mcc_loj_depar = data.getCrt_qtd_mcc_loj_depar();
		String crt_qtd_mcc_mat_const = data.getCrt_qtd_mcc_mat_const();
		String crt_qtd_mcc_mkt_direto = data.getCrt_qtd_mcc_mkt_direto();
		String crt_qtd_mcc_moveis_deco = data.getCrt_qtd_mcc_moveis_deco();
		String crt_qtd_mcc_outros = data.getCrt_qtd_mcc_outros();
		String crt_qtd_mcc_pag_conta = data.getCrt_qtd_mcc_pag_conta();
		String crt_qtd_mcc_post_gas = data.getCrt_qtd_mcc_post_gas();
		String crt_qtd_mcc_restaur = data.getCrt_qtd_mcc_restaur();
		String crt_qtd_mcc_servico = data.getCrt_qtd_mcc_servico();
		String crt_qtd_mcc_supermerc = data.getCrt_qtd_mcc_supermerc();
		String crt_qtd_mcc_varejo = data.getCrt_qtd_mcc_varejo();
		String crt_qtd_mcc_vestuario = data.getCrt_qtd_mcc_vestuario();

		String crt_vl_compra_exter = data.getCrt_vl_compra_exter();
		String crt_vl_mcc_ag_tur = data.getCrt_vl_mcc_ag_tur();
		String crt_vl_mcc_alug_carr = data.getCrt_vl_mcc_alug_carr();
		String crt_vl_mcc_art_eletr = data.getCrt_vl_mcc_art_eletr();
		String crt_vl_mcc_aut_pcas = data.getCrt_vl_mcc_aut_pcas();
		String crt_vl_mcc_cia_aerea = data.getCrt_vl_mcc_cia_aerea();
		String crt_vl_mcc_farmacia = data.getCrt_vl_mcc_farmacia();
		String crt_vl_mcc_hospital = data.getCrt_vl_mcc_hospital();
		String crt_vl_mcc_hoteis = data.getCrt_vl_mcc_hoteis();
		String crt_vl_mcc_joalheria = data.getCrt_vl_mcc_joalheria();
		String crt_vl_mcc_loj_depar = data.getCrt_vl_mcc_loj_depar();
		String crt_vl_mcc_mat_const = data.getCrt_vl_mcc_mat_const();
		String crt_vl_mcc_mkt_direto = data.getCrt_vl_mcc_mkt_direto();
		String crt_vl_mcc_moveis_deco = data.getCrt_vl_mcc_moveis_deco();
		String crt_vl_mcc_outros = data.getCrt_vl_mcc_outros();
		String crt_vl_mcc_pag_conta = data.getCrt_vl_mcc_pag_conta();
		String crt_vl_mcc_post_gas = data.getCrt_vl_mcc_post_gas();
		String crt_vl_mcc_restaur = data.getCrt_vl_mcc_restaur();
		String crt_vl_mcc_servico = data.getCrt_vl_mcc_servico();
		String crt_vl_mcc_supermerc = data.getCrt_vl_mcc_supermerc();
		String crt_vl_mcc_varejo = data.getCrt_vl_mcc_varejo();
		String crt_vl_mcc_vestuario = data.getCrt_vl_mcc_vestuario();

		Document documento = new Document();
		documento.put("_id", id);
		documento.put("nr_pess", nr_pess);
		documento.put("ano_mes", ano_mes);
		documento.put("tempo_cc", tempo_cc);
		documento.put("segmento", segmento);
		documento.put("ds_timps_com", ds_timps_com);
		documento.put("qt_idad", qt_idad);
		documento.put("cd_sexo", cd_sexo);
		documento.put("cd_esta_civi", cd_esta_civi);
		documento.put("qt_depe", qt_depe);
		documento.put("cd_esco", cd_esco);
		documento.put("cd_grau_seve", cd_grau_seve);
		documento.put("cd_esco_cojg", cd_esco_cojg);
		documento.put("renda_final", renda_final);
		documento.put("deb_total_cc", deb_total_cc);
		documento.put("cr_total_cc", cr_total_cc);
		documento.put("qtde_cc", qtde_cc);
		documento.put("vl_sald_disp_totl", vl_sald_disp_totl);
		documento.put("vl_cntr_csg", vl_cntr_csg);
		documento.put("vl_sld_dev_csg", vl_sld_dev_csg);
		documento.put("vl_sld_invest", vl_sld_invest);
		documento.put("crt_qtd_crt_base", crt_qtd_crt_base);
		documento.put("crt_vl_limi_cnta", crt_vl_limi_cnta);
		documento.put("crt_vl_limi_comprom", crt_vl_limi_comprom);
		documento.put("crt_qtd_mcc_ag_tur", crt_qtd_mcc_ag_tur);
		documento.put("crt_qtd_mcc_alug_carr", crt_qtd_mcc_alug_carr);
		documento.put("crt_qtd_mcc_art_eletr", crt_qtd_mcc_art_eletr);
		documento.put("crt_qtd_mcc_aut_pcas", crt_qtd_mcc_aut_pcas);
		documento.put("crt_qtd_mcc_cia_aerea", crt_qtd_mcc_cia_aerea);
		documento.put("crt_qtd_mcc_farmacia", crt_qtd_mcc_farmacia);
		documento.put("crt_qtd_mcc_hospital", crt_qtd_mcc_hospital);
		documento.put("crt_qtd_mcc_hoteis", crt_qtd_mcc_hoteis);
		documento.put("crt_qtd_mcc_joalheria", crt_qtd_mcc_joalheria);
		documento.put("crt_qtd_mcc_loj_depar", crt_qtd_mcc_loj_depar);
		documento.put("crt_qtd_mcc_mat_const", crt_qtd_mcc_mat_const);
		documento.put("crt_qtd_mcc_mkt_direto", crt_qtd_mcc_mkt_direto);
		documento.put("crt_qtd_mcc_moveis_deco", crt_qtd_mcc_moveis_deco);
		documento.put("crt_qtd_mcc_outros", crt_qtd_mcc_outros);
		documento.put("crt_qtd_mcc_pag_conta", crt_qtd_mcc_pag_conta);
		documento.put("crt_qtd_mcc_post_gas", crt_qtd_mcc_post_gas);
		documento.put("crt_qtd_mcc_restaur", crt_qtd_mcc_restaur);
		documento.put("crt_qtd_mcc_servico", crt_qtd_mcc_servico);
		documento.put("crt_qtd_mcc_supermerc", crt_qtd_mcc_supermerc);
		documento.put("crt_qtd_mcc_varejo", crt_qtd_mcc_varejo);
		documento.put("crt_qtd_mcc_vestuario", crt_qtd_mcc_vestuario);
		documento.put("crt_vl_compra_exter", crt_vl_compra_exter);
		documento.put("crt_vl_mcc_ag_tur", crt_vl_mcc_ag_tur);
		documento.put("crt_vl_mcc_alug_carr", crt_vl_mcc_alug_carr);
		documento.put("crt_vl_mcc_art_eletr", crt_vl_mcc_art_eletr);
		documento.put("crt_vl_mcc_aut_pcas", crt_vl_mcc_aut_pcas);
		documento.put("crt_vl_mcc_cia_aerea", crt_vl_mcc_cia_aerea);
		documento.put("crt_vl_mcc_farmacia", crt_vl_mcc_farmacia);
		documento.put("crt_vl_mcc_hospital", crt_vl_mcc_hospital);
		documento.put("crt_vl_mcc_hoteis", crt_vl_mcc_hoteis);
		documento.put("crt_vl_mcc_joalheria", crt_vl_mcc_joalheria);
		documento.put("crt_vl_mcc_loj_depar", crt_vl_mcc_loj_depar);
		documento.put("crt_vl_mcc_mat_const", crt_vl_mcc_mat_const);
		documento.put("crt_vl_mcc_mkt_direto", crt_vl_mcc_mkt_direto);
		documento.put("crt_vl_mcc_moveis_deco", crt_vl_mcc_moveis_deco);
		documento.put("crt_vl_mcc_outros", crt_vl_mcc_outros);
		documento.put("crt_vl_mcc_pag_conta", crt_vl_mcc_pag_conta);
		documento.put("crt_vl_mcc_post_gas", crt_vl_mcc_post_gas);
		documento.put("crt_vl_mcc_restaur", crt_vl_mcc_restaur);
		documento.put("crt_vl_mcc_servico", crt_vl_mcc_servico);
		documento.put("crt_vl_mcc_supermerc", crt_vl_mcc_supermerc);
		documento.put("crt_vl_mcc_varejo", crt_vl_mcc_varejo);
		documento.put("crt_vl_mcc_vestuario", crt_vl_mcc_vestuario);

		codec.encode(writer, documento, encoder);
	}

	@Override
	public Class<DataSet> getEncoderClass() {
		return DataSet.class;
	}

	@Override
	public DataSet decode(BsonReader arg0, DecoderContext arg1) {
		return null;
	}

	@Override
	public boolean documentHasId(DataSet dataset) {
		return dataset.get_id() == null;
	}

	@Override
	public DataSet generateIdIfAbsentFromDocument(DataSet dataset) {
		return documentHasId(dataset) ? dataset.criaId() : dataset;
	}

	@Override
	public BsonValue getDocumentId(DataSet dataset) {
		if(!documentHasId(dataset)) {
			throw new IllegalStateException("Esse Document não tem id");
		}
		return new BsonString(dataset.get_id().toHexString());
	}



}
