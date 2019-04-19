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
        log.info("Try to leave feedback");
        Feedback feedback = new Feedback();
        Request request = new Request();
        setRelatedParameters(httpRequest, feedback, request);

        List<String> wrongInputMessages = new ArrayList<>();
        if (!inputValidation.isFeedbackValid(feedback, wrongInputMessages)) {
            log.warn("Request has invalid data");
            httpRequest.setAttribute(AttributesBinder.getProperty("attribute.error.message"),
                    wrongInputMessages);
            return URIBinder.getProperty("path.customer.notifications");
        }
        createFeedback(request, feedback);
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.customer.notifications");
    }

    private void setRelatedParameters(HttpServletRequest httpRequest, Feedback feedback, Request request) {
        feedback.setMark(Marks.valueOf(httpRequest.getParameter(AttributesBinder.getProperty("parameter.mark"))));
        feedback.setCommentary(httpRequest.getParameter(AttributesBinder.getProperty("parameter.commentary")));
        request.setId(Integer.valueOf(httpRequest.getParameter(AttributesBinder.getProperty("parameter.id"))));
    }

    private Feedback createFeedback(Request request, Feedback feedback) {
        Feedback createdFeedback = null;
        try {
            createdFeedback = customerService.leaveFeedback(feedback, request);
            customerService.archiveRequest(request);
        } catch (SQLException e) {
            log.error("Failed creating feedback and updating foreign key in request table during transaction", e);
        } catch (Exception e) {
            log.error("Error leaving feedback", e);
        }
        return createdFeedback;
    }
}
