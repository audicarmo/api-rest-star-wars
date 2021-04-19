package br.com.api.starwars.constants;

public class ValidationConstraints {

    public static final String NAME_IS_REQUIRED = "Name is required";
    public static final String CLIMATE_IS_REQUIRED = "Climate is required";
    public static final String GROUND_IS_REQUIRED = "Ground is required";
    public static final String DELETED_REQUIRED = "Deleted is required";

    public static final String BAD_REQUEST = "Validation failed";
    public static final String CODE_NOT_FOUND = "Code not found";

    public static final int PLANET_NAME_MIN_SIZE = 2;
    public static final int PLANET_NAME_MAX_SIZE = 30;
    public static final String NAME_SIZE_MUST_BE_BETWEEN = "Name size must be between {min} and {max} characters long";

    public static final String NAME = "name";
    public static final String CLIMATE = "climate";
    public static final String GROUND = "ground";

    private ValidationConstraints() {
    }
}
