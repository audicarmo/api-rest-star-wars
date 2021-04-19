package br.com.api.starwars.services;

import br.com.api.starwars.entities.Planet;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public interface PlanetService {

    Planet createPlanet(Planet planet, HttpServletResponse response);

    Optional<Planet> getByCode(String codigo);
}
