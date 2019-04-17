package ua.training.controller.listener;

import ua.training.model.entity.User;
import ua.training.model.utils.AttributesBinder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().addListener(new SessionListener());
        servletContextEvent.getServletContext().setAttribute(
                AttributesBinder.getProperty("attribute.servlet.context.logged.users"),
                new HashMap<User, HttpSession>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
