package com.calculator.currency.conversion.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//@FeignClient(name = "currency-exchange", url = "localhost:10000")
@FeignClient(name = "currency-conversion")
public interface CurrencyConversionProxy {

    @GetMapping("/get-conversion/{from}/{to}")
    public CurrencyConversionDto getConversion(
            @PathVariable("from") String from,
            @PathVariable String to);

    }
