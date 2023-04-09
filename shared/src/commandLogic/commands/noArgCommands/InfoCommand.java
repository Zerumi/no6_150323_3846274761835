package commandLogic.commands.noArgCommands;

import commandLogic.commands.BaseCommand;

/**
 * Shows information about the collection.
 *
 * @author Zerumi
 * @since 1.0
 */
public class InfoCommand extends NoArgumentCommand implements BaseCommand {
    @Override
    public String getName() {
        return "info";
    }
}
