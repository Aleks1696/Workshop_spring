package ua.training.model.utils;

import java.util.ResourceBundle;

public class MessagesBinder {
    private static ResourceBundle bundle = ResourceBundle.getBundle("messages");

    public static String getProperty(String key) {
        return Binder.getProperty(bundle, key);
    }
}
