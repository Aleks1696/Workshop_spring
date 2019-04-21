package ua.training.controller.utils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.powermock.modules.junit4.PowerMockRunner;
import ua.training.model.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class ContextUtilTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private ServletContext context;

    private User user;
    private Map<User, HttpSession> loggedUsers;

    @Before
    public void initialize() {
        user = new User();
        loggedUsers = new HashMap<>();
    }

    @Test
    public void isUserInContextPositive() {
        loggedUsers.put(user, session);
        context.setAttribute("logged_users", loggedUsers);
        when(session.getServletContext()).thenReturn(context);
        when(session.getServletContext().getAttribute(anyString())).thenReturn(loggedUsers);
        assertTrue(ContextUtil.isUserInContext(session, user));
    }

    @Test
    public void isUserInContextNegative() {
        context.setAttribute("logged_users", loggedUsers);
        when(session.getServletContext()).thenReturn(context);
        when(session.getServletContext().getAttribute(anyString())).thenReturn(loggedUsers);
        assertFalse(ContextUtil.isUserInContext(session, user));
    }

    @Test
    public void setAttributesToContext() {
        context.setAttribute("logged_users", loggedUsers);
        when(session.getServletContext()).thenReturn(context);
        when(session.getServletContext().getAttribute(anyString())).thenReturn(loggedUsers);
        ContextUtil.setAttributesToContext(session, user);
        HashMap<User, HttpSession> fromContext = (HashMap<User, HttpSession>) context.getAttribute(anyString());
        assertEquals(loggedUsers, fromContext);
    }
}