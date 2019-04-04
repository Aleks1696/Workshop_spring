package ua.training.controller.commands.customer;

import ua.training.controller.commands.Command;
import ua.training.controller.validation.InputValidation;
import ua.training.model.service.customer.CustomerService;
import ua.training.model.utils.URIBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerAccountPageCommand implements Command {
    private InputValidation inputValidation;
    private CustomerService customerService;

    public CustomerAccountPageCommand() {
        this.inputValidation = new InputValidation();
        this.customerService = FACTORY.createCustomerService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return URIBinder.getProperty("jsp.customer.account");
    }
}
