package ua.training.controller.utils;

import ua.training.model.entity.User;
import static ua.training.model.utils.AttributesBinder.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AccessUtil {
    private static Map<User, HttpSession> loggedUsers;

    @SuppressWarnings("unchecked")
    public static boolean isUserInContext(HttpSession session, User user) {
        ServletContext context = session.getServletContext();
        loggedUsers = (HashMap<User, HttpSession>)context.getAttribute(
                getProperty("attribute.servlet.context.logged.users"));
        if (loggedUsers == null) {
            loggedUsers = new HashMap<>();
            context.setAttribute(getProperty("attribute.servlet.context.logged.users"), loggedUsers);
            return false;
        } else {
            return loggedUsers.keySet().contains(user);
        }
    }

    public static void logoutUser(User user) {
        HttpSession oldSession = loggedUsers.get(user);
        oldSession.removeAttribute(getProperty("parameter.user"));
        loggedUsers.remove(user);
    }

    public static void setAttributesToContext(HttpSession session, User user) {
        loggedUsers.put(user, session);
    }
}
