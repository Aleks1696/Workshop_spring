package ua.training.controller.commands.customer;

import ua.training.controller.commands.Command;
import ua.training.controller.validation.InputValidation;
import ua.training.model.entity.*;
import ua.training.model.service.customer.*;
import ua.training.model.types.Marks;
import ua.training.model.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaveFeedbackCommand implements Command {
    private CustomerService customerService;
    private InputValidation inputValidation;

    public LeaveFeedbackCommand() {
        this.customerService = new CustomerServiceImpl();
        this.inputValidation = new InputValidation();
    }

    @Override
    public String execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        Feedback feedback = new Feedback();
        Request request = new Request();
        setRelatedParameters(httpRequest, feedback, request);

        List<String> wrongInputMessages = new ArrayList<>();
        if (!inputValidation.isFeedbackValid(feedback, wrongInputMessages)) {
            log.info("Request has invalid data");
            httpRequest.setAttribute(AttributesBinder.getProperty("attribute.error.message"),
                    wrongInputMessages);
            return URIBinder.getProperty("path.customer.feedback");
        }

        try {
            customerService.leaveFeedback(feedback, request);
            customerService.archiveRequest(request);
        } catch (SQLException e) {
            log.error("Failed creating feedback and updating foreign key in request table during transaction");
            e.printStackTrace();
        }
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.customer.notifications");
    }

    private void setRelatedParameters(HttpServletRequest httpRequest, Feedback feedback, Request request) {
        feedback.setMark(Marks.valueOf(httpRequest.getParameter(AttributesBinder.getProperty("parameter.rating"))));
        feedback.setCommentary(httpRequest.getParameter(AttributesBinder.getProperty("parameter.commentary")));
        request.setId(Integer.valueOf(httpRequest.getParameter(AttributesBinder.getProperty("parameter.id"))));
    }
}
