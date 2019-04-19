package ua.training.controller.commands.manager;

import ua.training.controller.commands.Command;
import ua.training.controller.validation.InputValidation;
import ua.training.model.entity.User;
import ua.training.model.exceptions.UserNotFoundException;
import ua.training.model.service.manager.*;
import ua.training.model.utils.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ua.training.model.utils.AttributesBinder.getProperty;

public class FindCustomerCommand implements Command {
    private ManagerService managerService;
    private InputValidation inputValidation;

    public FindCustomerCommand() {
        this.managerService = new ManagerServiceImpl();
        this.inputValidation = new InputValidation();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("Try to find customer");
        String customerId = request.getParameter(getProperty("parameter.id"));

        List<String> wrongInputMessages = new ArrayList<>();
        if (!inputValidation.isIdValid(customerId, wrongInputMessages)) {
            request.setAttribute(getProperty("attribute.error.message"),
                    wrongInputMessages);
            log.warn("Wrong customer id format");
            return URIBinder.getProperty("jsp.manager.userInfo");
        }
        Optional<User> user = Optional.ofNullable(getCustomerFromDb(request, customerId));
        user.ifPresent(u -> request.setAttribute(AttributesBinder.getProperty("parameter.customer"), user.get()));
        return URIBinder.getProperty("jsp.manager.userInfo");
    }
    
    private User getCustomerFromDb(HttpServletRequest request, String customerId) {
        User user = null;
        try {
            user = managerService.findCustomerById(customerId);
        } catch (UserNotFoundException ex) {
            request.setAttribute(getProperty("attribute.error.message"),
                    "jsp.userInfo.customer.is.not.found.message");
            log.warn("Customer is not found");
        } catch (Exception e) {
            log.error("Error can not find customer", e);
        }
        return user;
    }
}
