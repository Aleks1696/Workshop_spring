package ua.training.model.constants;

import java.util.ResourceBundle;

public interface Queries {
    ResourceBundle BUNDLE = ResourceBundle.getBundle("database/queries");

    String FIND_BY_LOGIN_AND_PASSWORD = BUNDLE.getString("user.findBy.loginAndPassword");


}
