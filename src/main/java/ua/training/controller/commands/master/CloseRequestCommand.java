package ua.training.controller.commands.master;

import ua.training.controller.commands.Command;
import ua.training.model.entity.Request;
import ua.training.model.service.master.MasterService;
import ua.training.model.service.master.MasterServiceImpl;
import ua.training.model.utils.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CloseRequestCommand implements Command {
    private MasterService masterService;

    public CloseRequestCommand() {
        this.masterService = new MasterServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        HttpSession session = httpRequest.getSession();
        Request request = new Request();
        request.setId(Integer.valueOf(httpRequest.getParameter(AttributesBinder.getProperty("parameter.id"))));
        masterService.closeRequest(request);
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.master.bucket");
    }
}
