package ua.training.model.utils;

import java.util.ResourceBundle;

public class QueriesBinder {
    private static ResourceBundle bundle = ResourceBundle.getBundle("database/queries");

    public static String getProperty(String key) {
        return Binder.getProperty(bundle, key);
    }
}
