package ua.training.controller.commands.customer;

import ua.training.controller.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CancelRequestCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
