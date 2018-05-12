package br.com.zup.cortana.models;

import javax.ejb.Stateless;

import com.google.gson.Gson;

@Stateless
public class MensagemPOPUP {

	private String msg;
	private Long predictGasto;
	private Long predictRecebimentos;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getPredictGasto() {
		return predictGasto;
	}
	public void setPredictGasto(Long predictGasto) {
		this.predictGasto = predictGasto;
	}
	public Long getPredictRecebimentos() {
		return predictRecebimentos;
	}
	public void setPredictRecebimentos(Long predictRecebimentos) {
		this.predictRecebimentos = predictRecebimentos;
	}
	public MensagemPOPUP(String msg, Long predictGasto, Long predictRecebimentos) {
		super();
		this.msg = msg;
		this.predictGasto = predictGasto;
		this.predictRecebimentos = predictRecebimentos;
	}
	public MensagemPOPUP() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MensagemPOPUP [msg=" + msg + ", predictGasto=" + predictGasto + ", predictRecebimentos="
				+ predictRecebimentos + "]";
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}

}
