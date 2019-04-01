package ua.training.controller.commands;

import org.apache.log4j.Logger;
import ua.training.controller.constants.Parameters;
import ua.training.controller.constants.URI;
import ua.training.controller.validation.InputValidation;

import javax.servlet.http.HttpServletRequest;
public class LoginCommand implements Command {
    private static Logger log;
    private InputValidation validation;

    public LoginCommand() {
        log = Logger.getLogger(LoginCommand.class.getName());
        this.validation = new InputValidation();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);

        if (!validation.isLoginValid(login)) {
            log.info("Accessing user account with wrong login format");
            //TODO change to resource bundle
            request.setAttribute("wrong_input", "Login format is wrong");
            return URI.LOGIN_JSP;
        }

        return "WEB-INF/customer/customerAccount.jsp";
    }
}
