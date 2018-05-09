package br.com.zup.cortana.models;

import com.google.gson.Gson;

public class Inputs {

	private String inputs;

	public String getInputs() {
		return inputs;
	}

	public void setInputs(String inputs) {
		this.inputs = inputs;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}
}
