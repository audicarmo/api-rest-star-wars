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

    public Planet updatePlanet(final Long codigo, final Planet planet) {

        Planet planetSave = getByCode(codigo);
        BeanUtils.copyProperties(planet, planetSave, "codigo");

            return planetRepository.save(planetSave);
    }

    public Planet getByCode(final Long codigo) {
        Planet planetSave = planetRepository.getOne(codigo);
        if (planetSave == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return planetSave;
    }
}
