package ua.training.controller.commands;

import static ua.training.controller.utils.ContextUtil.*;
import ua.training.controller.validation.InputValidation;
import ua.training.model.entity.User;
import ua.training.model.exceptions.UserNotFoundException;
import ua.training.model.service.user.*;
import ua.training.model.utils.URIBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import static ua.training.model.utils.AttributesBinder.getProperty;

public class LoginCommand implements Command {
    private InputValidation validation;
    private UserService userService;

    public LoginCommand() {
        this.validation = new InputValidation();
        userService = new UserServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String login = request.getParameter(getProperty("parameter.login"));
        String password = request.getParameter(getProperty("parameter.password"));

        List<String> wrongInputMessages = new ArrayList<>();
        if (!validation.isLoginAndPasswordValid(login, password, wrongInputMessages)) {
            request.setAttribute(getProperty("attribute.error.message"),
                                 wrongInputMessages);
            log.info("Entering system with invalid data");
            return URIBinder.getProperty("jsp.login");
        }

        Optional<User> user = Optional.ofNullable(getUserFromDB(request, login, password));
        if (!user.isPresent()) {
            return URIBinder.getProperty("jsp.login");
        } else if (isUserInContext(session, user.get())) {
            logoutUser(user.get());
        }
        return redirectNewUser(request, user.get());
    }

    private User getUserFromDB(HttpServletRequest request, String login, String password) {
        User user = null;
        try {
            user = userService.logInUser(login, password);
        } catch (UserNotFoundException ex) {
            request.setAttribute(getProperty("attribute.error.message"),
                                "login.user.not.found");
            log.info("User is not found");
        }
        return user;
    }

    private String getPagePathBasedOnRole(User user) {
        return user.getRole().getBasePath();
    }

    private String redirectNewUser(HttpServletRequest request, User user) {
        String userAccountPath = getPagePathBasedOnRole(user);
        setUserAttributes(request, user);
        return URIBinder.getProperty("redirect") + userAccountPath;
    }

    private void setUserAttributes(HttpServletRequest request, User user) {
        request.getSession().setAttribute(getProperty("parameter.user"), user);
        setAttributesToContext(request.getSession(), user);
    }
}
