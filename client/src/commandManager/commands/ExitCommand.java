package commandManager.commands;

import requestLogic.requestSenders.CommandRequestSender;
import serverLogic.ServerConnectionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Terminates the application (without saving collection).
 *
 * @since 1.0
 * @author Zerumi
 */
public class ExitCommand implements BaseCommand {

    private static final Logger myLogger = Logger.getLogger("com.github.zerumi.lab5");

    @Override
    public void execute(String[] args) {
        CommandRequestSender.sendCommand(this, args, ServerConnectionHandler.getCurrentConnection());
        myLogger.log(Level.FINE, "Выходим из программы...");
        System.exit(0);
    }
}
