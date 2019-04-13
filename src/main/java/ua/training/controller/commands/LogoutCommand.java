package ua.training.controller.commands;

import ua.training.model.entity.User;
import static ua.training.model.utils.AttributesBinder.*;
import ua.training.model.utils.URIBinder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class LogoutCommand implements Command {

    @Override
    @SuppressWarnings("unchecked")
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ServletContext servletContext = session.getServletContext();
        User user = (User) session.getAttribute(getProperty("parameter.user"));
        Map<User, HttpSession> loggedUsers =
                (HashMap<User, HttpSession>)servletContext.getAttribute(getProperty("attribute.servlet.context.logged.users"));
        session.removeAttribute(getProperty("parameter.user"));
        loggedUsers.remove(user);
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.index");
    }
}
