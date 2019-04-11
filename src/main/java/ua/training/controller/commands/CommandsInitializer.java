package ua.training.controller.commands;

import ua.training.controller.commands.customer.CreateRequestCommand;
import ua.training.controller.commands.customer.ActiveRequestsCommand;
import ua.training.controller.commands.manager.AcceptRequestCommand;
import ua.training.controller.commands.manager.DeclineRequestCommand;
import ua.training.controller.commands.pages.*;
import ua.training.controller.commands.manager.NewRequestsCommand;
import ua.training.model.utils.URIBinder;

import java.util.HashMap;
import java.util.Map;

public class CommandsInitializer {
    private static volatile CommandsInitializer commandsInitializer;
    private static Map<String, Command> commands = new HashMap<>();

    private CommandsInitializer() {
        commands.put(URIBinder.getProperty("path.index"), new IndexPageCommand());
        commands.put(URIBinder.getProperty("path.login"), new LoginPageCommand());
        commands.put(URIBinder.getProperty("path.registration"), new RegistrationPageCommand());

        commands.put("/language/en", new EmptyCommand());
        commands.put("/language/ua", new EmptyCommand());

        commands.put(URIBinder.getProperty("path.login.submit"), new LoginCommand());
        commands.put(URIBinder.getProperty("path.logout"), new LogoutCommand());
        commands.put(URIBinder.getProperty("path.registration.submit"), new RegistrationCommand());
        commands.put(URIBinder.getProperty("path.customer.account"), new CustomerAccountPageCommand());
        commands.put(URIBinder.getProperty("path.customer.active.requests"), new ActiveRequestsCommand());
        commands.put(URIBinder.getProperty("path.customer.request"), new NewCustomerRequestPageCommand());
        commands.put(URIBinder.getProperty("path.customer.request.submit"), new CreateRequestCommand());
        commands.put(URIBinder.getProperty("path.manager.account"), new ManagerAccountPageCommand());
        commands.put(URIBinder.getProperty("path.manager.active.request"), new NewRequestsCommand());
        commands.put(URIBinder.getProperty("path.manager.active.request.accept"), new AcceptRequestCommand());
        commands.put(URIBinder.getProperty("path.manager.active.request.decline"), new DeclineRequestCommand());
        commands.put(URIBinder.getProperty("path.master.account"), new MasterAccountPageCommand());

//        commands.put(URIBinder.getProperty("redirect"), new EmptyCommand());

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
