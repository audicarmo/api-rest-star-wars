package br.com.api.starwars.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCodeEnum {

    API_UNAVAILABLE("SERVICE_UNAVAILABLE");

    private String value;

    ErrorCodeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ErrorCodeEnum fromValue(String text) {
        for (ErrorCodeEnum b : ErrorCodeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
