package ua.training.controller.commands;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    Logger log = Logger.getLogger(Command.class.getName());

    String execute(HttpServletRequest request, HttpServletResponse response);
}
