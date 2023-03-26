package commandManager.commands;

import serverLogic.ServerConnectionHandler;
import serverLogic.ServerConnectionUtils;

/**
 * Shows reference about available commands.
 *
 * @author Zerumi
 * @since 1.0
 */
public class HelpCommand implements BaseCommand {
    @Override
    public void execute(String[] args) {
        ServerConnectionUtils.sendNonArgumentCommand(this, args, ServerConnectionHandler.getCurrentConnection());
    }
}
