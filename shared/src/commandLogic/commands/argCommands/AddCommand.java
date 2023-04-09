package commandLogic.commands.argCommands;

import commandLogic.commandReceiverLogic.ReceiverType;
import commandLogic.commands.BaseCommand;

/**
 * Adds new element to collection.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddCommand extends ArgumentCommand implements BaseCommand {

    public AddCommand(ReceiverType type) {
        super(type);
    }

    @Override
    public String getName() {
        return "add";
    }
}