package ua.training.controller.constants;

import java.util.ResourceBundle;

public interface Parameters {
    ResourceBundle BUNDLE = ResourceBundle.getBundle("attributes/parameters");

    String PARAMETER_LANGUAGE = BUNDLE.getString("parameter.language");
    String PARAMETER_USER = BUNDLE.getString("parameter.user");
    String PARAMETER_LOGIN = BUNDLE.getString("parameter.login");
    String PARAMETER_PASSWORD = BUNDLE.getString("parameter.password");

    String ATTRIBUTE_WRONG_INPUT = BUNDLE.getString("attribute.wrong_input");





}