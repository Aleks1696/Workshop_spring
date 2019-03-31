package ua.training.controller.commands;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "WEB-INF/customer/customerAccount.jsp";
    }
}
