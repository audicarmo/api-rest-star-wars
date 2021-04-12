package br.com.api.starwars.services;

import br.com.api.starwars.entities.Planet;

public interface PlanetService {

    Object create(String name, String clima, String terreno);

    Planet update(String name, String clima, String terreno);

    void delete(String id, String name);
}
