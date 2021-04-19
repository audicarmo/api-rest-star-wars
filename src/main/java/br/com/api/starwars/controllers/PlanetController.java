package br.com.api.starwars.controllers;

import br.com.api.starwars.entities.Planet;
import br.com.api.starwars.repositories.PlanetRepository;
import br.com.api.starwars.services.PlanetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Optional;

import static br.com.api.starwars.constants.UrlConstants.URI_PLANET;
import static br.com.api.starwars.constants.UrlConstants.URI_PLANET_CODE;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlanetController {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private Planet planet;

    @GetMapping
    public List<Planet> listar() {
        return planetRepository.findAll();
    }

    @SuppressWarnings("checkstyle:HiddenField")
    @PostMapping(value = URI_PLANET)
    public ResponseEntity<Planet> createPlanet(@RequestBody final Planet planet, final HttpServletResponse response) {

        Planet planetSave = planetRepository.save(planet);
            return ResponseEntity.status(HttpStatus.CREATED).body(planetSave);
    }

    @GetMapping(value = URI_PLANET_CODE)
    public ResponseEntity<?> getByCode(@PathVariable final String codigo) {
        Optional<Planet> planet = planetRepository.findById(codigo);
            return planet != null ? ResponseEntity.ok(planet) : ResponseEntity.notFound().build();
    }

    @PutMapping(value = URI_PLANET)
    public ResponseEntity<Planet> updatePlanet(@PathVariable final String codigo, @RequestBody final Planet planet) {

        Planet planetSave = planetService.updatePlanet(codigo, planet);
            return ResponseEntity.ok(planetSave);
    }
}
