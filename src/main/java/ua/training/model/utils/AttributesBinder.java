package ua.training.model.utils;

import java.util.ResourceBundle;

public class AttributesBinder {
    private static ResourceBundle bundle = ResourceBundle.getBundle("attributes/attributes");

    public static String getProperty(String key) {
        return Binder.getProperty(bundle, key);
    }
}
