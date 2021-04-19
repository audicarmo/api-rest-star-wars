package br.com.api.starwars.entities.swapi;

public class SwapiResponse {

    private String id;
    private String name;
    private String climate;
    private Long ground;
    private int response;

    public SwapiResponse(final String id, final String name, final String climate, final Long ground,
                         final int response) {
        this.id = id;
        this.name = name;
        this.climate = climate;
        this.ground = ground;
        this.response = response;
    }
}
