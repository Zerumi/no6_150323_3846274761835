package commandManager.commands;

import requestLogic.requestSenders.CommandRequestSender;
import serverLogic.ServerConnectionHandler;

/**
 * Shows information about the collection.
 *
 * @since 1.0
 * @author Zerumi
 */
public class InfoCommand implements BaseCommand {
    @Override
    public void execute(String[] args) {
        CommandRequestSender.sendCommand(this, args, ServerConnectionHandler.getCurrentConnection());
    }
}
