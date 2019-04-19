package ua.training.controller.commands.master;

import ua.training.controller.commands.Command;
import ua.training.model.entity.Request;
import ua.training.model.service.master.*;
import ua.training.model.utils.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CloseRequestCommand implements Command {
    private MasterService masterService;

    public CloseRequestCommand() {
        this.masterService = new MasterServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        log.info("Try to close request");
        Request request = new Request();
        request.setId(Integer.valueOf(httpRequest.getParameter(AttributesBinder.getProperty("parameter.id"))));
        try {
            masterService.closeRequest(request);
        } catch (Exception e) {
            log.error("Error closing request", e);
        }
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.master.bucket");
    }
}
