package br.com.zup.cortana.models;

import javax.ejb.Stateless;

@Stateless
public class MensagemPOPUP {

	public String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
