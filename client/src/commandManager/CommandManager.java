package commandManager;

import commandLogic.commandReceiverLogic.ReceiverManager;
import commandLogic.commandReceiverLogic.ReceiverType;
import commandLogic.commandReceiverLogic.handlers.ArgumentReceiverHandler;
import commandLogic.commandReceiverLogic.handlers.NonArgReceiversHandler;
import commandManager.externalRecievers.ArgumentRouteCommandReceiver;
import commandManager.externalRecievers.NonArgumentReceiver;
import models.Route;
import models.handlers.ModuleHandler;
import models.handlers.nonUserMode.RouteNonCLIHandler;
import models.handlers.userMode.RouteCLIHandler;

import java.util.Scanner;

/**
 * Command Manager for interactive collection manage. For execute commands, use CommandExecutor class
 *
 * @see CommandExecutor
 * @since 1.0
 * @author Zerumi
 */
public class CommandManager {
    public CommandManager(CommandMode mode, Scanner scanner) {
        ReceiverManager manager = ReceiverManager.getInstance();

        manager.registerHandler(ReceiverType.NoArgs, new NonArgReceiversHandler());
        manager.registerHandler(ReceiverType.ArgumentRoute, new ArgumentReceiverHandler<>(Route.class));

        manager.registerReceiver(ReceiverType.NoArgs, new NonArgumentReceiver());

        ModuleHandler<Route> handler = null;
        switch (mode) {
            case CLI_UserMode -> handler = new RouteCLIHandler();
            case NonUserMode -> handler = new RouteNonCLIHandler(scanner);
        }
        manager.registerReceiver(ReceiverType.ArgumentRoute, new ArgumentRouteCommandReceiver(handler));
    }
}
