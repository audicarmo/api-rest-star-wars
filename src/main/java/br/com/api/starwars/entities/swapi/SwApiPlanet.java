package br.com.api.starwars.entities.swapi;

import java.util.List;

public class SwApiPlanet {

    private String name;

    private List<String> play;

    public SwApiPlanet(final String name, final List<String> play) {
        this.name = name;
        this.play = play;
    }
}
