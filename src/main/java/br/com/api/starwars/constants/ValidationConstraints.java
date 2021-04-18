package br.com.api.starwars.constants;

public class ValidationConstraints {

    public static final String NAME_IS_REQUIRED = "Name is required";
    public static final String CLIMA_IS_REQUIRED = "Clima is required";
    public static final String TERRENO_IS_REQUIRED = "Terreno is required";

    public static final int PLANET_NAME_MIN_SIZE = 2;
    public static final int PLANET_NAME_MAX_SIZE = 30;
    public static final String NAME_SIZE_MUST_BE_BETWEEN = "Name size must be between {min} and {max} characters long";

    public static final String NAME = "name";
    public static final String CLIMA = "clima";
    public static final String TERRENO = "terreno";

    private ValidationConstraints() {
    }
}
