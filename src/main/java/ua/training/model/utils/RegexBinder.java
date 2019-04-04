package ua.training.model.utils;

import java.util.ResourceBundle;

public class RegexBinder {
    private static ResourceBundle bundle = ResourceBundle.getBundle("attributes/regex");

    public static String getProperty(String key) {
        return Binder.getProperty(bundle, key);
    }
}
