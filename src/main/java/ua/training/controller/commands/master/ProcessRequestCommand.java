package ua.training.controller.commands.master;

import ua.training.controller.commands.Command;
import ua.training.model.entity.*;
import ua.training.model.service.master.*;
import ua.training.model.utils.*;
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
        log.info("Try to accept requests by master");
        Request request = new Request();
        setParameters(httpRequest, request);
        try {
            masterService.processRequest(request);
        } catch (Exception e) {
            log.error("Error accepting request by master", e);
        }
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.master.active.request");
    }

    private void setParameters(HttpServletRequest httpRequest, Request request) {
        HttpSession session = httpRequest.getSession();
        request.setId(Integer.valueOf(httpRequest.getParameter(getProperty("parameter.id"))));
        User currentMaster = (User) session.getAttribute(AttributesBinder.getProperty("parameter.user"));
        request.setMaster_id(currentMaster.getId());
    }
}
