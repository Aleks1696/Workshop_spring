package ua.training.controller.constants;

import java.util.ResourceBundle;

public interface Regex {
    ResourceBundle BUNDLE = ResourceBundle.getBundle("attributes/regex");

    //TODO create powerful regexes
    String LOGIN = BUNDLE.getString("regex.login");
    String PASSWORD = BUNDLE.getString("regex.password");
}
