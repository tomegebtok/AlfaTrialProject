package org.alfatrial.com.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true, value = "timestamp")
public class CurrencyObject {
    @JsonProperty(value = "rates")
    private final Map<String, Double> exchangeRates;
    @JsonProperty(value = "timestamp")
    private Long timestamp;

    public CurrencyObject(Map<String, Double> rate, Long timestamp) {
        this.exchangeRates = rate;
        this.timestamp = timestamp;
    }

    public Map<String, Double> getExchangeRates() {
        return exchangeRates;
    }
}
