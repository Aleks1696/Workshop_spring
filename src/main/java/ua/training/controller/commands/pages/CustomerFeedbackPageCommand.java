package ua.training.controller.commands.pages;

import ua.training.controller.commands.Command;
import ua.training.model.utils.AttributesBinder;
import ua.training.model.utils.URIBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.training.model.utils.AttributesBinder.getProperty;

public class CustomerFeedbackPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //TODO delete this code immediately
        int requestId = Integer.valueOf(request.getParameter(getProperty(("parameter.id"))));
        request.setAttribute("id", requestId);
        return URIBinder.getProperty("jsp.customer.feedback");
    }
}
