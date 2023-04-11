package commandManager;

import exceptions.CommandInterruptedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class for executing commands. Provides different inputs for command executing.
 */
public class CommandExecutor {
    private static final Logger logger = LogManager.getLogger("com.github.zerumi.lab6");

    /**
     * Start executing commands from InputStream.
     *
     * @param input commands stream (File, System.in, e.t.c.)
     * @param mode  variant of command behavior (see CommandMode enum)
     */
    public void startExecuting(InputStream input, CommandMode mode) {
        Scanner cmdScanner = new Scanner(input);
        CommandManager commandManager = new CommandManager(mode, cmdScanner);
        while (cmdScanner.hasNext()) {
            String line = cmdScanner.nextLine();
            if (line.isEmpty()) continue;
            try {
                String[] lineargs = line.split(" ");

            } catch (CommandInterruptedException ex) {
                if (mode.equals(CommandMode.CLI_UserMode))
                    logger.info("Выполнение команды было прервано. Вы можете продолжать работу. Программа возвращена в безопасное состояние.");
                else
                    logger.info("Команда была пропущена... Обработчик продолжает работу");
            }
        }
    }
}