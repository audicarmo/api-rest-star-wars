package br.com.api.starwars.configs;

import br.com.api.starwars.constants.ValidationConstraints;
import br.com.api.starwars.entities.swapi.SwApi;
import br.com.api.starwars.enums.ErrorCodeEnum;
import br.com.api.starwars.enums.ErrorMessages;
import br.com.api.starwars.exceptions.PlanetException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class SwapiRest {

    public static final String URL = "https://swapi.co/api/planets/";

    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<SwApi> getPlanets() {
        try {
            return restTemplate.exchange(URL, HttpMethod.GET, response(), SwApi.class);
        } catch (Exception e) {
            throw new PlanetException(
                    ErrorCodeEnum.API_UNAVAILABLE,
                    ErrorMessages.INTERNAL_SERVER_ERROR,
                    ValidationConstraints.BAD_REQUEST
            );
        }

    }

    public HttpEntity<String> response() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        return entity;
    }
}
