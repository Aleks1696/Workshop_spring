package ua.training.controller.utils;

import ua.training.controller.commands.Command;
import ua.training.controller.commands.LoginCommand;
import ua.training.controller.constants.URI;

import java.util.HashMap;
import java.util.Map;

public class CommandsInitializer {
    private static Map<String, Command> commands = new HashMap<>();

    //TODO it might be not a good idea to use static block at all
    static {
        commands.put(URI.INDEX_JSP, new LoginCommand());
        commands.put(URI.LOGIN_JSP, new LoginCommand());
        commands.put(URI.REGISTRATION_JSP, new LoginCommand());
        commands.put(URI.LOGIN_COMMAND, new LoginCommand());

    }

    public static Map<String, Command> getCommands() {
        return commands;
    }
}
