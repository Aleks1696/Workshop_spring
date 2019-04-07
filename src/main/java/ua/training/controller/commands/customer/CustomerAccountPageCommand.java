package ua.training.controller.commands.customer;

import ua.training.controller.commands.Command;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;
import ua.training.model.service.customer.CustomerService;
import ua.training.model.service.customer.CustomerServiceImpl;
import ua.training.model.utils.AttributesBinder;
import ua.training.model.utils.URIBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CustomerAccountPageCommand implements Command {
    private CustomerService customerService;

    public CustomerAccountPageCommand() {
        this.customerService = new CustomerServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //TODO is it necessary to check user here after login command?
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(AttributesBinder.getProperty("parameter.user"));
        List<Request> activeRequests = customerService.getActiveRequests(user);
        request.setAttribute(AttributesBinder.getProperty("attribute.active.requests"), activeRequests);
        System.out.println(request.getAttribute(AttributesBinder.getProperty("attribute.active.requests")));
        return URIBinder.getProperty("jsp.customer.account");
    }
}
