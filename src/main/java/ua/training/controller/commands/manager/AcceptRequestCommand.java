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
    private User currentManager;
    private int requestId;
    private String price;
    private String managerComment;

    public AcceptRequestCommand() {
        this.managerService = new ManagerServiceImpl();
        this.inputValidation = new InputValidation();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        getManagerParameters(req);

        List<String> wrongInputMessages = new ArrayList<>();
        if (!inputValidation.isPriceAndDescriptionValid(price, managerComment, wrongInputMessages)) {
            log.info("Specified parameters are not valid");
            req.setAttribute(getProperty("attribute.error.message"),
                    wrongInputMessages);
            return URIBinder.getProperty("path.manager.active.request");
        }
        Request request = new Request();
        setManagerParameters(request);
        managerService.acceptRequest(request);
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.manager.account");
    }

    private void getManagerParameters(HttpServletRequest request) {
        HttpSession session = request.getSession();
        currentManager = (User) session.getAttribute(AttributesBinder.getProperty("parameter.user"));
        requestId = Integer.valueOf(request.getParameter(getProperty(("parameter.id"))));
        price = request.getParameter(getProperty("parameter.price"));
        managerComment = request.getParameter(getProperty("parameter.manager.accept.commentary"));
    }

    private void setManagerParameters(Request request) {
        request.setId(requestId);
        request.setManager_id(currentManager.getId());
        request.setPrice(BigDecimal.valueOf(Double.valueOf(price)));
        request.setManagerComment(managerComment);
        request.setStatus(RequestStatus.ACCEPTED);
    }
}
