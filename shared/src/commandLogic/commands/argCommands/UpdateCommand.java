package commandLogic.commands.argCommands;


import commandLogic.commandReceiverLogic.ReceiverType;
import commandLogic.commands.BaseCommand;
import main.LibUtilities;

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
