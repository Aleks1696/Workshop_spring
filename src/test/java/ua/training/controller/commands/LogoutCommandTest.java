package ua.training.controller.commands;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class LogoutCommandTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;

    @Test
    public void execute() {
        when(request.getSession()).thenReturn(session);
        doNothing().when(session).invalidate();
        LogoutCommand logoutCommand = new LogoutCommand();
        assertEquals("/redirect:/", logoutCommand.execute(request, response));
    }
}