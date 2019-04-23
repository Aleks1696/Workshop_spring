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
import java.util.Optional;

public class RegistrationCommand implements Command {
    private Mapper<User> mapper;
    private InputValidation inputValidation;
    private UserService userService;

    RegistrationCommand() {
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
            log.warn("Entering system with invalid data");
            request.setAttribute(AttributesBinder.getProperty("attribute.error.message"),
                    wrongInputMessages);
            return URIBinder.getProperty("jsp.registration");
        }
        Optional<User> registeredUser = Optional.ofNullable(registerUser(request, user));
        if (registeredUser.isPresent()) {
            session.setAttribute(AttributesBinder.getProperty("parameter.user"), registeredUser.get());
            ContextUtil.setAttributesToContext(session, user);
            return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.customer.account");
        } else {
            return URIBinder.getProperty("jsp.registration");
        }
    }

    private User registerUser(HttpServletRequest request, User user) {
        User registeredUser = null;
        try {
            registeredUser = userService.createUser(user);
        } catch (AlreadyExistException ex) {
            log.warn("Error registering new user");
            request.setAttribute(AttributesBinder.getProperty("attribute.error.message"),
                    "input.user.already.exist");
        } catch (Exception e) {
            log.error("Error registering new user", e);
        }
        return registeredUser;
    }
}
