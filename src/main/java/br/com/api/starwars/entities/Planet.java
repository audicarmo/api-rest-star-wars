package br.com.api.starwars.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static br.com.api.starwars.constants.ValidationConstraints.CLIMATE_IS_REQUIRED;
import static br.com.api.starwars.constants.ValidationConstraints.GROUND_IS_REQUIRED;
import static br.com.api.starwars.constants.ValidationConstraints.NAME_IS_REQUIRED;
import static br.com.api.starwars.constants.ValidationConstraints.NAME_SIZE_MUST_BE_BETWEEN;
import static br.com.api.starwars.constants.ValidationConstraints.PLANET_NAME_MAX_SIZE;
import static br.com.api.starwars.constants.ValidationConstraints.PLANET_NAME_MIN_SIZE;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Planet {

    @Id
    private String id;

    @NotBlank(message = NAME_IS_REQUIRED)
    @JsonProperty(required = true)
    @Size(min = PLANET_NAME_MIN_SIZE, max = PLANET_NAME_MAX_SIZE, message = NAME_SIZE_MUST_BE_BETWEEN)
    private String name;

    @NotBlank(message = CLIMATE_IS_REQUIRED)
    private String climate;

    @NotBlank(message = GROUND_IS_REQUIRED)
    private Long ground;

    public Planet(@NotBlank final String name, @NotBlank final String climate, @NotBlank final Long ground) {
        super();
        this.name = name;
        this.climate = climate;
        this.ground = ground;
    }
}
