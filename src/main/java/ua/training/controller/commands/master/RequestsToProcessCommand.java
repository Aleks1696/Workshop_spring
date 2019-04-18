package ua.training.controller.commands.master;

import ua.training.controller.commands.Command;
import ua.training.model.entity.Request;
import ua.training.model.service.master.*;
import ua.training.model.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import static ua.training.model.utils.AttributesBinder.getProperty;

public class RequestsToProcessCommand implements Command {
    private MasterService masterService;
    private int recordsPerPage = 4;
    private int currentPage = 1;
    private int numberOfPages;

    public RequestsToProcessCommand() {
        this.masterService = new MasterServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("Try to get requests to precess");
        HttpSession session = request.getSession();

        getCurrentPage(request);
        int numberOfRows = 0;
        List<Request> requestsToProcess = null;
        try {
            numberOfRows = masterService.getNumberOfRequestsToProcess();
            requestsToProcess = masterService.getRequestsToProcess(currentPage, recordsPerPage);
        } catch (Exception e) {
            log.error("Error getting requests to precess", e);
        }
        getNumberOfPages(numberOfRows);
        request.setAttribute(getProperty("attribute.requests.to.process"), requestsToProcess);
        request.setAttribute(getProperty("parameter.request.current.page"), currentPage);
        request.setAttribute(getProperty("parameter.request.number.of.pages"), numberOfPages);
        return URIBinder.getProperty("jsp.master.requestsToProcess");
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
