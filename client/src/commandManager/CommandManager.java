package commandManager;

import commandLogic.ExternalCommandLoader;
import commandLogic.commands.BaseCommand;
import commandLogic.receivers.ReceiverManager;
import commandLogic.receivers.ReceiverType;
import commandManager.commands.ExecuteScriptCommand;
import commandManager.commands.ExitCommand;
import commandManager.externalRecievers.NonArgumentReciever;
import exceptions.BuildObjectException;
import exceptions.CommandInterruptedException;
import exceptions.UnknownCommandException;
import exceptions.WrongAmountOfArgumentsException;

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
    LinkedHashMap<String, BaseCommand> commands;

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

        ReceiverManager.registerReceiver(ReceiverType.NoArgs, new NonArgumentReciever());

        // TODO: надо подумать, что с этим делать
        /* ModuleHandler<Route> handler = null;
        switch (mode)
        {
            case CLI_UserMode -> handler = new RouteCLIHandler();
            case NonUserMode -> handler = new RouteNonCLIHandler(scanner);
        }

        commands.put("add", new AddCommand(handler));
        commands.put("update", new UpdateCommand(handler));
        commands.put("add_if_max", new AddIfMaxCommand(handler));
        commands.put("add_if_min", new AddIfMinCommand(handler));
        commands.put("remove_greater", new RemoveGreaterCommand(handler));*/
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
            Optional.ofNullable(commands.get(args[0])).orElseThrow(() -> new UnknownCommandException("Указанная команда не была обнаружена")).execute(args);
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
