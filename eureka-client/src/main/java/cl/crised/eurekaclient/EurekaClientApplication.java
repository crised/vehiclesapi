package cl.crised.eurekaclient;

import cl.crised.eurekaclient.entity.Price;
import cl.crised.eurekaclient.repository.PricingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Bean
    CommandLineRunner initDataBase(PricingRepository repository) {
        return args -> {
            for (long i = 1; i <= 20; i++) {
                repository.save(new Price("USD", randomPrice(), i));
            }
        };
    }

    /**
     * Gets a random price to fill in for a given vehicle ID.
     *
     * @return random price for a vehicle
     */
    private BigDecimal randomPrice() {
        return new BigDecimal(ThreadLocalRandom.current().nextDouble(1, 5))
                .multiply(new BigDecimal(5000d)).setScale(2, RoundingMode.HALF_UP);
    }

}
