package br.com.zup.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.util.JSON;

import br.com.zup.cortana.models.DataSet;

/**
 * 
 * @author joaopaulo tieles
 *
 */
public class ReaderCSV {

	static MongoDBCortana cortanaDB = new MongoDBCortana();

	
	/**
	 * 
	 * @param args
	 * Teste para ver se foi inserido os dados do CSV.
	 */
	public static void main(String[] args) {

		MongoCollection<Document> perfis = cortanaDB.getConnectionCortana("perfis");
		Document perfil = perfis.find(Filters.eq("nr_pess", "95")).first();
		System.out.println(perfil);

	}

	
	/**
	 * @return Banco local Criado
	 */
	public void createMongoDB() {

		ReaderCSV csv = new ReaderCSV();
		List<String> dataset = csv.reader_csv_saving();

		MongoCollection<Document> perfis = cortanaDB.getConnectionCortana("perfis");

		for(String set : dataset) {
			Document data = (Document) JSON.parse(set);
			perfis.insertOne(data);
		}
		System.out.println("Done");

		/*  //Obsoleto
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("cortana");
		DBCollection perfis = db.getCollection("perfis");
		 */
	}

	// nr_pess;ano_mes;tempo_cc;segmento;ds_timps_com;qt_idad;cd_sexo;cd_esta_civi;qt_depe;cd_esco;cd_grau_seve;cd_esco_cojg;renda_final;deb_total_cc;cr_total_cc;qtde_cc;vl_sald_disp_totl;vl_cntr_csg;vl_sld_dev_csg;vl_sld_invest;crt_qtd_crt_base;crt_vl_limi_cnta;crt_vl_limi_comprom;crt_qtd_mcc_ag_tur;crt_qtd_mcc_alug_carr;crt_qtd_mcc_art_eletr;crt_qtd_mcc_aut_pcas;crt_qtd_mcc_cia_aerea;crt_qtd_mcc_farmacia;crt_qtd_mcc_hospital;crt_qtd_mcc_hoteis;crt_qtd_mcc_joalheria;crt_qtd_mcc_loj_depar;crt_qtd_mcc_mat_const;crt_qtd_mcc_mkt_direto;crt_qtd_mcc_moveis_deco;crt_qtd_mcc_outros;crt_qtd_mcc_pag_conta;crt_qtd_mcc_post_gas;crt_qtd_mcc_restaur;crt_qtd_mcc_servico;crt_qtd_mcc_supermerc;crt_qtd_mcc_varejo;crt_qtd_mcc_vestuario;crt_vl_compra_exter;crt_vl_mcc_ag_tur;crt_vl_mcc_alug_carr;crt_vl_mcc_art_eletr;crt_vl_mcc_aut_pcas;crt_vl_mcc_cia_aerea;crt_vl_mcc_farmacia;crt_vl_mcc_hospital;crt_vl_mcc_hoteis;crt_vl_mcc_joalheria;crt_vl_mcc_loj_depar;crt_vl_mcc_mat_const;crt_vl_mcc_mkt_direto;crt_vl_mcc_moveis_deco;crt_vl_mcc_outros;crt_vl_mcc_pag_conta;crt_vl_mcc_post_gas;crt_vl_mcc_restaur;crt_vl_mcc_servico;crt_vl_mcc_supermerc;crt_vl_mcc_varejo;crt_vl_mcc_vestuario

