package ua.training.controller.filter;

import ua.training.model.entity.User;
import ua.training.model.types.UserRole;
import ua.training.model.utils.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String path = request.getServletPath();
        User user = (User) session.getAttribute(AttributesBinder.getProperty("parameter.user"));
        if (user == null) {
            request.setAttribute(AttributesBinder.getProperty("attribute.error.message"),
                    MessagesBinder.getProperty("login.not.logged.user.message"));
            response.sendRedirect(request.getContextPath() + URIBinder.getProperty("path.login"));
        } else if (isRoleAppropriate(user, path)) {
            filterChain.doFilter(request, response);
        } else {
            //TODO 405 access denied
            response.sendRedirect(URIBinder.getProperty("jsp.404"));
        }
    }

    private boolean isRoleAppropriate(User user, String path) {
        UserRole userRole = user.getRole();
        return path.startsWith(userRole.getAllowedPath());
    }

    @Override
    public void destroy() {

    }
}
