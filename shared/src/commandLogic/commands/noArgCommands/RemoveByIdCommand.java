package commandLogic.commands.noArgCommands;

import commandLogic.commands.BaseCommand;
import main.LibUtilities;

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
    public int getArgCount() {
        return 1;
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (LibUtilities.handleUserInputID(args[1]) != null)
            super.execute(args);
    }
}
