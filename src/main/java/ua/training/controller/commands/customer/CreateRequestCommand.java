package ua.training.controller.commands.customer;

import ua.training.controller.commands.Command;
import ua.training.controller.validation.InputValidation;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.*;
import ua.training.model.exceptions.AlreadyExistException;
import ua.training.model.service.customer.*;
import ua.training.model.types.RequestStatus;
import ua.training.model.utils.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public String execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        Request request = mapper.extract(httpRequest);
        setParameters(httpRequest, request);

        List<String> wrongInputMessages = new ArrayList<>();
        if (!inputValidation.isCustomerRequestValid(request, wrongInputMessages)) {
            log.warn("Request has invalid data");
            httpRequest.setAttribute(AttributesBinder.getProperty("attribute.error.message"),
                    wrongInputMessages);
            return URIBinder.getProperty("path.customer.request");
        }
        Optional<Request> createdRequest = Optional.ofNullable(createRequest(httpRequest, request));
        if (createdRequest.isPresent()) {
            return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.customer.account");
        } else {
            return URIBinder.getProperty("path.customer.request");
        }
    }

    private void setParameters(HttpServletRequest httpRequest, Request request) {
        request.setCreationDate(LocalDate.now());
        request.setStatus(RequestStatus.NEW);
        User user = (User) httpRequest.getSession().getAttribute(AttributesBinder.getProperty("parameter.user"));
        request.setCustomer_id(user.getId());
    }

    private Request createRequest(HttpServletRequest httpRequest, Request request) {
        Request createdRequest = null;
        try {
            createdRequest = customerService.createRequest(request);
        } catch (AlreadyExistException ex) {
            log.warn("Request is already exist");
            httpRequest.setAttribute(AttributesBinder.getProperty("attribute.error.message"),
                    "input.request.already.exist");
        } catch (Exception e) {
            log.error("Error creating request", e);
            httpRequest.setAttribute(AttributesBinder.getProperty("attribute.error.message"),
                    "input.request.can.not.create.request");
        }
        return createdRequest;
    }
}
