package br.com.api.starwars.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwApi {

    private List<SwApiPlanet> results;

    public SwApi(List<SwApiPlanet> results, String name) {
        this.results = results;
    }
}
