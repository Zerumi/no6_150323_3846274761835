package commandLogic.commands.noArgCommands;

import commandLogic.commands.BaseCommand;

/**
 * Clears collection
 *
 * @author Zerumi
 * @since 1.0
 */
public class ClearCommand extends NoArgumentCommand implements BaseCommand {
    @Override
    public String getName() {
        return "clear";
    }
}
