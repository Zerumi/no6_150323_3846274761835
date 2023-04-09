package commandLogic.commands.argCommands;


import commandLogic.commandReceiverLogic.ReceiverType;
import commandLogic.commands.BaseCommand;

/**
 * Removes elements from collection greater than given in argument.
 *
 * @author Zerumi
 * @since 1.0
 */
public class RemoveGreaterCommand extends ArgumentCommand implements BaseCommand {

    public RemoveGreaterCommand(ReceiverType type) {
        super(type);
    }

    @Override
    public String getName() {
        return "remove_greater";
    }
}
