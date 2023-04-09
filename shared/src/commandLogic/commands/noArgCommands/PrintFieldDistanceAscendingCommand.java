package commandLogic.commands.noArgCommands;

import commandLogic.commands.BaseCommand;

/**
 * Prints all distance fields in ascending sorting.
 *
 * @author Zerumi
 * @since 1.0
 */
public class PrintFieldDistanceAscendingCommand extends NoArgumentCommand implements BaseCommand {
    @Override
    public String getName() {
        return "print_field_ascending_distance";
    }
}
