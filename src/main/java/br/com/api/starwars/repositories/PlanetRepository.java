package br.com.api.starwars.repositories;

import br.com.api.starwars.entities.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String> {

    List<Planet> getPlanet(String name);
}
