package ua.training.model.utils;

import java.util.ResourceBundle;

public class Binder {

    public static String getProperty(ResourceBundle bundle, String key) {
        return bundle.getString(key);
    }
}
