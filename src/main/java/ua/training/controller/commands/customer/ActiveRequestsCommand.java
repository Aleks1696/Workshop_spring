package ua.training.controller.commands.customer;

import ua.training.controller.commands.Command;
import ua.training.model.entity.*;
import ua.training.model.service.customer.*;
import static ua.training.model.utils.AttributesBinder.*;
import ua.training.model.utils.URIBinder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public class ActiveRequestsCommand implements Command {
    private CustomerService customerService;
    //TODO hardcode
    private int recordsPerPage = 4;
    private int currentPage = 1;
    private int numberOfPages;

    public ActiveRequestsCommand() {
        this.customerService = new CustomerServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(getProperty("parameter.user"));

        getCurrentPage(request);
        int numberOfRows = customerService.getNumberOfActiveRequests(user);
        List<Request> activeRequests = customerService.getActiveRequests(user, currentPage, recordsPerPage);
        getNumberOfPages(numberOfRows);

        request.setAttribute(getProperty("attribute.active.requests"), activeRequests);
        request.setAttribute(getProperty("parameter.request.current.page"), currentPage);
        request.setAttribute(getProperty("parameter.request.number.of.pages"), numberOfPages);
        return URIBinder.getProperty("jsp.customer.active.requests");
    }

    private void getCurrentPage(HttpServletRequest request) {
        Optional<String> page = Optional.ofNullable(request.getParameter(getProperty("parameter.request.current.page")));
        currentPage = page.map(Integer::valueOf).orElse(1);
    }

    private void getNumberOfPages(int numberOfRows) {
        numberOfPages = numberOfRows / recordsPerPage;
        if (numberOfRows % recordsPerPage > 0) {
            numberOfPages++;
        }
    }
}
