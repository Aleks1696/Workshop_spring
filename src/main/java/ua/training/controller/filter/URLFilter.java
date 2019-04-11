package ua.training.controller.filter;

import ua.training.controller.commands.CommandsInitializer;
import ua.training.model.utils.URIBinder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebFilter(filterName = "URLFilter")
public class URLFilter implements Filter {
    private Set<String> allowedURIs;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        allowedURIs = CommandsInitializer.getInstance().getCommands().keySet();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getServletPath();
        if (allowedURIs.contains(path)) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(URIBinder.getProperty("jsp.404"));
        }
    }

    @Override
    public void destroy() {

    }
}
