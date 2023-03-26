package commandManager.commands;

import commandManager.commandResponse.CommandResponse;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Terminates the application (without saving collection).
 *
 * @author Zerumi
 * @since 1.0
 */
public class ExitCommand implements BaseCommand {
    CommandResponse response;

    private static final Logger myLogger = Logger.getLogger("com.github.zerumi.lab5");

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescr() {
        return "Terminates the application (without saving collection).";
    }

    @Override
    public void execute(String[] args) {
        myLogger.log(Level.FINE, "Выходим из программы...");
        System.exit(0);
    }

    @Override
    public CommandResponse getResponse() {
        return response;
    }
}
