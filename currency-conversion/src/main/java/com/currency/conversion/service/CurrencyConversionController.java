package com.currency.conversion.service;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

    private final ConversionConfig conversionConfig;
    private final Environment environment;

    public CurrencyConversionController(ConversionConfig conversionConfig, Environment environment) {
        this.conversionConfig = conversionConfig;
        this.environment = environment;
    }

    @GetMapping("/get-conversion/{from}/{to}")
    public CurrencyConversionResponseDto getConversion(
            @PathVariable("from") String from,
            @PathVariable String to){


        return new CurrencyConversionResponseDto(from, to,
                conversionConfig.getValue(),
                environment.getProperty("server.port"));
    }
}
