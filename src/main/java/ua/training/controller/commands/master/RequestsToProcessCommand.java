package ua.training.controller.commands.master;

import ua.training.controller.commands.Command;
import ua.training.model.entity.Request;
import ua.training.model.service.master.*;
import ua.training.model.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class RequestsToProcessCommand implements Command {
    private MasterService masterService;

    public RequestsToProcessCommand() {
        this.masterService = new MasterServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List<Request> requestsToProcess = masterService.getRequestsToProcess();
        request.setAttribute(AttributesBinder.getProperty("attribute.requests.to.process"), requestsToProcess);
        return URIBinder.getProperty("path.master.account");
    }
}
