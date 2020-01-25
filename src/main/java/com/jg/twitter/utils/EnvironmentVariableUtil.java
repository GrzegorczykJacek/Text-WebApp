package com.jg.twitter.utils;

public class EnvironmentVariableUtil {

    public static String getVariable(String key) {
        return System.getenv(key.replace(".", "_")); // replaces dots to underlines for system env purpouse, variable name cannot contain dots
    }

}
