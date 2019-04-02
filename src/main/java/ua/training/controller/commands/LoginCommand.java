package ua.training.controller.commands;

import ua.training.controller.constants.*;
import ua.training.controller.validation.InputValidation;
import ua.training.model.entity.User;
import ua.training.model.service.user.UserService;
import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private InputValidation validation;
    private UserService userService;

    public LoginCommand() {
        this.validation = new InputValidation();
        userService = FACTORY.createUserService();
        System.out.println("User service object: " + userService);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(Parameters.PARAMETER_LOGIN);
        String password = request.getParameter(Parameters.PARAMETER_PASSWORD);

        if (!validation.isLoginAndPasswordValid(login, password)) {
            //TODO change attribute to res.bundle
            request.setAttribute(Parameters.ATTRIBUTE_WRONG_INPUT, "Login or password is not valid");
            return URI.JSP_LOGIN;
        }

        User user = userService.logInUser(login, password);
        request.getSession().setAttribute(Parameters.PARAMETER_USER, user);

        return "WEB-INF/customer/customerAccount.jsp";
    }
}
