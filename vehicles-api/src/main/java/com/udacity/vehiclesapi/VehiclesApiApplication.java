package com.udacity.vehiclesapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableJpaAuditing
public class VehiclesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiclesApiApplication.class, args);
	}

	/**
	 * Web Client for the maps (location) API
	 * @param endpoint where to communicate for the maps API
	 * @return created maps endpoint
	 */
	@Bean(name="maps")
	public WebClient webClientMaps(@Value("${maps.endpoint}") String endpoint) {
		return WebClient.create(endpoint);
	}

	/**
	 * Web Client for the pricing API
	 * @param endpoint where to communicate for the pricing API
	 * @return created pricing endpoint
	 */
	@Bean(name="pricing")
	public WebClient webClientPricing(@Value("${pricing.endpoint}") String endpoint) {
		return WebClient.create(endpoint);
	}

}
