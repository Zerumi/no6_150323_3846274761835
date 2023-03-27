package commandManager.commands;

import requestLogic.requestSenders.CommandRequestSender;
import serverLogic.ServerConnectionHandler;

/**
 * Removes element from collection by id.
 *
 * @since 1.0
 * @author Zerumi
 */
public class RemoveByIdCommand implements BaseCommand {
    @Override
    public void execute(String[] args) {
        CommandRequestSender.sendCommand(this, args, ServerConnectionHandler.getCurrentConnection());
    }
}
