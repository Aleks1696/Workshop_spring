package ua.training.controller.commands.pages;

import ua.training.controller.commands.Command;
import ua.training.model.entity.User;
import ua.training.model.utils.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Optional<User> user =
                Optional.ofNullable((User) session.getAttribute(AttributesBinder.getProperty("parameter.user")));
        return user.map(u -> u.getRole().getBasePath()).orElse(URIBinder.getProperty("jsp.login"));
    }
}
