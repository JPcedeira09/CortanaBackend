package br.com.zup.cortana.models;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "valor_gasto_mes",
    "valor_gasto_mes_anterior",
    "valor_recebido_mes_anterior",
    "valor_recebido_mes2",
    "valor_recebido_mes3",
    "valor_recebido_mes_4",
    "valor_recebido_mes_5",
    "valor_recebido_mes_6",
    "valor_recebido_mes_7",
    "valor_recebido_mes_8",
    "valor_recebido_mes_9",
    "valor_gasto_mes2",
    "valor_gasto_mes3",
    "valor_gasto_mes4",
    "valor_gasto_mes5",
    "valor_gasto_mes6",
    "Scored Labels"
})
public class Output1 {

    @JsonProperty("valor_gasto_mes")
    private String valorGastoMes;
    @JsonProperty("valor_gasto_mes_anterior")
    private String valorGastoMesAnterior;
    @JsonProperty("valor_recebido_mes_anterior")
    private String valorRecebidoMesAnterior;
    @JsonProperty("valor_gasto_mes2")
    private String valorGastoMes2;
    @JsonProperty("valor_gasto_mes3")
    private String valorGastoMes3;
    @JsonProperty("valor_gasto_mes4")
    private String valorGastoMes4;
    @JsonProperty("valor_gasto_mes5")
    private String valorGastoMes5;
    @JsonProperty("valor_gasto_mes6")
    private String valorGastoMes6;
    @JsonProperty("valor_recebido_mes2")
    private String valorRecebidoMes2;
    @JsonProperty("valor_recebido_mes3")
    private String valorRecebidoMes3;
    @JsonProperty("valor_recebido_mes_4")
    private String valorRecebidoMes4;
    @JsonProperty("valor_recebido_mes_5")
    private String valorRecebidoMes5;
    @JsonProperty("valor_recebido_mes_6")
    private String valorRecebidoMes6;
    @JsonProperty("valor_recebido_mes_7")
    private String valorRecebidoMes7;
    @JsonProperty("valor_recebido_mes_8")
    private String valorRecebidoMes8;
    @JsonProperty("valor_recebido_mes_9")
    private String valorRecebidoMes9;
    @JsonProperty("Scored Labels")
    private String scoredLabels;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("valor_gasto_mes")
    public String getValorGastoMes() {
        return valorGastoMes;
    }

    @JsonProperty("valor_gasto_mes")
    public void setValorGastoMes(String valorGastoMes) {
        this.valorGastoMes = valorGastoMes;
    }

    @JsonProperty("valor_gasto_mes_anterior")
    public String getValorGastoMesAnterior() {
        return valorGastoMesAnterior;
    }

    @JsonProperty("valor_gasto_mes_anterior")
    public void setValorGastoMesAnterior(String valorGastoMesAnterior) {
        this.valorGastoMesAnterior = valorGastoMesAnterior;
    }

    @JsonProperty("valor_recebido_mes_anterior")
    public String getValorRecebidoMesAnterior() {
        return valorRecebidoMesAnterior;
    }

    @JsonProperty("valor_recebido_mes_anterior")
    public void setValorRecebidoMesAnterior(String valorRecebidoMesAnterior) {
        this.valorRecebidoMesAnterior = valorRecebidoMesAnterior;
    }

    @JsonProperty("valor_gasto_mes2")
    public String getValorGastoMes2() {
        return valorGastoMes2;
    }

    @JsonProperty("valor_gasto_mes2")
    public void setValorGastoMes2(String valorGastoMes2) {
        this.valorGastoMes2 = valorGastoMes2;
    }

    @JsonProperty("valor_gasto_mes3")
    public String getValorGastoMes3() {
        return valorGastoMes3;
    }

    @JsonProperty("valor_gasto_mes3")
    public void setValorGastoMes3(String valorGastoMes3) {
        this.valorGastoMes3 = valorGastoMes3;
    }

    @JsonProperty("valor_gasto_mes4")
    public String getValorGastoMes4() {
        return valorGastoMes4;
    }

    @JsonProperty("valor_gasto_mes4")
    public void setValorGastoMes4(String valorGastoMes4) {
        this.valorGastoMes4 = valorGastoMes4;
    }

    @JsonProperty("valor_gasto_mes5")
    public String getValorGastoMes5() {
        return valorGastoMes5;
    }

    @JsonProperty("valor_gasto_mes5")
    public void setValorGastoMes5(String valorGastoMes5) {
        this.valorGastoMes5 = valorGastoMes5;
    }

