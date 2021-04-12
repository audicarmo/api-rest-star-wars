package br.com.api.starwars.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static br.com.api.starwars.constants.ValidationConstraints.DELETED_REQUIRED;
import static br.com.api.starwars.constants.ValidationConstraints.NAME_IS_REQUIRED;
import static br.com.api.starwars.constants.ValidationConstraints.NAME_SIZE_MUST_BE_BETWEEN;
import static br.com.api.starwars.constants.ValidationConstraints.PLANET_NAME_MAX_SIZE;
import static br.com.api.starwars.constants.ValidationConstraints.PLANET_NAME_MIN_SIZE;

@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity(name = "PLANET")
@DynamicUpdate
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLANET")
    @SequenceGenerator(sequenceName = "SEQ_PLANET", allocationSize = 1, name = "SEQ_PLANET")
    private Integer id;

    @NotBlank(message = NAME_IS_REQUIRED)
    @Size(min = PLANET_NAME_MIN_SIZE, max = PLANET_NAME_MAX_SIZE, message = NAME_SIZE_MUST_BE_BETWEEN)
    @Column(name = "NAME")
    private String name;

    @NotNull(message = DELETED_REQUIRED)
    @Column(name = "DELETED")
    private Boolean deleted = false;

    //TODO Implementar validator "validateIfDeleted"
}
