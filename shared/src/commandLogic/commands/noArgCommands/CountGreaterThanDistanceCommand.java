package commandLogic.commands.noArgCommands;


import commandLogic.commands.BaseCommand;
import main.LibUtilities;

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

    @Override
    public int getArgCount() {
        return 1;
    }

    @Override
    public void execute(String[] args) throws Exception {

        if (LibUtilities.isNotNumeric(args[1])) {
            System.out.println("Provided argument \"" + args[1] + "\" is not a number! Try again.");
            return;
        } else if (args[1].contains(",")) {
            System.out.println("Distance field cannot accept decimal values. Try again");
            return;
        }

        super.execute(args);
    }
}
