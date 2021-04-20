package br.com.api.starwars.services;

import br.com.api.starwars.entities.Planet;

import javax.servlet.http.HttpServletResponse;

public interface PlanetService {

    Planet create(final Planet planet, HttpServletResponse response);

    Planet getByCode(final String codigo);

    Planet getName(final String name);

    void deletePlanet(final String id);

    Planet getAllPlanets();

    void delete(String id);
}
