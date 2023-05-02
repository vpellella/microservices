package com.currency.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CurrencyConversionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CurrencyConversionApplication.class, args);

	}

}
