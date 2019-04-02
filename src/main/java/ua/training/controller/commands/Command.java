package ua.training.controller.commands;

import org.apache.log4j.Logger;
import ua.training.model.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public interface Command {
    //TODO see what class will be logged if we don't override logger for every command in constructor
    Logger log = Logger.getLogger(Command.class.getName());
    ServiceFactory FACTORY = ServiceFactory.getInstance();
    String execute(HttpServletRequest request);
}
