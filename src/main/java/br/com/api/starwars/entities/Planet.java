package br.com.api.starwars.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static br.com.api.starwars.constants.ValidationConstraints.CLIMA_IS_REQUIRED;
import static br.com.api.starwars.constants.ValidationConstraints.NAME_IS_REQUIRED;
import static br.com.api.starwars.constants.ValidationConstraints.NAME_SIZE_MUST_BE_BETWEEN;
import static br.com.api.starwars.constants.ValidationConstraints.PLANET_NAME_MAX_SIZE;
import static br.com.api.starwars.constants.ValidationConstraints.PLANET_NAME_MIN_SIZE;
import static br.com.api.starwars.constants.ValidationConstraints.TERRENO_IS_REQUIRED;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Planet {

    private Integer id;

    @NotBlank(message = NAME_IS_REQUIRED)
    @Size(min = PLANET_NAME_MIN_SIZE, max = PLANET_NAME_MAX_SIZE, message = NAME_SIZE_MUST_BE_BETWEEN)
    private String name;

    @NotBlank(message = CLIMA_IS_REQUIRED)
    private String clima;

    @NotBlank(message = TERRENO_IS_REQUIRED)
    private Long terreno;
}
