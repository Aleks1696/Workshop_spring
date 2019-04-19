package ua.training.controller.commands;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The root interface in the command hierarchy. A command represents
 * a group of commands that can be called by users of web application.
 * All child classes should implement single method execute to process
 * further actions.
 *
 * @see "Command design pattern (Gof)"
 */

public interface Command {
    Logger log = Logger.getLogger(Command.class.getName());

    /**
     * Executes command logic.
     *
     * @param request HttpServletRequest that contains all information
     *                related to request a server response
     * @param response HttpServletResponse server response to request
     * @return appropriate jsp page
     * */

    String execute(HttpServletRequest request, HttpServletResponse response);
}
