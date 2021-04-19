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
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private final PlanetRepository planetRepository;

    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    @Override
    @Transactional
    public Planet create(final Planet planet, final HttpServletResponse response) {
        Planet planetSave = create(planet, response);

            return planetRepository.save(planetSave);
    }

    @Override
    @Transactional
    public Planet getByCode(final String id) {
        Planet planet = findByGetCodeOrElseThrow(id);
        planet.validateIfDeleted();

        return planet;
    }

    @Override
    @Transactional(readOnly = true)
    public Planet getName(final String name) {
        Planet planet = findByName(name);
        planet.validateIfDeleted();

        return planet;
    }

    @Override
    @Transactional
    public void deletePlanet(final String id) {
        Planet planet = findByGetCodeOrElseThrow(id);
        planet.setDeleted(true);
        planetRepository.save(planet);
    }

    private Planet findByGetCodeOrElseThrow(final String id) {
        return planetRepository.findByCodeIgnoreCaseAndDeletedIsFalse(id)
                .orElseThrow(() -> {
                    return new PlanetException(ErrorCodeEnum.API_UNAVAILABLE,
                            ErrorMessages.INTERNAL_SERVER_ERROR,
                            ValidationConstraints.CODE_NOT_FOUND))
                });
    }

    private Planet findByName(final String name) {
        return planetRepository.findByNameCaseAndDeletedIsFalse(name)
                .orElseThrow(() -> {
                    return new PlanetException(
                            ErrorCodeEnum.API_UNAVAILABLE,
                            ErrorMessages.INTERNAL_SERVER_ERROR,
                            StringUtils.replace(ValidationConstraints.NAME_IS_REQUIRED, "{}", name)
                    );
                });
    }
}
