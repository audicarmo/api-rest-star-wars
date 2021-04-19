package br.com.api.starwars.services;

import br.com.api.starwars.entities.Planet;

import javax.servlet.http.HttpServletResponse;

public interface PlanetService {

    Planet createPlanet(Planet planet, HttpServletResponse response);

    Planet getByCode(String codigo);

    Planet getName(String name);

    void deletePlanet(String id);
}
