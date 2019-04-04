package ua.training.controller.commands;

import ua.training.controller.commands.customer.CustomerAccountPageCommand;
import ua.training.model.utils.URIBinder;

import java.util.HashMap;
import java.util.Map;

public class CommandsInitializer {
    private static volatile CommandsInitializer commandsInitializer;
    private static Map<String, Command> commands = new HashMap<>();

    private CommandsInitializer() {
        commands.put(URIBinder.getProperty("jsp.index"), new IndexPageCommand());
        commands.put(URIBinder.getProperty("jsp.login"), new LoginCommand());
        commands.put(URIBinder.getProperty("jsp.registration"), new RegistrationPageCommand());

        commands.put(URIBinder.getProperty("path.login"), new LoginCommand());
        commands.put(URIBinder.getProperty("path.customer.account"), new CustomerAccountPageCommand());

        commands.put(URIBinder.getProperty("redirect"), new RedirectCommand());


    }

    public static CommandsInitializer getInstance() {
        if (commandsInitializer == null) {
            synchronized (CommandsInitializer.class) {
                if (commandsInitializer == null) {
                    commandsInitializer = new CommandsInitializer();
                }
            }
        }
        return commandsInitializer;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}
