package br.com.zup.models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

import br.com.zup.utils.Listener;

@EntityListeners(Listener.class)
@Table(name="tb_conta_bancarias")
@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	
	private String titular;
	private String banco; 
	private String agencia;
	private String numero;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		this.ID = iD;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Conta(String titular, String banco, String agencia, String numero) {
		super();
		this.titular = titular;
		this.banco = banco;
		this.agencia = agencia;
		this.numero = numero;
	}
	
	public Conta() {
		super();
	}
	
	public String toJSON(){
		return new Gson().toJson(this);
	}
	
	
}
