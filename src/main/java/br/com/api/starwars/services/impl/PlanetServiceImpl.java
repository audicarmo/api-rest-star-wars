package br.com.api.starwars.services.impl;

import br.com.api.starwars.entities.Planet;
import br.com.api.starwars.repositories.PlanetRepository;
import br.com.api.starwars.services.PlanetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private final PlanetRepository planetRepository;

    @Transactional
    public Planet createPlanet(final Planet planet, final HttpServletResponse response) {

        Planet planetSave = createPlanet(planet, response);
            return planetRepository.save(planetSave);
    }

    public Planet updatePlanet(final String codigo, final Planet planet) {

        Optional<Planet> planetSave = Optional.ofNullable(getByCode(codigo));
        BeanUtils.copyProperties(planet, planetSave, "codigo");

            return planetRepository.save(planetSave);
    }

    public Optional<Planet> getByCode(final String codigo) {
        Optional<Planet> planetSave = planetRepository.findById(codigo);
        if (planetSave == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return planetSave;
    }
}
