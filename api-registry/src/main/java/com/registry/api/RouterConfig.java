package com.registry.api;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p.path("/get-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/calculate-conversion/**")
                        .uri("lb://currency-conversion-calculator"))
                .build();
    }
}
