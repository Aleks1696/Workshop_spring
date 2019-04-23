package ua.training.controller.listener;

import ua.training.model.entity.User;
import ua.training.model.utils.AttributesBinder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute("language", "en");
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        User user = (User) session.getAttribute(AttributesBinder.getProperty("parameter.user"));
        ServletContext servletContext = session.getServletContext();
        Map<User, HttpSession> loggedUsers =
                (HashMap<User, HttpSession>) servletContext.getAttribute(
                        AttributesBinder.getProperty("attribute.servlet.context.logged.users"));
        loggedUsers.remove(user);
    }
}
