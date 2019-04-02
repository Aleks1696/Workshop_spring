package ua.training.controller.constants;

import java.util.ResourceBundle;

public interface URI {
    ResourceBundle BUNDLE = ResourceBundle.getBundle("attributes/uri");

    String JSP_INDEX = BUNDLE.getString("jsp.index");
    String JSP_LOGIN = BUNDLE.getString("jsp.login");
    String JSP_REGISTRATION = BUNDLE.getString("jsp.registration");

    String PATH_LOGIN = BUNDLE.getString("path.login");
    String PATH_REGISTRATION = BUNDLE.getString("path.registration");
}

