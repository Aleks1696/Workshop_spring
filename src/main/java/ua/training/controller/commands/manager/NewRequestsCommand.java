package ua.training.controller.commands.manager;

import ua.training.controller.commands.Command;
import ua.training.model.entity.Request;
import ua.training.model.service.manager.ManagerService;
import ua.training.model.service.manager.ManagerServiceImpl;
import ua.training.model.utils.AttributesBinder;
import ua.training.model.utils.URIBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import static ua.training.model.utils.AttributesBinder.getProperty;

public class NewRequestsCommand implements Command {
    private ManagerService managerService;
    //TODO hardcode
    private int recordsPerPage = 4;
    private int currentPage = 1;
    private int numberOfPages;

    public NewRequestsCommand() {
        this.managerService = new ManagerServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        getCurrentPage(request);
        int numberOfRows = managerService.getNumberOfNewRequests();
        List<Request> newRequests = managerService.getNewRequests(currentPage, recordsPerPage);
        getNumberOfPages(numberOfRows);

        request.setAttribute(AttributesBinder.getProperty("attribute.new.requests"), newRequests);
        request.setAttribute(getProperty("parameter.request.current.page"), currentPage);
        request.setAttribute(getProperty("parameter.request.number.of.pages"), numberOfPages);
        //TODO redirect or forward?
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
