package ua.training.controller.commands;

import ua.training.controller.commands.customer.CustomerAccountPageCommand;
import ua.training.controller.commands.manager.ManagerAccountPageCommand;
import ua.training.controller.commands.master.MasterAccountPageCommand;
import ua.training.model.utils.URIBinder;

import java.util.HashMap;
import java.util.Map;

public class CommandsInitializer {
    private static volatile CommandsInitializer commandsInitializer;
    private static Map<String, Command> commands = new HashMap<>();

    private CommandsInitializer() {
        commands.put(URIBinder.getProperty("jsp.index"), new EmptyCommand());
        commands.put(URIBinder.getProperty("jsp.login"), new EmptyCommand());
        commands.put(URIBinder.getProperty("jsp.registration"), new EmptyCommand());

        commands.put(URIBinder.getProperty("path.login"), new LoginCommand());
        commands.put(URIBinder.getProperty("path.logout"), new LogoutCommand());
        commands.put(URIBinder.getProperty("path.registration"), new RegistrationCommand());
        commands.put(URIBinder.getProperty("path.customer.account"), new CustomerAccountPageCommand());
        commands.put(URIBinder.getProperty("path.manager.account"), new ManagerAccountPageCommand());
        commands.put(URIBinder.getProperty("path.master.account"), new MasterAccountPageCommand());

        commands.put(URIBinder.getProperty("redirect"), new EmptyCommand());

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
