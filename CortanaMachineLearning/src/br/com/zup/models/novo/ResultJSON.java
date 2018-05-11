package br.com.zup.models.novo;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.zup.cortana.models.Results;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Results"
})
public class ResultJSON {

	    @JsonProperty("Results")
	    private Results results;
	    @JsonIgnore
	    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	    @JsonProperty("Results")
	    public Results getResults() {
	        return results;
	    }

	    @JsonProperty("Results")
	    public void setResults(Results results) {
	        this.results = results;
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
			return "ResultJSON [results=" + results + ", additionalProperties=" + additionalProperties + "]";
		}
	    

	}