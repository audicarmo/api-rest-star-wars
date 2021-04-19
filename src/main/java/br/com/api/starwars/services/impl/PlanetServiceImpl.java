package br.com.api.starwars.services.impl;

import br.com.api.starwars.constants.ValidationConstraints;
import br.com.api.starwars.entities.Planet;
import br.com.api.starwars.enums.ErrorCodeEnum;
import br.com.api.starwars.enums.ErrorMessages;
import br.com.api.starwars.exceptions.PlanetException;
import br.com.api.starwars.repositories.PlanetRepository;
import br.com.api.starwars.services.PlanetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private final PlanetRepository planetRepository;

    @Override
    @Transactional
    public Planet createPlanet(final Planet planet, final HttpServletResponse response) {

        Planet planetSave = createPlanet(planet, response);
            return planetRepository.save(planetSave);
    }

    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    @Override
    @Transactional
    public Planet getByCode(final String id) {
        Optional<Planet> planetSave = planetRepository.findById(id);
        if (planetSave == null) {
            throw new PlanetException(
                    ErrorCodeEnum.API_UNAVAILABLE,
                    ErrorMessages.INTERNAL_SERVER_ERROR,
                    ValidationConstraints.CODE_NOT_FOUND
            );
        }
        return planetSave;
    }
    
    public List<Planet> getName(String name) {
        return planetRepository.getPlanet(name);
    }
    
    public void deletePlanet(String id) {
        planetRepository.delete(getByCode(id));
    }
}