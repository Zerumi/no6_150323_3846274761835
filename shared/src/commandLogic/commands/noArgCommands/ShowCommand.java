package commandLogic.commands.noArgCommands;

import commandLogic.commands.BaseCommand;

/**
 * Shows every element of the collection in toString() interpretation.
 *
 * @author Zerumi
 * @since 1.0
 */
public class ShowCommand extends NoArgumentCommand implements BaseCommand {
    @Override
    public String getName() {
        return "show";
    }
}
