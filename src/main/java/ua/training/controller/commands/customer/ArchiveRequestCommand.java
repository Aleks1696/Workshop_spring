package ua.training.controller.commands.customer;

import ua.training.controller.commands.Command;
import ua.training.model.entity.Request;
import ua.training.model.service.customer.*;
import ua.training.model.utils.AttributesBinder;
import ua.training.model.utils.URIBinder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ArchiveRequestCommand implements Command {
    private CustomerService customerService;

    public ArchiveRequestCommand() {
        this.customerService = new CustomerServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        log.info("Try to archive request");
        Request request = new Request();
        request.setId(Integer.valueOf(httpRequest.getParameter(AttributesBinder.getProperty("parameter.id"))));
        try {
            customerService.archiveRequest(request);
        } catch (SQLException e) {
            log.error("Failed moving from request table to archive during transaction");
        } catch (Exception e) {
            log.error("Error archiving request");
        }
        return URIBinder.getProperty("redirect") + URIBinder.getProperty("path.customer.notifications");
    }
}
