package ua.training.controller.commands;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ua.training.controller.utils.ContextUtil;
import ua.training.model.dao.mapper.Mapper;
import ua.training.model.entity.User;
import ua.training.model.service.user.UserService;
import ua.training.model.types.UserRole;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ContextUtil.class)
public class RegistrationCommandTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private Mapper<User> userMapper;
    @Mock
    private UserService userService;
    @InjectMocks
    private RegistrationCommand registrationCommand;

    private User user;

    @Before
    public void initialize() {
        user = new User();
        user.setId(2);
        user.setLogin("anna");
        user.setPassword("12anna");
        user.setRole(UserRole.CUSTOMER);
        user.setName("Anna");
        user.setName_ua("Анна");
        user.setSurname("Mulina");
        user.setSurname_ua("Муліна");
        user.setEmail("anna@gmail.com");
        user.setPhoneNumber("2453632");

        MockitoAnnotations.initMocks(this);
        when(request.getSession()).thenReturn(session);
        PowerMockito.mockStatic(ContextUtil.class);
    }

    @Test
    public void executePositive() throws Exception {
        when(userMapper.extract(request)).thenReturn(user);
        when(userService.createUser(user)).thenReturn(user);
        PowerMockito.doNothing().when(ContextUtil.class);
        ContextUtil.setAttributesToContext(session, user);
        assertEquals("/redirect:/customer/account", registrationCommand.execute(request, response));
    }

    @Test
    public void executeNegativeDBRegistration() throws Exception {
        when(userMapper.extract(request)).thenReturn(user);
        when(userService.createUser(user)).thenThrow(new Exception());
        PowerMockito.doNothing().when(ContextUtil.class);
        ContextUtil.setAttributesToContext(session, user);
        assertEquals("/registration.jsp", registrationCommand.execute(request, response));
    }

    @Test
    public void executeNegativeInput() throws Exception {
        user.setSurname_ua("Milan");
        when(userMapper.extract(request)).thenReturn(user);
        System.out.println(request.getParameter("error_message"));
        assertEquals("/registration.jsp", registrationCommand.execute(request, response));
    }
}