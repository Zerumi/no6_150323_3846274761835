package commandLogic.commands.noArgCommands;

import commandLogic.commands.BaseCommand;

/**
 * Returns element from collection with min creation date.
 *
 * @author Zerumi
 * @since 1.0
 */
public class MinByCreationDateCommand extends NoArgumentCommand implements BaseCommand {
    @Override
    public String getName() {
        return "min_by_creation_date";
    }
}
