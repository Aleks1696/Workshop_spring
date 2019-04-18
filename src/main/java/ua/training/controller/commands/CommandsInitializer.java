package ua.training.controller.commands;

import ua.training.controller.commands.customer.*;
import ua.training.controller.commands.manager.*;
import ua.training.controller.commands.master.CloseRequestCommand;
import ua.training.controller.commands.master.GetAcceptedCommand;
import ua.training.controller.commands.master.ProcessRequestCommand;
import ua.training.controller.commands.master.RequestsToProcessCommand;
import ua.training.controller.commands.pages.*;
import ua.training.model.utils.URIBinder;

import java.util.HashMap;
import java.util.Map;

public class CommandsInitializer {
    private static volatile CommandsInitializer commandsInitializer;
    private static Map<String, Command> commands = new HashMap<>();

    private CommandsInitializer() {
        commands.put(URIBinder.getProperty("jsp.index"), new IndexPageCommand());
        commands.put(URIBinder.getProperty("path.index"), new IndexPageCommand());
        commands.put(URIBinder.getProperty("path.login"), new LoginPageCommand());
        commands.put(URIBinder.getProperty("path.registration"), new RegistrationPageCommand());
        commands.put(URIBinder.getProperty("path.services"), new ServicesPageCommand());

        commands.put("/language/en", new EmptyCommand());
        commands.put("/language/ua", new EmptyCommand());

        commands.put(URIBinder.getProperty("path.login.submit"), new LoginCommand());
        commands.put(URIBinder.getProperty("path.logout"), new LogoutCommand());
        commands.put(URIBinder.getProperty("path.registration.submit"), new RegistrationCommand());

        commands.put(URIBinder.getProperty("path.customer.account"), new CustomerAccountPageCommand());
        commands.put(URIBinder.getProperty("path.customer.active.requests"), new ActiveRequestsCommand());
        commands.put(URIBinder.getProperty("path.customer.request"), new NewCustomerRequestPageCommand());
        commands.put(URIBinder.getProperty("path.customer.request.submit"), new CreateRequestCommand());
        commands.put(URIBinder.getProperty("path.customer.request.delete"), new CancelRequestCommand());
        commands.put(URIBinder.getProperty("path.customer.notifications"), new CustomerNotificationPageCommand());
        commands.put(URIBinder.getProperty("path.customer.feedback.leave"), new LeaveFeedbackCommand());
        commands.put(URIBinder.getProperty("path.customer.request.archive"), new ArchiveRequestCommand());

        commands.put(URIBinder.getProperty("path.manager.account"), new ManagerAccountPageCommand());
        commands.put(URIBinder.getProperty("path.manager.active.request"), new NewRequestsCommand());
        commands.put(URIBinder.getProperty("path.manager.active.request.accept"), new AcceptRequestCommand());
        commands.put(URIBinder.getProperty("path.manager.active.request.decline"), new DeclineRequestCommand());
        commands.put(URIBinder.getProperty("path.manager.find.customer"), new FindCustomerPageCommand());
        commands.put(URIBinder.getProperty("path.manager.find.customer.submit"), new FindCustomerCommand());
        commands.put(URIBinder.getProperty("path.manager.feedback.from.customer"), new FindCustomerFeedbacksCommand());

        commands.put(URIBinder.getProperty("path.master.account"), new MasterAccountPageCommand());
        commands.put(URIBinder.getProperty("path.master.active.request"), new RequestsToProcessCommand());
        commands.put(URIBinder.getProperty("path.master.active.request.process"), new ProcessRequestCommand());
        commands.put(URIBinder.getProperty("path.master.bucket"), new GetAcceptedCommand());
        commands.put(URIBinder.getProperty("path.master.bucket.request.close"), new CloseRequestCommand());

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
