package commandLogic.commands.noArgCommands;

import commandLogic.commands.BaseCommand;

/**
 * Shows reference about available commands.
 *
 * @author Zerumi
 * @since 1.0
 */
public class HelpCommand extends NoArgumentCommand implements BaseCommand {
    @Override
    public String getName() {
        return "help";
    }
}
