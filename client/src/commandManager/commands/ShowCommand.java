package commandManager.commands;

import requestLogic.requestSenders.CommandRequestSender;
import serverLogic.ServerConnectionHandler;

/**
 * Shows every element of the collection in toString() interpretation.
 *
 * @author Zerumi
 * @since 1.0
 */
public class ShowCommand implements BaseCommand {
    @Override
    public void execute(String[] args) {
        CommandRequestSender.sendCommand(this, args, ServerConnectionHandler.getCurrentConnection());
    }
}
