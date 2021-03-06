package br.com.api.starwars.controllers;

import br.com.api.starwars.configs.SwapiRest;
import br.com.api.starwars.entities.Planet;
import br.com.api.starwars.entities.swapi.SwApiPlanet;
import br.com.api.starwars.entities.swapi.SwapiResponse;
import br.com.api.starwars.repositories.PlanetRepository;
import br.com.api.starwars.services.PlanetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static br.com.api.starwars.constants.UrlConstants.URI_PLANET_CODE;
import static br.com.api.starwars.constants.UrlConstants.URI_PLANET_GET_ALL;

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

    private SwApiPlanet swApiPlanet;

    private List<SwApiPlanet> result = new ArrayList<>();

    private Calendar actual = Calendar.getInstance();

    @GetMapping(value = URI_PLANET_GET_ALL)
    public ResponseEntity<List<SwapiResponse>> getAllPlanets() {
        return ResponseEntity.ok().body(searchResults(planet.getId()));
    }

    @GetMapping(value = URI_PLANET_CODE)
    public ResponseEntity<SwapiResponse> getByCode(@PathVariable("id") final String id, Calendar time)
            throws IOException {
        Planet planet = planetService.getByCode(id);
            this.result = actionDate(this.result, time);

        return ResponseEntity.ok().body(new SwapiResponse(planet.getId(), planet.getName(),
                 planet.getClimate(), planet.getGround(), getAll(result, planet)));
    }

    @GetMapping(value = "/urlName")
    public ResponseEntity<List<SwapiResponse>> getName(String name, Calendar time) throws IOException {
        List<SwapiResponse> response = new ArrayList<>();
        this.result = actionDate(this.result, time);
            return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePlanet(@PathVariable final String id) {
        planetService.delete(id);
        return ResponseEntity.noContent().build();
    }

    public List<SwapiResponse> searchResults(List<Planet> planets, Calendar time) throws IOException {
        List<SwapiResponse> response = new ArrayList<>();
        this.result = actionDate(this.result, time);
            for (Planet planet : planets) {
                response.add(new SwapiResponse(planet.getId(), planet.getName(), planet.getClimate(),
                        planet.getGround(), getAll(result, planet)));
            }
            return  response;
    }

    private int getAll(List<SwApiPlanet> result, Planet planet) {
        for (SwApiPlanet swApiPlanet : result) {
            if (planet.getName().equals(swApiPlanet.getName())) {
                return swApiPlanet.getPlay().size();
            }
        }
        return 0;
    }

    private List<SwApiPlanet> actionDate(List<SwApiPlanet> result, Calendar time) throws IOException {
        Calendar atual = Calendar.getInstance();
        Calendar timeNow = (Calendar) time.clone();
        timeNow.add(Calendar.HOUR_OF_DAY, 1);
            if (actual.after(timeNow)) {
                result = swapiRest.getPlanets().getBody().getResults();
                time = Calendar.getInstance();
        }
        return result;
    }
}