	/**
	 * @return List<String>
	 * Leitor do arquivo CVS local
	 */
	public List<String> reader_csv_saving() {
		String arquivoCSV = "saving_2.csv";
		BufferedReader br = null;
		String linha = "";
		String cvsSplitBy = ";";
		List<String> dataSet = new ArrayList<String>();

		int i = 0 ;
		System.out.println("Rodando leitor...");

		try {

			br = new BufferedReader(new FileReader(arquivoCSV));

			while ((linha = br.readLine()) != null) {
				String[] data = linha.split(cvsSplitBy);

				DataSet set = new DataSet();
				//System.out.println(linha);
				i++; 
				set.setNr_pess(data[0] != null ? data[0] : "");
				set.setAno_mes(data[1] != null ? data[1] : "");
				set.setTempo_cc(data[2] != null ? data[2] : "");
				set.setSegmento(data[3] != null ? data[3] : "");
				set.setDs_timps_com(data[4] != null ? data[4] : "");
				set.setQt_idad(data[5] != null ? data[5] : "");
				set.setCd_sexo(data[6] != null ? data[6] : "");
				set.setCd_esta_civi(data[7] != null ? data[7] : "");
				set.setQt_depe(data[8] != null ? data[8] : "");
				set.setCd_esco(data[9] != null ? data[9] : "");
				set.setCd_grau_seve(data[10] != null ? data[10] : "");
				set.setCd_esco_cojg(data[11] != null ? data[11] : "");
				set.setRenda_final(data[12] != null ? data[12] : "");
				set.setDeb_total_cc(data[13] != null ? data[13] : "");
				set.setCr_total_cc(data[14] != null ? data[14] : "");
				set.setQtde_cc(data[15] != null ? data[15] : "");
				set.setVl_sald_disp_totl(data[16] != null ? data[16] : "");
				set.setVl_cntr_csg(data[17] != null ? data[17] : "");
				set.setVl_sld_dev_csg(data[18] != null ? data[18] : "");
				set.setVl_sld_invest(data[19] != null ? data[19] : "");
				set.setCrt_qtd_crt_base(data[20] != null ? data[20] : "");
				set.setCrt_vl_limi_cnta(data[21] != null ? data[21] : "");
				set.setCrt_vl_limi_comprom(data[22] != null ? data[22] : "");
				set.setCrt_qtd_mcc_ag_tur(data[23] != null ? data[23] : "");
				set.setCrt_qtd_mcc_alug_carr(data[24] != null ? data[24] : "");
				set.setCrt_qtd_mcc_art_eletr(data[25] != null ? data[25] : "");
				set.setCrt_qtd_mcc_aut_pcas(data[26] != null ? data[26] : "");
				set.setCrt_qtd_mcc_cia_aerea(data[27] != null ? data[27] : "");
				set.setCrt_qtd_mcc_farmacia(data[28] != null ? data[28] : "");
				set.setCrt_qtd_mcc_hospital(data[29] != null ? data[29] : "");
				set.setCrt_qtd_mcc_hoteis(data[30] != null ? data[30] : "");
				set.setCrt_qtd_mcc_joalheria(data[31] != null ? data[31] : "");
				set.setCrt_qtd_mcc_mat_const(data[32] != null ? data[32] : "");
				set.setCrt_qtd_mcc_mkt_direto(data[33] != null ? data[33] : "");
				set.setCrt_qtd_mcc_moveis_deco(data[34] != null ? data[34] : "");
				set.setCrt_qtd_mcc_outros(data[35] != null ? data[35] : "");
				set.setCrt_qtd_mcc_pag_conta(data[36] != null ? data[36] : "");
				set.setCrt_qtd_mcc_post_gas(data[37] != null ? data[37] : "");
				set.setCrt_qtd_mcc_restaur(data[38] != null ? data[38] : "");
				set.setCrt_qtd_mcc_servico(data[39] != null ? data[39] : "");
				set.setCrt_qtd_mcc_supermerc(data[40] != null ? data[40] : "");
				set.setCrt_qtd_mcc_varejo(data[41] != null ? data[41] : "");
				set.setCrt_qtd_mcc_vestuario(data[42] != null ? data[42] : "");
				set.setCrt_vl_compra_exter(data[43] != null ? data[43] : "");
				set.setCrt_vl_mcc_ag_tur(data[44] != null ? data[44] : "");
				set.setCrt_vl_mcc_alug_carr(data[45] != null ? data[45] : "");
				set.setCrt_vl_mcc_art_eletr(data[46] != null ? data[46] : "");
				set.setCrt_vl_mcc_aut_pcas(data[47] != null ? data[47] : "");
				set.setCrt_vl_mcc_cia_aerea(data[48] != null ? data[48] : "");
				set.setCrt_vl_mcc_farmacia(data[49] != null ? data[49] : "");
				set.setCrt_vl_mcc_hospital(data[50] != null ? data[50] : "");
				set.setCrt_vl_mcc_hoteis(data[51] != null ? data[51] : "");
				set.setCrt_vl_mcc_joalheria(data[52] != null ? data[52] : "");
				set.setCrt_vl_mcc_loj_depar(data[53] != null ? data[53] : "");
				set.setCrt_vl_mcc_mat_const(data[54] != null ? data[54] : "");
				set.setCrt_vl_mcc_mkt_direto(data[55] != null ? data[55] : "");
				set.setCrt_vl_mcc_moveis_deco(data[56] != null ? data[56] : "");
				set.setCrt_vl_mcc_outros(data[57] != null ? data[57] : "");
				set.setCrt_vl_mcc_pag_conta(data[58] != null ? data[58] : "");
				set.setCrt_vl_mcc_post_gas(data[59] != null ? data[59] : "");
				set.setCrt_vl_mcc_restaur(data[60] != null ? data[60] : "");
				set.setCrt_vl_mcc_servico(data[61] != null ? data[61] : "");
				set.setCrt_vl_mcc_supermerc(data[62] != null ? data[62] : "");
				set.setCrt_vl_mcc_varejo(data[63] != null ? data[63] : "");
				set.setCrt_vl_mcc_vestuario(data[64] != null ? data[64] : "");
				//System.out.println(set.toJSON());

				dataSet.add(set.toJSON());
			}

			return dataSet;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println(i);
			return null;
		}
		finally {
			System.out.println(i);
			if (br != null) {
				try {
					br.close();
					return dataSet;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	/*
	public void reader_nextRecordset() {

		int i = 0; 

		String arquivoCSV = "saving_2.csv";
		List<DataSet> nextRecordSet = new ArrayList<>();

		try (
				Reader reader = Files.newBufferedReader(Paths.get(arquivoCSV));
				CSVReader csvReader = new CSVReader(reader);
				) {
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {

				DataSet set = new DataSet();
				i++; 
				set.setNr_pess(nextRecord[0] != null ? nextRecord[0] : "");
				set.setAno_mes(nextRecord[1] != null ? nextRecord[1] : "");
				set.setTempo_cc(nextRecord[2] != null ? nextRecord[2] : "");
				set.setSegmento(nextRecord[3] != null ? nextRecord[3] : "");
				set.setDs_timps_com(nextRecord[4] != null ? nextRecord[4] : "");
				set.setQt_idad(nextRecord[5] != null ? nextRecord[5] : "");
				set.setCd_sexo(nextRecord[6] != null ? nextRecord[6] : "");
				set.setCd_esta_civi(nextRecord[7] != null ? nextRecord[7] : "");
				set.setQt_depe(nextRecord[8] != null ? nextRecord[8] : "");
				set.setCd_esco(nextRecord[9] != null ? nextRecord[9] : "");
				set.setCd_grau_seve(nextRecord[10] != null ? nextRecord[10] : "");
				//set.setCd_esco_cojg(nextRecord[11] != null ? nextRecord[11] : "");
				//set.setRenda_final(nextRecord[12] != null ? nextRecord[12] : "");
				set.setDeb_total_cc(nextRecord[13] != null ? nextRecord[13] : "");
				set.setCr_total_cc(nextRecord[14] != null ? nextRecord[14] : "");
				set.setQtde_cc(nextRecord[15] != null ? nextRecord[15] : "");
				set.setVl_sald_disp_totl(nextRecord[16] != null ? nextRecord[16] : "");
				set.setVl_cntr_csg(nextRecord[17] != null ? nextRecord[17] : "");
				set.setVl_sld_dev_csg(nextRecord[18] != null ? nextRecord[18] : "");
				set.setVl_sld_invest(nextRecord[19] != null ? nextRecord[19] : "");
				set.setCrt_qtd_crt_base(nextRecord[20] != null ? nextRecord[20] : "");
				set.setCrt_vl_limi_cnta(nextRecord[21] != null ? nextRecord[21] : "");
				set.setCrt_vl_limi_comprom(nextRecord[22] != null ? nextRecord[22] : "");
				set.setCrt_qtd_mcc_ag_tur(nextRecord[23] != null ? nextRecord[23] : "");
				set.setCrt_qtd_mcc_alug_carr(nextRecord[24] != null ? nextRecord[24] : "");
				set.setCrt_qtd_mcc_art_eletr(nextRecord[25] != null ? nextRecord[25] : "");
				set.setCrt_qtd_mcc_aut_pcas(nextRecord[26] != null ? nextRecord[26] : "");
				set.setCrt_qtd_mcc_cia_aerea(nextRecord[27] != null ? nextRecord[27] : "");
				set.setCrt_qtd_mcc_farmacia(nextRecord[28] != null ? nextRecord[28] : "");
				set.setCrt_qtd_mcc_hospital(nextRecord[29] != null ? nextRecord[29] : "");
				set.setCrt_qtd_mcc_hoteis(nextRecord[30] != null ? nextRecord[30] : "");
				set.setCrt_qtd_mcc_joalheria(nextRecord[31] != null ? nextRecord[31] : "");
				set.setCrt_qtd_mcc_mat_const(nextRecord[32] != null ? nextRecord[32] : "");
				set.setCrt_qtd_mcc_mkt_direto(nextRecord[33] != null ? nextRecord[33] : "");
				set.setCrt_qtd_mcc_moveis_deco(nextRecord[34] != null ? nextRecord[34] : "");
				set.setCrt_qtd_mcc_outros(nextRecord[35] != null ? nextRecord[35] : "");
				set.setCrt_qtd_mcc_pag_conta(nextRecord[36] != null ? nextRecord[36] : "");
				set.setCrt_qtd_mcc_post_gas(nextRecord[37] != null ? nextRecord[37] : "");
				set.setCrt_qtd_mcc_restaur(nextRecord[38] != null ? nextRecord[38] : "");
				set.setCrt_qtd_mcc_servico(nextRecord[39] != null ? nextRecord[39] : "");
				set.setCrt_qtd_mcc_supermerc(nextRecord[40] != null ? nextRecord[40] : "");
				set.setCrt_qtd_mcc_varejo(nextRecord[41] != null ? nextRecord[41] : "");
				set.setCrt_qtd_mcc_vestuario(nextRecord[42] != null ? nextRecord[42] : "");
				set.setCrt_vl_compra_exter(nextRecord[43] != null ? nextRecord[43] : "");
				set.setCrt_vl_mcc_ag_tur(nextRecord[44] != null ? nextRecord[44] : "");
				set.setCrt_vl_mcc_alug_carr(nextRecord[45] != null ? nextRecord[45] : "");
				set.setCrt_vl_mcc_art_eletr(nextRecord[46] != null ? nextRecord[46] : "");
				set.setCrt_vl_mcc_aut_pcas(nextRecord[47] != null ? nextRecord[47] : "");
				set.setCrt_vl_mcc_cia_aerea(nextRecord[48] != null ? nextRecord[48] : "");
				set.setCrt_vl_mcc_farmacia(nextRecord[49] != null ? nextRecord[49] : "");
				set.setCrt_vl_mcc_hospital(nextRecord[50] != null ? nextRecord[50] : "");
				set.setCrt_vl_mcc_hoteis(nextRecord[51] != null ? nextRecord[51] : "");
				set.setCrt_vl_mcc_joalheria(nextRecord[52] != null ? nextRecord[52] : "");
				set.setCrt_vl_mcc_loj_depar(nextRecord[53] != null ? nextRecord[53] : "");
				set.setCrt_vl_mcc_mat_const(nextRecord[54] != null ? nextRecord[54] : "");
				set.setCrt_vl_mcc_mkt_direto(nextRecord[55] != null ? nextRecord[55] : "");
				set.setCrt_vl_mcc_moveis_deco(nextRecord[56] != null ? nextRecord[56] : "");
				set.setCrt_vl_mcc_outros(nextRecord[57] != null ? nextRecord[57] : "");
				set.setCrt_vl_mcc_pag_conta(nextRecord[58] != null ? nextRecord[58] : "");
				set.setCrt_vl_mcc_post_gas(nextRecord[59] != null ? nextRecord[59] : "");
				set.setCrt_vl_mcc_restaur(nextRecord[60] != null ? nextRecord[60] : "");
				set.setCrt_vl_mcc_servico(nextRecord[61] != null ? nextRecord[61] : "");
				set.setCrt_vl_mcc_supermerc(nextRecord[62] != null ? nextRecord[62] : "");
				set.setCrt_vl_mcc_varejo(nextRecord[63] != null ? nextRecord[63] : "");
				set.setCrt_vl_mcc_vestuario(nextRecord[64] != null ? nextRecord[64] : "");

				System.out.println(set.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(i);
		}catch(IndexOutOfBoundsException e2) {
			e2.printStackTrace();
			System.out.println(i);
		}
	} */
}




