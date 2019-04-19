package ua.training.controller.commands.master;

import ua.training.controller.commands.Command;
import ua.training.model.entity.*;
import ua.training.model.service.master.*;
import ua.training.model.utils.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import static ua.training.model.utils.AttributesBinder.getProperty;

public class GetAcceptedCommand implements Command {
    private MasterService masterService;
    private int recordsPerPage = 4;
    private int currentPage = 1;
    private int numberOfPages;

    public GetAcceptedCommand() {
        this.masterService = new MasterServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("Try to get accepted requests");
        HttpSession session = request.getSession();
        User currentMaster = (User) session.getAttribute(AttributesBinder.getProperty("parameter.user"));

        getCurrentPage(request);
        int numberOfRows = 0;
        List<Request> acceptedRequests = null;
        try {
            numberOfRows = masterService.getNumberOfAcceptedRequests(currentMaster);
            acceptedRequests = masterService.getAcceptedRequests(currentMaster, currentPage, recordsPerPage);
        } catch (Exception e) {
            log.error("Error getting accepted requests", e);
        }
        getNumberOfPages(numberOfRows);
        request.setAttribute(AttributesBinder.getProperty("attribute.requests.in.process"), acceptedRequests);
        request.setAttribute(getProperty("parameter.request.current.page"), currentPage);
        request.setAttribute(getProperty("parameter.request.number.of.pages"), numberOfPages);
        return URIBinder.getProperty("jsp.master.bucket");
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
