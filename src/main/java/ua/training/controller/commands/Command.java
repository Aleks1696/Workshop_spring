package ua.training.controller.commands;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    //TODO see what class will be logged if we don't override logger for every command in constructor
    Logger log = Logger.getLogger(Command.class.getName());

    String execute(HttpServletRequest request, HttpServletResponse response);
}
