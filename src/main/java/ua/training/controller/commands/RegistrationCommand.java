package ua.training.controller.commands;

import ua.training.controller.constants.URI;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return URI.REGISTRATION_JSP;
    }
}
