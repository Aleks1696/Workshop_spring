package ua.training.controller;

import ua.training.controller.commands.Command;
import ua.training.controller.constants.URI;
import ua.training.controller.utils.CommandsInitializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "WorkshopServlet", urlPatterns = "/")
public class WorkshopServlet extends HttpServlet {
    private Map<String, Command> commands;

    @Override
    public void init() throws ServletException {
        commands = CommandsInitializer.getCommands();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processUser(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processUser(request, response);
    }

    private void processUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        Command command = commands.getOrDefault(path, c -> URI.JSP_INDEX);
        String page = command.execute(request);
        request.getRequestDispatcher(page).forward(request, response);
    }
}
