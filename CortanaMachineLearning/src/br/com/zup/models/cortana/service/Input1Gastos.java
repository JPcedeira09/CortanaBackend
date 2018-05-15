package br.com.zup.models.cortana.service;

import com.google.gson.Gson;

public class Input1Gastos {

	private Long valor_gasto_mes;
	private Long valor_gasto_mes_anterior;
	private Long valor_recebido_mes_anterior;
	private Long valor_gasto_mes2;
	private Long valor_gasto_mes3;
	private Long valor_gasto_mes4;
	private Long valor_gasto_mes5;
	private Long valor_gasto_mes6;
	private Long valor_recebido_mes2;   
	private Long valor_recebido_mes3;

	public Long getValor_gasto_mes() {
		return valor_gasto_mes;
	}

	public void setValor_gasto_mes(Long valor_gasto_mes) {
		this.valor_gasto_mes = valor_gasto_mes;
	}

	public Long getValor_gasto_mes_anterior() {
		return valor_gasto_mes_anterior;
	}

	public void setValor_gasto_mes_anterior(Long valor_gasto_mes_anterior) {
		this.valor_gasto_mes_anterior = valor_gasto_mes_anterior;
	}

	public Long getValor_recebido_mes_anterior() {
		return valor_recebido_mes_anterior;
	}

	public void setValor_recebido_mes_anterior(Long valor_recebido_mes_anterior) {
		this.valor_recebido_mes_anterior = valor_recebido_mes_anterior;
	}

	public Long getValor_gasto_mes2() {
		return valor_gasto_mes2;
	}

	public void setValor_gasto_mes2(Long valor_gasto_mes2) {
		this.valor_gasto_mes2 = valor_gasto_mes2;
	}

	public Long getValor_gasto_mes3() {
		return valor_gasto_mes3;
	}

	public void setValor_gasto_mes3(Long valor_gasto_mes3) {
		this.valor_gasto_mes3 = valor_gasto_mes3;
	}

	public Long getValor_gasto_mes4() {
		return valor_gasto_mes4;
	}

	public void setValor_gasto_mes4(Long valor_gasto_mes4) {
		this.valor_gasto_mes4 = valor_gasto_mes4;
	}

	public Long getValor_gasto_mes5() {
		return valor_gasto_mes5;
	}

	public void setValor_gasto_mes5(Long valor_gasto_mes5) {
		this.valor_gasto_mes5 = valor_gasto_mes5;
	}

	public Long getValor_gasto_mes6() {
		return valor_gasto_mes6;
	}

	public void setValor_gasto_mes6(Long valor_gasto_mes6) {
		this.valor_gasto_mes6 = valor_gasto_mes6;
	}

	public Long getValor_recebido_mes2() {
		return valor_recebido_mes2;
	}

	public void setValor_recebido_mes2(Long valor_recebido_mes2) {
		this.valor_recebido_mes2 = valor_recebido_mes2;
	}

	public Long getValor_recebido_mes3() {
		return valor_recebido_mes3;
	}

	public void setValor_recebido_mes3(Long valor_recebido_mes3) {
		this.valor_recebido_mes3 = valor_recebido_mes3;
	}

	public Input1Gastos() {
		super();
	}

	public Input1Gastos(Long valor_gasto_mes, Long valor_gasto_mes_anterior,
			Long valor_recebido_mes_anterior, Long valor_gasto_mes2, Long valor_gasto_mes3,
			Long valor_gasto_mes4, Long valor_gasto_mes5, Long valor_gasto_mes6,
			Long valor_recebido_mes2, Long valor_recebido_mes3) {
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
