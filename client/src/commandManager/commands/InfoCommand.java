package commandManager.commands;

import serverLogic.ServerConnectionHandler;
import serverLogic.ServerConnectionUtils;

/**
 * Shows information about the collection.
 *
 * @since 1.0
 * @author Zerumi
 */
public class InfoCommand implements BaseCommand {
    @Override
    public void execute(String[] args) {
        ServerConnectionUtils.sendCommand(this, args, ServerConnectionHandler.getCurrentConnection());
    }
}
