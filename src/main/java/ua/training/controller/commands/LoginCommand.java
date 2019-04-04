package ua.training.controller.commands;

import ua.training.controller.validation.InputValidation;
import ua.training.model.entity.User;
import ua.training.model.exceptions.UserNotFoundException;
import ua.training.model.service.user.UserService;
import ua.training.model.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private InputValidation validation;
    private UserService userService;

    public LoginCommand() {
        this.validation = new InputValidation();
        userService = FACTORY.createUserService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String login = request.getParameter(AttributesBinder.getProperty("parameter.login"));
        String password = request.getParameter(AttributesBinder.getProperty("parameter.password"));

        User user = (User) session.getAttribute(AttributesBinder.getProperty("parameter.user"));
        if (user != null) {
            return redirectLoggedUser(request, user);
        }

        if (!validation.isLoginAndPasswordValid(login, password)) {
            request.setAttribute(AttributesBinder.getProperty("attribute.login.error.message"),
                                 "login.not.valid.data");
            log.info("Entering system with invalid data");
            return URIBinder.getProperty("jsp.login");
        }

        user = getUserFromDB(request, login, password);
        if (user != null) {
            return redirectNewUser(request, user);
        }
        return URIBinder.getProperty("jsp.login");
    }

    private User getUserFromDB(HttpServletRequest request, String login, String password) {
        User user = null;
        try {
            user = userService.logInUser(login, password);
        } catch (UserNotFoundException ex) {
            request.setAttribute(AttributesBinder.getProperty("attribute.login.error.message"),
                                "login.user.not.found");
            log.info("User not found");
        }
        return user;
    }

    private String redirectLoggedUser(HttpServletRequest request, User user) {
        String userAccountPath = getPagePathBasedOnRole(user);
        return URIBinder.getProperty("redirect") + userAccountPath;
    }

    private String getPagePathBasedOnRole(User user) {
        return user.getRole().getBasePath();
    }

    private String redirectNewUser(HttpServletRequest request, User user) {
        String userAccountPath = getPagePathBasedOnRole(user);
        request.getSession().setAttribute(AttributesBinder.getProperty("parameter.user"), user);
        return URIBinder.getProperty("redirect") + userAccountPath;
    }
}
