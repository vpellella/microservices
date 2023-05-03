package com.calculator.currency.conversion.service.client;

import java.math.BigDecimal;

public record CurrencyConversionDto (String from, String to, BigDecimal value, String hostDetails){
}
