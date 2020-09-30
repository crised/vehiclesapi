package com.udacity.vehiclesapi;

import com.udacity.vehiclesapi.client.maps.MapsClient;
import com.udacity.vehiclesapi.client.prices.Price;
import com.udacity.vehiclesapi.client.prices.PriceClient;
import com.udacity.vehiclesapi.domain.Location;
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

    @Autowired
    MapsClient mapsClient;

    /*
    Pricing client should be running in order for this test to pass.
    It should get a price from the pricing-service
     */
    @Test
    public void testPriceClient(){
        String priceString = priceClient.getPrice(1L);
        assertTrue(priceString.contains("USD"));
    }

    @Test
    public void testMapClient(){
        Location location = new Location(20.0, 30.0);
        mapsClient.getAddress(location);
        assertNotNull(location.getAddress());
        assertNotNull(location.getZip());
    }


}
