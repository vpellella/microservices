package com.currency.conversion.service;

import java.math.BigDecimal;

public record CurrencyConversionResponseDto(String from, String to, BigDecimal value, String hostDetails) {
}
