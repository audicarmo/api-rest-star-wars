package br.com.api.starwars.controllers;

import br.com.api.starwars.configs.SwapiRest;
import br.com.api.starwars.entities.Planet;
import br.com.api.starwars.entities.swapi.SwApiPlanet;
import br.com.api.starwars.entities.swapi.SwapiResponse;
import br.com.api.starwars.repositories.PlanetRepository;
import br.com.api.starwars.services.PlanetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static br.com.api.starwars.constants.UrlConstants.URI_PLANET_CODE;
import static br.com.api.starwars.constants.UrlConstants.URI_PLANET_GET_ALL;
import static br.com.api.starwars.constants.UrlConstants.URI_PLANET_NEW;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/planets")
public class PlanetController {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private Planet planet;

    @Autowired
    private SwapiRest swapiRest;

    private List<SwApiPlanet> result = new ArrayList<>();

    @PostMapping(value = URI_PLANET_NEW)
    public ResponseEntity<Void> createPlanet(@RequestBody final Planet planet, final HttpServletResponse response) {

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(planetService.create(planet).getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = URI_PLANET_GET_ALL)
    public ResponseEntity<List<SwapiResponse>> getAllPlanets() {

        return ResponseEntity.ok().body(searchResults(planetService.getAllPlanets()));
    }

    @GetMapping(value = URI_PLANET_CODE)
    public ResponseEntity<SwapiResponse> getByCode(@PathVariable("id") final String id) {
        Planet planet = planetService.getByCode(id);

        this.result = actionDate(this.result, time);

            return ResponseEntity.ok().body(new SwapiResponse(planet.getById(), planet.getName(),
                 planet.getClimate(), planet.getGround(), getAll(result, planet)));
    }

//    public ResponseEntity<List<SwapiResponse>> getName(@RequestParam(value = "name", defaultValue = ""),
//                                                       String name) {
//        List<SwapiResponse> response = new ArrayList<>();
//
//        this.result = actionDate(this.result, time);
//
//            for(Planet)
    }
}
