package br.com.api.starwars.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static br.com.api.starwars.constants.UrlConstants.URI_PLANET_URL_PATH;
import static br.com.api.starwars.constants.ValidationConstraints.CLIMA;
import static br.com.api.starwars.constants.ValidationConstraints.TERRENO;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlanetController {

    @Override
    @PutMapping(value = URI_PLANET_URL_PATH)
    public ResponseEntity<> updateCampaign(
            @RequestHeader(value = NAME) final String name,
            @RequestHeader(value = CLIMA) final String clima,
            @RequestHeader(value = TERRENO) final String terreno) {

        //TODO
    }
    )
}
