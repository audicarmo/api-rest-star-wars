package br.com.api.starwars.repositories.queries;

import br.com.api.starwars.entities.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlanetQueries {

    Page<Planet> getPlanetsAll(String name, String climate,
                               String ground, Pageable pageable);

}
