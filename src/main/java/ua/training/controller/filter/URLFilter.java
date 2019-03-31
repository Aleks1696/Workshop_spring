package ua.training.controller.filter;

import ua.training.controller.constants.URL;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "URLFilter")
public class URLFilter implements Filter {
    private List<String> allowedURLs = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        allowedURLs.add("/index.jsp");
        allowedURLs.add("/login.jsp");
        allowedURLs.add("/registration.jsp");
        allowedURLs.add("/login");
        allowedURLs.add("/language/ua");
        allowedURLs.add("/customer");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        System.out.println("--------------------------------------");
        System.out.println("Context path: " + request.getContextPath());
        System.out.println("Servlet path: " + request.getServletPath());
        System.out.println("Request url: " + request.getRequestURL());
        System.out.println("Request uri: " + request.getRequestURI());
        System.out.println("--------------------------------------");

        String path = request.getServletPath();
        //TODO can be broken if url is: .../login.jsp/hack...
        if (allowedURLs.contains(path)) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + URL.INDEX_JSP);
        }
    }

    @Override
    public void destroy() {

    }
}
