package ua.training.controller.commands.pages;

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

public class CustomerNotificationPageCommand implements Command {
    private CustomerService customerService;

    public CustomerNotificationPageCommand() {
        this.customerService = new CustomerServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User currentCustomer = (User) session.getAttribute(AttributesBinder.getProperty("parameter.user"));
        List<Request> accomplishedRequests = customerService.getAccomplishedRequests(currentCustomer);
        request.setAttribute(AttributesBinder.getProperty("attribute.requests.accomplished"), accomplishedRequests);
        return URIBinder.getProperty("jsp.customer.notifications");
    }
}
