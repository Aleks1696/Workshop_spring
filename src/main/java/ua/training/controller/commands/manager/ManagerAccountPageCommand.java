package ua.training.controller.commands.manager;

import ua.training.controller.commands.Command;
import ua.training.model.service.manager.ManagerService;
import ua.training.model.utils.URIBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerAccountPageCommand implements Command {
    private ManagerService managerService;

    public ManagerAccountPageCommand() {
        this.managerService = FACTORY.createManagerService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return URIBinder.getProperty("jsp.manager.account");
    }
}
