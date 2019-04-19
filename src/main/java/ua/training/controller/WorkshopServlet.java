package ua.training.controller;

import ua.training.controller.commands.Command;
import ua.training.controller.commands.CommandsInitializer;
import ua.training.model.utils.URIBinder;
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
        commands = CommandsInitializer.getInstance().getCommands();
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
        Command command = commands.getOrDefault(path, (req, resp) -> URIBinder.getProperty("jsp.index"));
        String page = command.execute(request, response);
        if (page.contains("/redirect:")) {
            redirect(request, response, page);
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response,String path) throws IOException {
        String redirectTo = path.replaceAll(".*/redirect:", "");
        response.sendRedirect(request.getContextPath() + redirectTo);
    }
}
