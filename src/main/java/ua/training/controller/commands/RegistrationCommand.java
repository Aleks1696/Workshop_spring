package ua.training.controller.commands;

import ua.training.controller.validation.InputValidation;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.User;
import ua.training.model.exceptions.UserAlreadyExistException;
import ua.training.model.service.user.*;
import ua.training.model.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        User user = mapper.extract(request);
        System.out.println(request.getSession().getAttribute("language"));
        List<String> wrongInputMessages = new ArrayList<>();
        if (inputValidation.isUserValid(user, wrongInputMessages)) {
            try {
                userService.createUser(user);
            } catch (UserAlreadyExistException e) {
                request.setAttribute(AttributesBinder.getProperty("attribute.error.message"),
                        "input.user.already.exist");
                return URIBinder.getProperty("jsp.registration");
            }
        }
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.customer.account");

    }


}
