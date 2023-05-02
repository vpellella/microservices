package com.calculator.currency.conversion.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CurrencyConversionCalculatorDto {
    private String from;
    private String to;
    private BigDecimal quantity;

    private BigDecimal convertedValue;
    private String hostDetails;

}
