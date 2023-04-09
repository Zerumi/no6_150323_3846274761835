package commandLogic.commands.noArgCommands;

import commandLogic.commands.BaseCommand;
import commandLogic.receivers.ReceiverManager;
import commandLogic.receivers.ReceiverType;

public abstract class NoArgumentCommand implements BaseCommand {
    /**
     * Base method for command executing.
     *
     * @param args full array of entered line.
     * @throws Exception -- This is used by 3rd party apps, so that's ok
     */
    @Override
    public void execute(String[] args) throws Exception {
        ReceiverManager.getReceivers(ReceiverType.NoArgs).forEach(x -> x.recieveCommand(this, args));
    }
}
