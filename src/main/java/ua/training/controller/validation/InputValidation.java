package ua.training.controller.validation;

import ua.training.controller.constants.Regex;

public class InputValidation {

    public boolean isLoginValid(String login) {
        return login != null && login.matches(Regex.LOGIN);
    }

    public boolean isPasswordValid(String password) {
        return password != null && password.matches(Regex.PASSWORD);
    }

}
