package commandManager.commands;

import requestLogic.requestSenders.CommandRequestSender;
import serverLogic.ServerConnectionHandler;

/**
 * Shows reference about available commands.
 *
 * @author Zerumi
 * @since 1.0
 */
public class HelpCommand implements BaseCommand {
    @Override
    public void execute(String[] args) {
        CommandRequestSender.sendCommand(this, args, ServerConnectionHandler.getCurrentConnection());
    }
}
