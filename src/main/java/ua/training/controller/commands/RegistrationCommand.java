package ua.training.controller.commands;

import ua.training.controller.utils.ContextUtil;
import ua.training.controller.validation.InputValidation;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.User;
import ua.training.model.exceptions.AlreadyExistException;
import ua.training.model.service.user.*;
import ua.training.model.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class RegistrationCommand implements Command {
    private Mapper<User> mapper;
    private InputValidation inputValidation;
    private UserService userService;

    public RegistrationCommand() {
        this.mapper = new UserMapper();
        this.inputValidation = new InputValidation();
        this.userService = new UserServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("Try to register new user");
        HttpSession session = request.getSession();
        User user = mapper.extract(request);

        List<String> wrongInputMessages = new ArrayList<>();
        if (!inputValidation.isUserValid(user, wrongInputMessages)) {
            request.setAttribute(AttributesBinder.getProperty("attribute.error.message"),
                    wrongInputMessages);
            return URIBinder.getProperty("jsp.registration");
        }
        try {
            user = userService.createUser(user);
        } catch (AlreadyExistException ex) {
            log.warn("Error registering new user");
            request.setAttribute(AttributesBinder.getProperty("attribute.error.message"),
                    "input.user.already.exist");
            return URIBinder.getProperty("jsp.registration");
        } catch (Exception e) {
            log.error("Error registering new user", e);
            return URIBinder.getProperty("jsp.registration");
        }
        session.setAttribute(AttributesBinder.getProperty("parameter.user"), user);
        ContextUtil.setAttributesToContext(session, user);
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.customer.account");
    }
}
