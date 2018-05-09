package br.com.zup.models.novo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tb_cliente")
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id_cliente")
	private Integer ID;
	
	private String NR_CNTA_CRRT;
			
	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer iD) {
		this.ID = iD;
	}
	public String getNR_CNTA_CRRT() {
		return NR_CNTA_CRRT;
	}
	public void setNR_CNTA_CRRT(String nR_CNTA_CRRT) {
		this.NR_CNTA_CRRT = nR_CNTA_CRRT;
	}
	
	public Cliente(Integer iD, String nR_CNTA_CRRT, List<Futuro> previsao) {
		super();
		this.ID = iD;
		this.NR_CNTA_CRRT = nR_CNTA_CRRT;
	}
	
	@Override
	public String toString() {
		return "Cliente [ID=" + ID + ", NR_CNTA_CRRT=" + NR_CNTA_CRRT +"]";
	}
	
	public Cliente() {
		super();
	}
	
	
}
