package br.com.api.starwars.entities.swapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwApi {

    private List<SwApiPlanet> results;

    public SwApi(final List<SwApiPlanet> results, final String name) {
        this.results = results;
    }
}
