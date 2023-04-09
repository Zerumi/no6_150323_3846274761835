package commandLogic.commands.argCommands;

import commandLogic.commandReceiverLogic.ReceiverType;
import commandLogic.commands.BaseCommand;

/**
 * Add element if it's value greater than max value.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddIfMaxCommand extends ArgumentCommand implements BaseCommand {

    public AddIfMaxCommand(ReceiverType type) {
        super(type);
    }

    @Override
    public String getName() {
        return "add_if_max";
    }
}
