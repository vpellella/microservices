package com.calculator.currency.conversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionCalculatorApplication.class, args);
	}

}
