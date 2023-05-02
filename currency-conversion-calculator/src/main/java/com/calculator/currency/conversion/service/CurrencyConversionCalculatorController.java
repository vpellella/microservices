package com.calculator.currency.conversion.service;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class CurrencyConversionCalculatorController {

    private final RestTemplate restTemplate;
    private final CurrencyConversionProxy currencyConversionProxy;

    @GetMapping(path="/calculate-currency-conversion-old/{from}/{to}/{quantity}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public CurrencyConversionCalculatorDto calculateConversionOld(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity){

        ResponseEntity<CurrencyConversionDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:10000/get-conversion/usd/inr",
                CurrencyConversionDto.class);
        CurrencyConversionDto currencyConversionDto = responseEntity.getBody();

        return CurrencyConversionCalculatorDto.builder()
                .from(from)
                .to(to)
                .quantity(quantity)
                .convertedValue(currencyConversionDto.value().multiply(quantity))
                .build();

    }

    @GetMapping(path="/calculate-currency-conversion/{from}/{to}/{quantity}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public CurrencyConversionCalculatorDto calculateConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity){

        CurrencyConversionDto currencyConversionDto = currencyConversionProxy.getConversion(from, to);

        return CurrencyConversionCalculatorDto.builder()
                .from(from)
                .to(to)
                .quantity(quantity)
                .convertedValue(currencyConversionDto.value().multiply(quantity))
                .hostDetails(currencyConversionDto.hostDetails())
                .build();

    }

}
