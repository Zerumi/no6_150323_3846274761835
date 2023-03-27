package commandManager.commands;

import requestLogic.requestSenders.CommandRequestSender;
import serverLogic.ServerConnectionHandler;

/**
 * Returns element from collection with min creation date.
 *
 * @author Zerumi
 * @since 1.0
 */
public class MinByCreationDateCommand implements BaseCommand {
    @Override
    public void execute(String[] args) {
        CommandRequestSender.sendCommand(this, args, ServerConnectionHandler.getCurrentConnection());
    }
}
