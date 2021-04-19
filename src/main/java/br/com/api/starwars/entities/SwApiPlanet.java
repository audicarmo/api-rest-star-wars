package br.com.api.starwars.entities;

import java.util.List;

public class SwApiPlanet {

    private String name;

    private List<String> play;

    public SwApiPlanet(String name, List<String> play) {
        this.name = name;
        this.play = play;
    }
}
