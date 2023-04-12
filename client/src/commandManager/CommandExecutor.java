package commandManager;

import commandLogic.CommandDescription;
import commandLogic.commandReceiverLogic.ReceiverManager;
import commandLogic.commandReceiverLogic.enums.ReceiverType;
import commandLogic.commandReceiverLogic.handlers.ArgumentReceiverHandler;
import commandLogic.commandReceiverLogic.handlers.NonArgReceiversHandler;
import commandManager.externalRecievers.ArgumentRouteCommandReceiver;
import commandManager.externalRecievers.ExecuteScriptReceiver;
import commandManager.externalRecievers.ExitReceiver;
import commandManager.externalRecievers.NonArgumentReceiver;
import exceptions.CommandInterruptedException;
import exceptions.CommandsNotLoadedException;
import exceptions.UnknownCommandException;
import models.Route;
import models.handlers.ModuleHandler;
import models.handlers.nonUserMode.RouteNonCLIHandler;
import models.handlers.userMode.RouteCLIHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import static commandManager.CommandMode.CLI_UserMode;

/**
 * Class for executing commands. Provides different inputs for command executing.
 */
public class CommandExecutor {
    private static final Logger logger = LogManager.getLogger("com.github.zerumi.lab6");

    private final ArrayList<CommandDescription> commands;
    private final InputStream input;
    private final CommandMode mode;

    /**
     * Constructor :/
     *
     * @param commands array of commands
     * @param input    commands stream (File, System.in, e.t.c.)
     * @param mode     variant of command behavior (see CommandMode enum)
     */
    public CommandExecutor(ArrayList<CommandDescription> commands, InputStream input, CommandMode mode) throws CommandsNotLoadedException {
        if (commands == null) throw new CommandsNotLoadedException();

        this.commands = commands;
        this.input = input;
        this.mode = mode;
        ReceiverManager manager = ReceiverManager.getInstance();

        manager.registerHandler(ReceiverType.NoArgs, new NonArgReceiversHandler());
        manager.registerHandler(ReceiverType.ArgumentRoute, new ArgumentReceiverHandler<>(Route.class));

        manager.registerReceiver(ReceiverType.NoArgs, new NonArgumentReceiver());
        manager.registerReceiver(ReceiverType.NoArgs, new ExecuteScriptReceiver());
        manager.registerReceiver(ReceiverType.NoArgs, new ExitReceiver());

        ModuleHandler<Route> handler = null;
        switch (mode) {
            case CLI_UserMode -> handler = new RouteCLIHandler();
            case NonUserMode -> handler = new RouteNonCLIHandler(new Scanner(input));
        }
        manager.registerReceiver(ReceiverType.ArgumentRoute, new ArgumentRouteCommandReceiver(handler));
    }

    /**
     * Start executing commands from InputStream.
     */
    public void startExecuting() {
        Scanner cmdScanner = new Scanner(input);
        while (cmdScanner.hasNext()) {
            String line = cmdScanner.nextLine();
            if (line.isEmpty()) continue;
            try {
                String[] lineArgs = line.split(" ");
                CommandDescription description = Optional.ofNullable(commands).orElseThrow(CommandsNotLoadedException::new).stream().filter(x -> x.getName().equals(lineArgs[0])).findAny().orElseThrow(() -> new UnknownCommandException("Указанная команда не была обнаружена"));
                description.getReceiver().callReceivers(description, lineArgs);
            } catch (CommandInterruptedException ex) {
                if (mode.equals(CLI_UserMode))
                    logger.info("Выполнение команды было прервано. Вы можете продолжать работу. Программа возвращена в безопасное состояние.");
                else
                    logger.info("Команда была пропущена... Обработчик продолжает работу");
            } catch (UnknownCommandException e) {
                logger.info(e.getMessage());
            } catch (Exception e) {
                logger.info("Непредвиденная ошибка при исполнении команды, " + e.getMessage());
            }
        }
    }
}