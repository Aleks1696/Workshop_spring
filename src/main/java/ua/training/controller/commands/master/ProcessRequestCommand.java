package ua.training.controller.commands.master;

import ua.training.controller.commands.Command;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;
import ua.training.model.service.master.MasterService;
import ua.training.model.service.master.MasterServiceImpl;
import ua.training.model.types.RequestStatus;
import ua.training.model.utils.AttributesBinder;
import ua.training.model.utils.URIBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static ua.training.model.utils.AttributesBinder.getProperty;

public class ProcessRequestCommand implements Command {
    private MasterService masterService;

    public ProcessRequestCommand() {
        this.masterService = new MasterServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        Request request = new Request();
        setRelatedParameters(httpRequest, request);
        masterService.processRequest(request);
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.master.active.request");
    }

    private void setRelatedParameters(HttpServletRequest httpRequest, Request request) {
        HttpSession session = httpRequest.getSession();
        request.setId(Integer.valueOf(httpRequest.getParameter(getProperty(("parameter.id")))));
        User currentMaster = (User) session.getAttribute(AttributesBinder.getProperty("parameter.user"));
        request.setMaster_id(currentMaster.getId());
        request.setStatus(RequestStatus.IN_PROCESS);
    }
}
