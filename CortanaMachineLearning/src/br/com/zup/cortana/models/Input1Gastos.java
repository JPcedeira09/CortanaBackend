package br.com.zup.cortana.models;

import com.google.gson.Gson;

public class Input1Gastos {

	private Integer valor_gasto_mes;
	private Integer valor_gasto_mes_anterior;
	private Integer valor_recebido_mes_anterior;
	private Integer valor_gasto_mes2;
	private Integer valor_gasto_mes3;
	private Integer valor_gasto_mes4;
	private Integer valor_gasto_mes5;
	private Integer valor_gasto_mes6;
	private Integer valor_recebido_mes2;   
	private Integer valor_recebido_mes3;

	public Integer getValor_gasto_mes() {
		return valor_gasto_mes;
	}

	public void setValor_gasto_mes(Integer valor_gasto_mes) {
		this.valor_gasto_mes = valor_gasto_mes;
	}

	public Integer getValor_gasto_mes_anterior() {
		return valor_gasto_mes_anterior;
	}

	public void setValor_gasto_mes_anterior(Integer valor_gasto_mes_anterior) {
		this.valor_gasto_mes_anterior = valor_gasto_mes_anterior;
	}

	public Integer getValor_recebido_mes_anterior() {
		return valor_recebido_mes_anterior;
	}

	public void setValor_recebido_mes_anterior(Integer valor_recebido_mes_anterior) {
		this.valor_recebido_mes_anterior = valor_recebido_mes_anterior;
	}

	public Integer getValor_gasto_mes2() {
		return valor_gasto_mes2;
	}

	public void setValor_gasto_mes2(Integer valor_gasto_mes2) {
		this.valor_gasto_mes2 = valor_gasto_mes2;
	}

	public Integer getValor_gasto_mes3() {
		return valor_gasto_mes3;
	}

	public void setValor_gasto_mes3(Integer valor_gasto_mes3) {
		this.valor_gasto_mes3 = valor_gasto_mes3;
	}

	public Integer getValor_gasto_mes4() {
		return valor_gasto_mes4;
	}

	public void setValor_gasto_mes4(Integer valor_gasto_mes4) {
		this.valor_gasto_mes4 = valor_gasto_mes4;
	}

	public Integer getValor_gasto_mes5() {
		return valor_gasto_mes5;
	}

	public void setValor_gasto_mes5(Integer valor_gasto_mes5) {
		this.valor_gasto_mes5 = valor_gasto_mes5;
	}

	public Integer getValor_gasto_mes6() {
		return valor_gasto_mes6;
	}

	public void setValor_gasto_mes6(Integer valor_gasto_mes6) {
		this.valor_gasto_mes6 = valor_gasto_mes6;
	}

	public Integer getValor_recebido_mes2() {
		return valor_recebido_mes2;
	}

	public void setValor_recebido_mes2(Integer valor_recebido_mes2) {
		this.valor_recebido_mes2 = valor_recebido_mes2;
	}

	public Integer getValor_recebido_mes3() {
		return valor_recebido_mes3;
	}

	public void setValor_recebido_mes3(Integer valor_recebido_mes3) {
		this.valor_recebido_mes3 = valor_recebido_mes3;
	}

	public Input1Gastos() {
		super();
	}

	public Input1Gastos(Integer valor_gasto_mes, Integer valor_gasto_mes_anterior,
			Integer valor_recebido_mes_anterior, Integer valor_gasto_mes2, Integer valor_gasto_mes3,
			Integer valor_gasto_mes4, Integer valor_gasto_mes5, Integer valor_gasto_mes6,
			Integer valor_recebido_mes2, Integer valor_recebido_mes3) {
		super();
		this.valor_gasto_mes = valor_gasto_mes;
		this.valor_gasto_mes_anterior = valor_gasto_mes_anterior;
		this.valor_recebido_mes_anterior = valor_recebido_mes_anterior;
		this.valor_gasto_mes2 = valor_gasto_mes2;
		this.valor_gasto_mes3 = valor_gasto_mes3;
		this.valor_gasto_mes4 = valor_gasto_mes4;
		this.valor_gasto_mes5 = valor_gasto_mes5;
		this.valor_gasto_mes6 = valor_gasto_mes6;
		this.valor_recebido_mes2 = valor_recebido_mes2;
		this.valor_recebido_mes3 = valor_recebido_mes3;
	}


	public String toJSON() {
		return new Gson().toJson(this);
	}
	
}
