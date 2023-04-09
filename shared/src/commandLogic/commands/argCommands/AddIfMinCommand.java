package commandLogic.commands.argCommands;

import commandLogic.commandReceiverLogic.ReceiverType;
import commandLogic.commands.BaseCommand;

/**
 * Adds element if it's value lower than min value.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddIfMinCommand extends ArgumentCommand implements BaseCommand {

    public AddIfMinCommand(ReceiverType type) {
        super(type);
    }

    @Override
    public String getName() {
        return "add_if_min";
    }
}
