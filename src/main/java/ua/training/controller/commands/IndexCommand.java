package ua.training.controller.commands;

import ua.training.controller.constants.URI;
import javax.servlet.http.HttpServletRequest;

public class IndexCommand implements Command {

    public String execute(HttpServletRequest request) {
        return URI.JSP_INDEX;
    }
}
