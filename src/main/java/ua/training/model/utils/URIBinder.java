package ua.training.model.utils;

import java.util.ResourceBundle;

public class URIBinder {
    private static ResourceBundle bundle = ResourceBundle.getBundle("attributes/uri");

    public static String getProperty(String key) {
        return Binder.getProperty(bundle, key);
    }
}
