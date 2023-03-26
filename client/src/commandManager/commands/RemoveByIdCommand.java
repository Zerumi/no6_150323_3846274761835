package commandManager.commands;

import serverLogic.ServerConnectionHandler;
import serverLogic.ServerConnectionUtils;

/**
 * Removes element from collection by id.
 *
 * @since 1.0
 * @author Zerumi
 */
public class RemoveByIdCommand implements BaseCommand {
    @Override
    public void execute(String[] args) {
        ServerConnectionUtils.sendNonArgumentCommand(this, args, ServerConnectionHandler.getCurrentConnection());
    }
}
