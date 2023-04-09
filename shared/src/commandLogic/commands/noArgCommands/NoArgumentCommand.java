package commandLogic.commands.noArgCommands;

import commandLogic.commandReceiverLogic.ReceiverManager;
import commandLogic.commandReceiverLogic.ReceiverType;
import commandLogic.commands.BaseCommand;

public abstract class NoArgumentCommand implements BaseCommand {
    /**
     * Base method for command executing.
     *
     * @param args full array of entered line.
     * @throws Exception -- This is used by 3rd party apps, so that's ok
     */
    @Override
    public void execute(String[] args) throws Exception {
        for (var receiver : ReceiverManager.getInstance().getReceivers(ReceiverType.NoArgs)) {
            receiver.receiveCommand(this, args);
        }
    }
}
