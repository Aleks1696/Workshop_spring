package ua.training.controller.commands.master;

import ua.training.controller.commands.Command;
import ua.training.model.service.master.MasterService;
import ua.training.model.utils.URIBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterAccountPageCommand implements Command {
    private MasterService masterService;

    public MasterAccountPageCommand() {
        this.masterService = FACTORY.createMasterService();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return URIBinder.getProperty("jsp.master.account");
    }
}
