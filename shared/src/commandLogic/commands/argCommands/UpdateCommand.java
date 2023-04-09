package commandLogic.commands.argCommands;


import commandLogic.commandReceiverLogic.ReceiverType;
import commandLogic.commands.BaseCommand;

/**
 * Updates element by its ID.
 *
 * @author Zerumi
 * @since 1.0
 */
public class UpdateCommand extends ArgumentCommand implements BaseCommand {

    public UpdateCommand(ReceiverType type) {
        super(type);
    }

    @Override
    public String getName() {
        return "update";
    }
}
