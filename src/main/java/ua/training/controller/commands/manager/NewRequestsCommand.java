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

public class NewRequestsCommand implements Command {
    private ManagerService managerService;

    public NewRequestsCommand() {
        this.managerService = new ManagerServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List<Request> activeRequests = managerService.getNewRequests();
        request.setAttribute(AttributesBinder.getProperty("attribute.new.requests"), activeRequests);
        //TODO redirect or forward?
        return URIBinder.getProperty("path.manager.account");
    }
}
