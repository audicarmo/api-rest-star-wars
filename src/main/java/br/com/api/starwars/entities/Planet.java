package br.com.api.starwars.entities;

import br.com.api.starwars.enums.ErrorCodeEnum;
import br.com.api.starwars.enums.ErrorMessages;
import br.com.api.starwars.exceptions.PlanetException;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static br.com.api.starwars.constants.ValidationConstraints.CLIMATE_IS_REQUIRED;
import static br.com.api.starwars.constants.ValidationConstraints.DELETED_REQUIRED;
import static br.com.api.starwars.constants.ValidationConstraints.GROUND_IS_REQUIRED;
import static br.com.api.starwars.constants.ValidationConstraints.NAME_IS_REQUIRED;
import static br.com.api.starwars.constants.ValidationConstraints.NAME_SIZE_MUST_BE_BETWEEN;
import static br.com.api.starwars.constants.ValidationConstraints.PLANET_NAME_MAX_SIZE;
import static br.com.api.starwars.constants.ValidationConstraints.PLANET_NAME_MIN_SIZE;

@Slf4j
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
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

    @NotNull(message = DELETED_REQUIRED)
    private Boolean deleted = false;

    public Planet(@NotBlank final String name, @NotBlank final String climate, @NotBlank final Long ground) {
        super();
        this.name = name;
        this.climate = climate;
        this.ground = ground;
    }

    public void validateIfDeleted() {
        if ((Boolean.TRUE.equals(getDeleted()))) {

            throw new PlanetException(ErrorCodeEnum.API_UNAVAILABLE, ErrorMessages.INTERNAL_SERVER_ERROR,
                    StringUtils.replace(DELETED_REQUIRED, "{}", id));
        }
    }
}
