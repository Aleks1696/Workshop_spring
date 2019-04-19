package ua.training.controller.commands.pages;

import ua.training.controller.commands.Command;
import ua.training.model.entity.*;
import ua.training.model.service.customer.*;
import ua.training.model.utils.*;
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
        log.info("Try to get customer notification page");
        HttpSession session = request.getSession();
        User currentCustomer = (User) session.getAttribute(AttributesBinder.getProperty("parameter.user"));
        List<Request> accomplishedRequests = null;
        try {
            accomplishedRequests = customerService.getAccomplishedRequests(currentCustomer);
        } catch (Exception e) {
            log.error("Error getting customer notification page");
        }
        request.setAttribute(AttributesBinder.getProperty("attribute.requests.accomplished"), accomplishedRequests);
        return URIBinder.getProperty("jsp.customer.notifications");
    }
}
