package br.com.api.starwars.services;

import br.com.api.starwars.entities.Planet;
import br.com.api.starwars.repositories.PlanetRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class PlanetServiceTest {

    @Autowired
    private PlanetService planetService;

    @Mock
    private PlanetRepository planetRepository;

    @Before
    public void setUp() {
        planetRepository = Mockito.mock(planetRepository.class);
        planetService = new PlanetService(planetRepository);
    }

    @Test
    public void createTest() {
        Planet planet = new Planet("Nárnia","frozen",375675676L);
        planet.setId("Nárnia");
        when(planetRepository.save(planet)).thenReturn(planet);

        Planet planetResponse = planetService.create(planet);
        Assert.assertEquals(planetResponse.getName());
    }

    @Test
    public void getAllPlanetsTest() {
        Planet planetRosa = new Planet("Rosa","Teste", 6754746784675L);
        Planet planetAzul = new Planet("Azul","Teste", 675474675L));
        Planet planetCiano = new Planet("Ciano","Teste", 675474678465L));

        List<Planet> planets = new ArrayList<Planet>();
        planets.add(planetRosa);
        planets.add(planetAzul);
        planets.add(planetCiano);

        when(planetRepository.findAll()).thenReturn(planets);

        List<Planet> planetsResponse = planetService.getAllPlanets();
        Assert.assertEquals(planetsResponse.get(0).getName(planetAzul));
    }

    @Test
    public void getByCodeNotFound() {
        try {
            planetService.getByCode("");
        }catch(Exception e) {
            Assert.assertEquals("Code not found", e.getMessage() );
        }
}

