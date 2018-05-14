package br.com.zup.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.zup.models.HistoricoBancario;

/**
 * 
 * @author joaopaulotieles
 *
 */
@Repository
public class ReaderCSVHistorico {

	private EntityManager manager;

	public ReaderCSVHistorico() {
		this.manager = ConnectionFactoryJPA.getEntityManager();
	}

	/**
	 * @return Banco local Criado
	 */
	public void createDBHist() {

		manager.getTransaction().begin();
		List<HistoricoBancario> dataset = reader_csv_saving();

		for(HistoricoBancario hist : dataset) {
			manager.persist(hist);
		}

		manager.getTransaction().commit();
		System.out.println("INFO:Operação comitada.");
		manager.close();
	}


	/**
	 * @return List<String>
	 * Leitor do arquivo CVS local
	 */
	public  List<HistoricoBancario> reader_csv_saving() {
		String arquivoCSV = "TMP_HIST_AMOSTRA_LANCTO_2.csv";
		BufferedReader br = null;
		String linha = "";
		String cvsSplitBy = ",";

		List<HistoricoBancario> dataSet = new ArrayList<HistoricoBancario>();

		int i = 0 ;
		System.out.println("Rodando leitor...");
		try {

			br = new BufferedReader(new FileReader(arquivoCSV));

			while ((linha = br.readLine()) != null) {
				String[] data = linha.split(cvsSplitBy);
				HistoricoBancario hist = new HistoricoBancario();
				//System.out.println(linha);
				i++; 
				hist.setCd_unorg_agen(data[0] != null ? data[0] : "");
				hist.setNr_cnta_crrt(data[1] != null ? data[1] : "");
				hist.setCd_empresa(data[2] != null ? data[2] : "");
				hist.setNr_seq_lancamento(data[3] != null ? data[3] : "");
				hist.setNr_ptenv(data[4] != null ? data[4] : "");
				hist.setCd_lancamento(data[5] != null ? data[5] : "");
				hist.setVr_lancamento(data[6] != null ? Long.getLong(data[6]) : (long) 0.000);
				hist.setDt_contabil(data[7] != null ? converter(data[7]) : Calendar.getInstance());
				hist.setDt_lancamento(data[8] != null ? converter(data[8]) : Calendar.getInstance());
				hist.setTp_lancamento(data[9] != null ? data[9] : "");
				hist.setTp_debito(data[10] != null ? data[10] : "");
				hist.setCd_tipo_ptenv(data[11] != null ? data[11] : "");
				hist.setDt_carga(data[12] != null ? converter(data[12]) : Calendar.getInstance());
				hist.setNm_lancamento(data[13] != null ? data[13] : "");

				//System.out.println(hist.toString());
				dataSet.add(hist);
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

	public static Calendar converter(String stringDate) {
		if (stringDate == null) {
			return null;
		}
		Calendar calendar = new GregorianCalendar();
		try {
			Timestamp newDate = Timestamp.valueOf(stringDate);
			calendar.setTime(newDate);
		}
		catch (Exception e) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				calendar.setTime(simpleDateFormat.parse(stringDate));
			}
			catch (ParseException pe) {
				calendar = null;
			}
		}
		return calendar;
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




