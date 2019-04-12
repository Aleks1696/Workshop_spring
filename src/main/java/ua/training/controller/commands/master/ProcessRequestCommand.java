package ua.training.controller.commands.master;

import ua.training.controller.commands.Command;
import ua.training.model.service.master.MasterService;
import ua.training.model.service.master.MasterServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessRequestCommand implements Command {
    private MasterService masterService;

    public ProcessRequestCommand() {
        this.masterService = new MasterServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
