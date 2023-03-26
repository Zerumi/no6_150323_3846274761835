package commandManager.commands;

import serverLogic.ServerConnectionHandler;
import serverLogic.ServerConnectionUtils;

/**
 * Prints all distance fields in ascending sorting.
 *
 * @since 1.0
 * @author Zerumi
 */
public class PrintFieldDistanceAscendingCommand implements BaseCommand {
    @Override
    public void execute(String[] args) {
        ServerConnectionUtils.sendNonArgumentCommand(this, args, ServerConnectionHandler.getCurrentConnection());
    }
}
