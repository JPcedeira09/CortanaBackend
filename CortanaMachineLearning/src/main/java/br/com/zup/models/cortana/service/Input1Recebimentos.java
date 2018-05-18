package br.com.zup.models.cortana.service;

import com.google.gson.Gson;

public class Input1Recebimentos {

	private Integer valor_recebido_mes;
	private Integer valor_recebido_mes_anterior;
	private Integer valor_recebido_mes_2;
	private Integer valor_recebido_mes_3;   
	private Integer valor_recebido_mes_4;   
	private Integer valor_recebido_mes_5;   
	private Integer valor_recebido_mes_6;   
	private Integer valor_recebido_mes_7;   
	private Integer valor_recebido_mes_8;   
	private Integer valor_recebido_mes_9;
	
	public Integer getValor_recebido_mes() {
		return valor_recebido_mes;
	}
	public void setValor_recebido_mes(Integer valor_recebido_mes) {
		this.valor_recebido_mes = valor_recebido_mes;
	}
	public Integer getValor_recebido_mes_anterior() {
		return valor_recebido_mes_anterior;
	}
	public void setValor_recebido_mes_anterior(Integer valor_recebido_mes_anterior) {
		this.valor_recebido_mes_anterior = valor_recebido_mes_anterior;
	}
	public Integer getValor_recebido_mes_2() {
		return valor_recebido_mes_2;
	}
	public void setValor_recebido_mes_2(Integer valor_recebido_mes_2) {
		this.valor_recebido_mes_2 = valor_recebido_mes_2;
	}
	public Integer getValor_recebido_mes_3() {
		return valor_recebido_mes_3;
	}
	public void setValor_recebido_mes_3(Integer valor_recebido_mes_3) {
		this.valor_recebido_mes_3 = valor_recebido_mes_3;
	}
	public Integer getValor_recebido_mes_4() {
		return valor_recebido_mes_4;
	}
	public void setValor_recebido_mes_4(Integer valor_recebido_mes_4) {
		this.valor_recebido_mes_4 = valor_recebido_mes_4;
	}
	public Integer getValor_recebido_mes_5() {
		return valor_recebido_mes_5;
	}
	public void setValor_recebido_mes_5(Integer valor_recebido_mes_5) {
		this.valor_recebido_mes_5 = valor_recebido_mes_5;
	}
	public Integer getValor_recebido_mes_6() {
		return valor_recebido_mes_6;
	}
	public void setValor_recebido_mes_6(Integer valor_recebido_mes_6) {
		this.valor_recebido_mes_6 = valor_recebido_mes_6;
	}
	public Integer getValor_recebido_mes_7() {
		return valor_recebido_mes_7;
	}
	public void setValor_recebido_mes_7(Integer valor_recebido_mes_7) {
		this.valor_recebido_mes_7 = valor_recebido_mes_7;
	}
	public Integer getValor_recebido_mes_8() {
		return valor_recebido_mes_8;
	}
	public void setValor_recebido_mes_8(Integer valor_recebido_mes_8) {
		this.valor_recebido_mes_8 = valor_recebido_mes_8;
	}
	public Integer getValor_recebido_mes_9() {
		return valor_recebido_mes_9;
	}
	public void setValor_recebido_mes_9(Integer valor_recebido_mes_9) {
		this.valor_recebido_mes_9 = valor_recebido_mes_9;
	}
	public Input1Recebimentos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Input1Recebimentos(Integer valor_recebido_mes, Integer valor_recebido_mes_anterior,
			Integer valor_recebido_mes_2, Integer valor_recebido_mes_3, Integer valor_recebido_mes_4,
			Integer valor_recebido_mes_5, Integer valor_recebido_mes_6, Integer valor_recebido_mes_7,
			Integer valor_recebido_mes_8, Integer valor_recebido_mes_9) {
		super();
		this.valor_recebido_mes = valor_recebido_mes;
		this.valor_recebido_mes_anterior = valor_recebido_mes_anterior;
		this.valor_recebido_mes_2 = valor_recebido_mes_2;
		this.valor_recebido_mes_3 = valor_recebido_mes_3;
		this.valor_recebido_mes_4 = valor_recebido_mes_4;
		this.valor_recebido_mes_5 = valor_recebido_mes_5;
		this.valor_recebido_mes_6 = valor_recebido_mes_6;
		this.valor_recebido_mes_7 = valor_recebido_mes_7;
		this.valor_recebido_mes_8 = valor_recebido_mes_8;
		this.valor_recebido_mes_9 = valor_recebido_mes_9;
	}
	@Override
	public String toString() {
		return "Input1Recebimentos [valor_recebido_mes=" + valor_recebido_mes + ", valor_recebido_mes_anterior="
				+ valor_recebido_mes_anterior + ", valor_recebido_mes_2=" + valor_recebido_mes_2
				+ ", valor_recebido_mes_3=" + valor_recebido_mes_3 + ", valor_recebido_mes_4=" + valor_recebido_mes_4
				+ ", valor_recebido_mes_5=" + valor_recebido_mes_5 + ", valor_recebido_mes_6=" + valor_recebido_mes_6
				+ ", valor_recebido_mes_7=" + valor_recebido_mes_7 + ", valor_recebido_mes_8=" + valor_recebido_mes_8
				+ ", valor_recebido_mes_9=" + valor_recebido_mes_9 + "]";
	}
	
	public String toJSON(){
		return new Gson().toJson(this);
	}
	
}
