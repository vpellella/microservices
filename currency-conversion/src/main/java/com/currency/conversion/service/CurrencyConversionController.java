package com.currency.conversion.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class CurrencyConversionController {

    private final ConversionConfig conversionConfig;
    private final Environment environment;

    @Autowired
    private HttpServletRequest request;

    public CurrencyConversionController(ConversionConfig conversionConfig, Environment environment) {
        this.conversionConfig = conversionConfig;
        this.environment = environment;
    }

    @GetMapping("/get-conversion/{from}/{to}")
    public CurrencyConversionResponseDto getConversion(
            @PathVariable("from") String from, @PathVariable String to) {
        while (request.getSession().getAttributeNames().hasMoreElements())
            System.out.println(request.getSession().getAttributeNames().nextElement());

        List.of(request.getCookies()).forEach(cookie ->
                System.out.println(cookie));

        Collections.list(request.getHeaderNames()).forEach(header ->
                System.out.println(header + "   ::   "+ request.getHeader(header)));

        return new CurrencyConversionResponseDto(from, to,
                conversionConfig.getValue(),
                environment.getProperty("server.port"));
    }
}
