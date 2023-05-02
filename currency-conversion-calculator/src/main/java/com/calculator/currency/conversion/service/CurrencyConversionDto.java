package com.calculator.currency.conversion.service;

import java.math.BigDecimal;

public record CurrencyConversionDto (String from, String to, BigDecimal value, String hostDetails){
}
