package commandLogic.commands.noArgCommands;


import commandLogic.commands.BaseCommand;

/**
 * Shows count of the elements greater than distance value.
 *
 * @author Zerumi
 * @since 1.0
 */
public class CountGreaterThanDistanceCommand extends NoArgumentCommand implements BaseCommand {
    @Override
    public String getName() {
        return "count_greater_than_distance";
    }
}
