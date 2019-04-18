package ua.training.controller.commands.manager;

import ua.training.controller.commands.Command;
import ua.training.controller.validation.InputValidation;
import ua.training.model.entity.*;
import ua.training.model.service.manager.*;
import static ua.training.model.utils.AttributesBinder.*;

import ua.training.model.types.RequestStatus;
import ua.training.model.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AcceptRequestCommand implements Command {
    private ManagerService managerService;
    private InputValidation inputValidation;

    public AcceptRequestCommand() {
        this.managerService = new ManagerServiceImpl();
        this.inputValidation = new InputValidation();
    }

    @Override
    public String execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        log.info("Try to accept request");
        String price = httpRequest.getParameter(getProperty("parameter.price"));
        String managerComment = httpRequest.getParameter(getProperty("parameter.manager.accept.commentary"));

        List<String> wrongInputMessages = new ArrayList<>();
        if (!inputValidation.isPriceAndDescriptionValid(price, managerComment, wrongInputMessages)) {
            log.warn("Specified parameters are not valid");
            httpRequest.setAttribute(getProperty("attribute.error.message"),
                    wrongInputMessages);
            return URIBinder.getProperty("path.manager.active.request");
        }

        Request request = new Request();
        request.setPrice(BigDecimal.valueOf(Double.valueOf(price)));
        request.setManagerComment(managerComment);
        setRelatedParameters(httpRequest, request);
        try {
            managerService.acceptRequest(request);
        } catch (Exception e) {
            log.error("Error accepting request", e);
        }
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.manager.active.request");
    }

    private void setRelatedParameters(HttpServletRequest httpRequest, Request request) {
        HttpSession session = httpRequest.getSession();
        request.setId(Integer.valueOf(httpRequest.getParameter(getProperty(("parameter.id")))));
        User currentManager = (User) session.getAttribute(AttributesBinder.getProperty("parameter.user"));
        request.setManager_id(currentManager.getId());
        request.setStatus(RequestStatus.ACCEPTED);
    }
}
