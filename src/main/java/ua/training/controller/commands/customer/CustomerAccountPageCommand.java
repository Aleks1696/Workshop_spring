package ua.training.controller.commands.customer;

import ua.training.controller.commands.Command;
import ua.training.model.service.customer.CustomerService;
import ua.training.model.utils.URIBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerAccountPageCommand implements Command {
    private CustomerService customerService;

    public CustomerAccountPageCommand() {
        this.customerService = FACTORY.createCustomerService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return URIBinder.getProperty("jsp.customer.account");
    }
}
