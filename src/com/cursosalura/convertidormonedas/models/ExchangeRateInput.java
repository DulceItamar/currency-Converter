package com.cursosalura.convertidormonedas.models;

import java.util.Map;

//base_code --> currentCurrency
//convrsion_rates --> list of all conversion rates
public record ExchangeRateInput(String base_code, Map<String, Float> conversion_rates) {
}
