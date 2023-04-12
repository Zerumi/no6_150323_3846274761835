package commandLogic.commandReceiverLogic.callers;

import commandLogic.CommandDescription;
import commandLogic.commandReceiverLogic.ReceiverManager;
import commandLogic.commandReceiverLogic.enums.ReceiverType;

public class ExternalBaseReceiverCaller extends ExternalCaller {
    @Override
    public void callReceivers(CommandDescription description, String[] lineArgs) throws Exception {
        for (var receiver : ReceiverManager.getInstance().getReceivers(ReceiverType.NoArgs)) {
            receiver.receiveCommand(description, lineArgs);
        }
    }
}
