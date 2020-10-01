package com.udacity.vehiclesapi;

import com.udacity.vehiclesapi.domain.manufacturer.Manufacturer;
import com.udacity.vehiclesapi.domain.manufacturer.ManufacturerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
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

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	/**
	 * Initializes the car manufacturers available to the Vehicle API.
	 * @param repository where the manufacturer information persists.
	 * @return the car manufacturers to add to the related repository
	 */
	@Bean
	CommandLineRunner initDatabase(ManufacturerRepository repository) {
		return args -> {
			repository.save(new Manufacturer(100, "Audi"));
			repository.save(new Manufacturer(101, "Chevrolet"));
			repository.save(new Manufacturer(102, "Ford"));
			repository.save(new Manufacturer(103, "BMW"));
			repository.save(new Manufacturer(104, "Dodge"));
		};
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
