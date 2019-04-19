package ua.training.controller.commands.manager;

import ua.training.controller.commands.Command;
import ua.training.model.entity.Request;
import ua.training.model.service.manager.*;
import ua.training.model.utils.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

import static ua.training.model.utils.AttributesBinder.getProperty;

public class NewRequestsCommand implements Command {
    private ManagerService managerService;
    private int recordsPerPage = 4;
    private int currentPage = 1;
    private int numberOfPages;

    public NewRequestsCommand() {
        this.managerService = new ManagerServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("Try to get new requests");

        getCurrentPage(request);
        int numberOfRows;
        List<Request> newRequests;
        try {
            numberOfRows = managerService.getNumberOfNewRequests();
            newRequests = managerService.getNewRequests(currentPage, recordsPerPage);
        } catch (Exception e) {
            log.error("Error getting new requests", e);
            return URIBinder.getProperty("jsp.manager.new.requests");
        }
        getNumberOfPages(numberOfRows);

        request.setAttribute(AttributesBinder.getProperty("attribute.new.requests"), newRequests);
        request.setAttribute(getProperty("parameter.request.current.page"), currentPage);
        request.setAttribute(getProperty("parameter.request.number.of.pages"), numberOfPages);
        return URIBinder.getProperty("jsp.manager.new.requests");
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
