package br.com.api.starwars.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Utils {

    public static String decodeParam(String name) {
        try {
            return URLDecoder.decode(name, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}