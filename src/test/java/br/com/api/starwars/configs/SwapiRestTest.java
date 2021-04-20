package br.com.api.starwars.configs;

import br.com.api.starwars.entities.swapi.SwApi;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class SwapiRestTest {

    @Autowired
    public SwapiRest swapiRest;

    @Before
    public void setUp() {
        swapiRest = new SwapiRest();
    }

    @Test
    public void GetPlanetsTest() {
        ResponseEntity<SwApi> response = swapiRest.getPlanets();
        Assert.assertNotNull(response);
    }
}
