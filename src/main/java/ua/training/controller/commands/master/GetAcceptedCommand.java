package ua.training.controller.commands.master;

import ua.training.controller.commands.Command;
import ua.training.model.entity.*;
import ua.training.model.service.master.*;
import ua.training.model.utils.AttributesBinder;
import ua.training.model.utils.URIBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetAcceptedCommand implements Command {
    private MasterService masterService;

    public GetAcceptedCommand() {
        this.masterService = new MasterServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User currentMaster = (User) session.getAttribute(AttributesBinder.getProperty("parameter.user"));
        List<Request> acceptedRequests = masterService.getAcceptedRequests(currentMaster);
        request.setAttribute(AttributesBinder.getProperty("attribute.requests.in.process"), acceptedRequests);
        return URIBinder.getProperty("jsp.master.bucket");
    }
}
