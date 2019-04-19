package ua.training.controller.commands;

import ua.training.model.utils.URIBinder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.index");
    }
}
