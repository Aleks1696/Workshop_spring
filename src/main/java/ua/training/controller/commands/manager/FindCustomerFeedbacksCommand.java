package ua.training.controller.commands.manager;

import ua.training.controller.commands.Command;
import ua.training.model.entity.Feedback;
import ua.training.model.service.manager.*;
import ua.training.model.utils.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

import static ua.training.model.utils.AttributesBinder.getProperty;

public class FindCustomerFeedbacksCommand implements Command {
    private ManagerService managerService;
    private int recordsPerPage = 4;
    private int currentPage = 1;
    private int numberOfPages;

    public FindCustomerFeedbacksCommand() {
        this.managerService = new ManagerServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("Try to find customer feedback");
        int customerId = Integer.valueOf(request.getParameter(AttributesBinder.getProperty("parameter.id")));

        getCurrentPage(request);
        int numberOfRows = 0;
        List<Feedback> feedbacks = null;
        try {
            numberOfRows = managerService.getNumberOfCustomerFeedbacks(customerId);
            feedbacks = managerService.getCustomerFeedbacks(customerId, currentPage, recordsPerPage);
        } catch (Exception e) {
            log.error("Error finding customer feedback");
        }
        getNumberOfPages(numberOfRows);
        request.setAttribute(getProperty("attribute.customer.feedbacks"), feedbacks);
        request.setAttribute(getProperty("parameter.request.current.page"), currentPage);
        request.setAttribute(getProperty("parameter.request.number.of.pages"), numberOfPages);
        return URIBinder.getProperty("jsp.manager.customerFeedbacks");
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
