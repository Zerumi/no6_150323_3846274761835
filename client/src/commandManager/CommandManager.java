package commandManager;

import commandLogic.ExternalCommandLoader;
import commandLogic.commandReceiverLogic.ReceiverManager;
import commandLogic.commandReceiverLogic.ReceiverType;
import commandLogic.commandReceiverLogic.handlers.ArgumentReceiverHandler;
import commandLogic.commandReceiverLogic.handlers.NonArgReceiversHandler;
import commandLogic.commands.BaseCommand;
import commandManager.commands.ExecuteScriptCommand;
import commandManager.commands.ExitCommand;
import commandManager.externalRecievers.ArgumentRouteCommandReceiver;
import commandManager.externalRecievers.NonArgumentReceiver;
import exceptions.BuildObjectException;
import exceptions.CommandInterruptedException;
import exceptions.UnknownCommandException;
import exceptions.WrongAmountOfArgumentsException;
import main.Utilities;
import models.Route;
import models.handlers.ModuleHandler;
import models.handlers.nonUserMode.RouteNonCLIHandler;
import models.handlers.userMode.RouteCLIHandler;

import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Command Manager for interactive collection manage. For execute commands, use CommandExecutor class
 *
 * @see CommandExecutor
 * @since 1.0
 * @author Zerumi
 */
public class CommandManager {

    private static final Logger myLogger = Logger.getLogger("com.github.zerumi.lab5");
    final LinkedHashMap<String, BaseCommand> commands;

    /**
     * Constructor provides choice of commands behavior: ex. userMode or nonUserMode
     *
     * @since 1.1
     * @see CommandMode
     * @param mode Mode for CommandHandler
     * @param scanner Commands scanner
     */
    public CommandManager(CommandMode mode, Scanner scanner) {
        commands = new LinkedHashMap<>();

        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("exit", new ExitCommand());

        ExternalCommandLoader loader = new ExternalCommandLoader();
        commands.putAll(loader.getExternalCommands());

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

    /**
     * Get all commands from manager.
     *
     * @return Map of loaded commands
     */
    public LinkedHashMap<String, BaseCommand> getCommands() {
        return commands;
    }

    /**
     * Universe method for command executing.
     *
     * @param args full separated line from stream
     */
    public void executeCommand(String[] args) {
        try {
            BaseCommand command = Optional.ofNullable(commands.get(args[0])).orElseThrow(() -> new UnknownCommandException("Указанная команда не была обнаружена"));
            if (command.getArgCount() > 0)
                Utilities.checkArgumentsOrThrow(args.length, command.getArgCount());
            command.execute(args);
        } catch (IllegalArgumentException | NullPointerException e) {
            myLogger.log(Level.SEVERE, "Выполнение команды пропущено из-за неправильных предоставленных аргументов! (" + e.getMessage() + ")");
            throw new CommandInterruptedException(e);
        } catch (BuildObjectException | UnknownCommandException e) {
            myLogger.log(Level.SEVERE, e.getMessage());
            throw new CommandInterruptedException(e);
        } catch (WrongAmountOfArgumentsException e) {
            myLogger.log(Level.SEVERE, "Wrong amount of arguments! " + e.getMessage());
            throw new CommandInterruptedException(e);
        } catch (Exception e) {
            myLogger.log(Level.SEVERE, "В командном менеджере произошла непредвиденная ошибка! " + e.getMessage());
            throw new CommandInterruptedException(e);
        }
    }
}
