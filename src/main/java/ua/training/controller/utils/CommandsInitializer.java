package ua.training.controller.utils;

import ua.training.controller.commands.*;
import ua.training.controller.constants.URI;
import java.util.HashMap;
import java.util.Map;

public class CommandsInitializer {
    private static Map<String, Command> commands = new HashMap<>();

    //TODO it might be not a good idea to use static block at all
    static {
        commands.put(URI.JSP_INDEX, new IndexCommand());
        commands.put(URI.JSP_LOGIN, new LoginCommand());
        commands.put(URI.JSP_REGISTRATION, new RegistrationCommand());
        commands.put(URI.PATH_LOGIN, new LoginCommand());
    }

    public static Map<String, Command> getCommands() {
        return commands;
    }
}
