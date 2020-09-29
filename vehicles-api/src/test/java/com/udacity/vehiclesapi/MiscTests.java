package com.udacity.vehiclesapi;

import com.udacity.vehiclesapi.client.prices.Price;
import com.udacity.vehiclesapi.client.prices.PriceClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MiscTests {

    @LocalServerPort
    private int port;

    @Autowired
    PriceClient priceClient;

    /*
    Pricing client should be running in order for this test to pass.
    It should get a price from the pricing-service
     */
    @Test
    public void testPriceClient(){
        System.out.println("testing price client");
        String priceString = priceClient.getPrice(1L);
        assertTrue(priceString.contains("USD"));
    }


}
