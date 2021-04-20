package br.com.api.starwars.repositories;

import br.com.api.starwars.entities.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String> {

    List<Planet> getPlanet(String name);

    Optional<Planet> findByCodeIgnoreCaseAndDeletedIsFalse(
            @Param("id") String id
    );

    List<Planet> findByNameCaseAndDeletedIsFalse(
            @Param("name") String name
    );
}
