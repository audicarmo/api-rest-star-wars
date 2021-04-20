package br.com.api.starwars.repository;

import br.com.api.starwars.entities.Planet;
import br.com.api.starwars.repositories.PlanetRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetRepositoryTest {

    public Planet planet;

    @Autowired
    public PlanetRepository planetRepository;

    @Test
    public void createPlanetTest() {
        Planet planet = planetRepository.save(new Planet("Test", "Test", 8577564L));
        Assert.assertFalse(planet.getId().isEmpty());
        planetRepository.delete(planet);
    }

    @Test
    public void getNamePlanetTest() {
        List<Planet> response = planetRepository.findByNameCaseAndDeletedIsFalse("test");
        Assert.assertFalse(response.isEmpty());
    }

    @Test
    public void getByCodePlanetTest() {
        List<Planet> response = planetRepository.findAll();
        Assert.assertFalse(response.isEmpty());
    }

    @Test
    public void getAllPlanetsTest() {
        List<Planet> planets = planetRepository.findByNameCaseAndDeletedIsFalse("Test");
        planetRepository.delete(planet.getId(0));
        List<Planet> response = planetRepository.findByNameCaseAndDeletedIsFalse("test");
        Assert.assertTrue(response.isEmpty());
    }

    @Test
    public void deletePlanetTest() {

        List<Planet> planeta = planetRepository.findByNameCaseAndDeletedIsFalse("Test");
        planetRepository.delete(planeta.get(0));
        List<Planet> response = planetRepository.findByNameCaseAndDeletedIsFalse("test");
        Assert.assertTrue(response.isEmpty());
    }
}
