package ua.training.controller.commands.pages;

import ua.training.controller.commands.Command;
import ua.training.model.utils.URIBinder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCustomerPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return URIBinder.getProperty("jsp.manager.userInfo");
    }
}