    @JsonProperty("valor_gasto_mes6")
    public String getValorGastoMes6() {
        return valorGastoMes6;
    }

    @JsonProperty("valor_gasto_mes6")
    public void setValorGastoMes6(String valorGastoMes6) {
        this.valorGastoMes6 = valorGastoMes6;
    }

    @JsonProperty("valor_recebido_mes2")
    public String getValorRecebidoMes2() {
        return valorRecebidoMes2;
    }

    @JsonProperty("valor_recebido_mes2")
    public void setValorRecebidoMes2(String valorRecebidoMes2) {
        this.valorRecebidoMes2 = valorRecebidoMes2;
    }

    @JsonProperty("valor_recebido_mes3")
    public String getValorRecebidoMes3() {
        return valorRecebidoMes3;
    }

    @JsonProperty("valor_recebido_mes3")
    public void setValorRecebidoMes3(String valorRecebidoMes3) {
        this.valorRecebidoMes3 = valorRecebidoMes3;
    }

    @JsonProperty("valor_recebido_mes_4")
    public String getValorRecebidoMes4() {
        return valorRecebidoMes4;
    }

    @JsonProperty("valor_recebido_mes_4")
    public void setValorRecebidoMes4(String valorRecebidoMes4) {
        this.valorRecebidoMes4 = valorRecebidoMes4;
    }

    @JsonProperty("valor_recebido_mes_5")
    public String getValorRecebidoMes5() {
        return valorRecebidoMes5;
    }

    @JsonProperty("valor_recebido_mes_5")
    public void setValorRecebidoMes5(String valorRecebidoMes5) {
        this.valorRecebidoMes5 = valorRecebidoMes5;
    }

    @JsonProperty("valor_recebido_mes_6")
    public String getValorRecebidoMes6() {
        return valorRecebidoMes6;
    }

    @JsonProperty("valor_recebido_mes_6")
    public void setValorRecebidoMes6(String valorRecebidoMes6) {
        this.valorRecebidoMes6 = valorRecebidoMes6;
    }

    @JsonProperty("valor_recebido_mes_7")
    public String getValorRecebidoMes7() {
        return valorRecebidoMes7;
    }

    @JsonProperty("valor_recebido_mes_7")
    public void setValorRecebidoMes7(String valorRecebidoMes7) {
        this.valorRecebidoMes7 = valorRecebidoMes7;
    }

    @JsonProperty("valor_recebido_mes_8")
    public String getValorRecebidoMes8() {
        return valorRecebidoMes8;
    }

    @JsonProperty("valor_recebido_mes_8")
    public void setValorRecebidoMes8(String valorRecebidoMes8) {
        this.valorRecebidoMes8 = valorRecebidoMes8;
    }

    @JsonProperty("valor_recebido_mes_9")
    public String getValorRecebidoMes9() {
        return valorRecebidoMes9;
    }

    @JsonProperty("valor_recebido_mes_9")
    public void setValorRecebidoMes9(String valorRecebidoMes9) {
        this.valorRecebidoMes9 = valorRecebidoMes9;
    }


    @JsonProperty("Scored Labels")
    public String getScoredLabels() {
        return scoredLabels;
    }

    @JsonProperty("Scored Labels")
    public void setScoredLabels(String scoredLabels) {
        this.scoredLabels = scoredLabels;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Output1 [valorGastoMes=" + valorGastoMes + ", valorGastoMesAnterior=" + valorGastoMesAnterior
				+ ", valorRecebidoMesAnterior=" + valorRecebidoMesAnterior + ", valorGastoMes2=" + valorGastoMes2
				+ ", valorGastoMes3=" + valorGastoMes3 + ", valorGastoMes4=" + valorGastoMes4 + ", valorGastoMes5="
				+ valorGastoMes5 + ", valorGastoMes6=" + valorGastoMes6 + ", valorRecebidoMes2=" + valorRecebidoMes2
				+ ", valorRecebidoMes3=" + valorRecebidoMes3 + ", valorRecebidoMes4=" + valorRecebidoMes4
				+ ", valorRecebidoMes5=" + valorRecebidoMes5 + ", valorRecebidoMes6=" + valorRecebidoMes6
				+ ", valorRecebidoMes7=" + valorRecebidoMes7 + ", valorRecebidoMes8=" + valorRecebidoMes8
				+ ", valorRecebidoMes9=" + valorRecebidoMes9 + ", scoredLabels=" + scoredLabels
				+ ", additionalProperties=" + additionalProperties + "]";
	}    
    
}
