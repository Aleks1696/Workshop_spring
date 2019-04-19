package ua.training.controller.commands;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import ua.training.controller.utils.ContextUtil;
import ua.training.controller.validation.InputValidation;
import ua.training.model.entity.User;
import ua.training.model.exceptions.UserNotFoundException;
import ua.training.model.service.user.UserService;
import ua.training.model.types.UserRole;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ContextUtil.class)
public class LoginCommandTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private UserService userService;
    @InjectMocks
    private LoginCommand loginCommand;

    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
        when(request.getParameter("login")).thenReturn("anna");
        when(request.getParameter("password")).thenReturn("12anna");
        when(request.getSession()).thenReturn(session);
        PowerMockito.mockStatic(ContextUtil.class);
    }

    @Test
    public void executePositive() {
        User user = new User();
        user.setRole(UserRole.CUSTOMER);
        when(userService.logInUser("anna", "12anna")).thenReturn(user);
        when(ContextUtil.isUserInContext(session, user)).thenReturn(false);
        assertEquals("/redirect:/customer/account", loginCommand.execute(request, response));
    }

    @Test
    public void executeNegativeUserIsNotFound() {
        when(userService.logInUser("anna", "12anna")).thenReturn(null);
        when(ContextUtil.isUserInContext(session, new User())).thenReturn(false);
        assertEquals("/login.jsp", loginCommand.execute(request, response));
    }

    @Test
    public void executeNegativeInput() {
        when(request.getParameter("login")).thenReturn("_anna");
        when(request.getParameter("password")).thenReturn("12_annaaaaaaaaaaaaaaaaaaaaaaaa");
        assertEquals("/login.jsp", loginCommand.execute(request, response));
    }

    @Test
    public void executeNegativeUserIsInContext() {
        User user = new User();
        user.setRole(UserRole.CUSTOMER);
        when(userService.logInUser("anna", "12anna")).thenReturn(user);
        when(ContextUtil.isUserInContext(session, user)).thenReturn(true);
        assertEquals("/redirect:/customer/account", loginCommand.execute(request, response));
    }
}