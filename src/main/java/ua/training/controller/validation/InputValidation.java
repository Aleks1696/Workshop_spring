package ua.training.controller.validation;

import ua.training.controller.constants.Regex;

public class InputValidation {

    //TODO it would be better to check and return login, password validation mistake separately
    public boolean isLoginAndPasswordValid(String login, String password) {
        return isLoginValid(login) && isPasswordValid(password);
    }

    public boolean isLoginValid(String login) {
        return login != null && login.matches(Regex.LOGIN);
    }

    public boolean isPasswordValid(String password) {
        return password != null && password.matches(Regex.PASSWORD);
    }

}
