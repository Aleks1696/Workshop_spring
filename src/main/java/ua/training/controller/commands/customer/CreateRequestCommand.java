package ua.training.controller.commands.customer;

import ua.training.controller.commands.Command;
import ua.training.controller.validation.InputValidation;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;
import ua.training.model.exceptions.AlreadyExistException;
import ua.training.model.service.customer.*;
import ua.training.model.types.RequestStatus;
import ua.training.model.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateRequestCommand implements Command {
    private Mapper<Request> mapper;
    private InputValidation inputValidation;
    private CustomerService customerService;

    public CreateRequestCommand() {
        this.mapper = new RequestMapper();
        this.inputValidation = new InputValidation();
        this.customerService = new CustomerServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        Request request = mapper.extract(req);
        request.setCreationDate(LocalDate.now());
        request.setStatus(RequestStatus.NEW);
        User user = (User) req.getSession().getAttribute(AttributesBinder.getProperty("parameter.user"));
        request.setCustomer_id(user.getId());
        List<String> wrongInputMessages = new ArrayList<>();
        if (!inputValidation.isRequestValid(request, wrongInputMessages)) {
            log.info("Request has invalid data");
            req.setAttribute(AttributesBinder.getProperty("attribute.error.message"),
                    wrongInputMessages);
            return URIBinder.getProperty("path.customer.request");
        }
        try {
            customerService.createRequest(request);
        } catch (AlreadyExistException ex) {
            log.error("Request is already created", ex);
            req.setAttribute(AttributesBinder.getProperty("attribute.error.message"),
                    "input.request.already.exist");
            return URIBinder.getProperty("path.customer.request");
        }
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.customer.account");
    }
}
