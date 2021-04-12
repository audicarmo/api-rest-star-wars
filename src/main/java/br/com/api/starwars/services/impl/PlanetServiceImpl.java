package br.com.api.starwars.services.impl;

import br.com.api.starwars.entities.Planet;
import br.com.api.starwars.repositories.PlanetRepository;
import br.com.api.starwars.services.PlanetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository repository;
    private Object Planet;

    @Override
    @Transactional
    public Planet create(final String name, final String clima, final String terreno) {

        Planet planet = createPlanet(name, clima);
        return repository.save(planet);
    }

    //TODO Improve implementation
    @Override
    @Transactional
    public Planet update(final String name, final String clima, final String terreno) {
        return null;
    }

    @Override
    public void delete(final String id, final String name) {

    }

    //TODO Refactor this method
    private Planet createPlanet(String name, String clima) {

        return (br.com.api.starwars.entities.Planet) Planet;
    }
}
