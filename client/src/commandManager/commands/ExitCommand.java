package commandManager.commands;

import commandLogic.commands.BaseCommand;
import requestLogic.requestSenders.CommandRequestSender;
import responseLogic.responseListener.ResponseListener;
import serverLogic.ServerConnectionHandler;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Terminates the application. Invoke server collection-saving request.
 *
 * @author Zerumi
 * @since 1.0
 */
public class ExitCommand implements BaseCommand {


    private static final Logger myLogger = Logger.getLogger("com.github.zerumi.lab5");

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public void execute(String[] args) throws IOException {
        new CommandRequestSender().sendCommand(this, args, ServerConnectionHandler.getCurrentConnection());
        ResponseListener.getInstance().getListeningThread().interrupt();
        ServerConnectionHandler.getCurrentConnection().closeConnection();
        myLogger.log(Level.FINE, "Выходим из программы...");
        System.exit(0);
    }
}
