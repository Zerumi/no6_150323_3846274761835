package commandLogic.commands.noArgCommands;

import commandLogic.commands.BaseCommand;

/**
 * Removes element from collection by id.
 *
 * @author Zerumi
 * @since 1.0
 */
public class RemoveByIdCommand extends NoArgumentCommand implements BaseCommand {
    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public void execute(String[] args) {
        // TODO: validate id?
    }
}
