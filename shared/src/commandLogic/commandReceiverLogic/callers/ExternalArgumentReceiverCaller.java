package commandLogic.commandReceiverLogic.callers;

import commandLogic.CommandDescription;
import commandLogic.commandReceiverLogic.ReceiverManager;
import commandLogic.commandReceiverLogic.enums.ReceiverType;
import commandLogic.commandReceiverLogic.receivers.ExternalArgumentReceiver;

import java.util.ArrayList;

public class ExternalArgumentReceiverCaller<T> extends ExternalCaller {
    @Override
    public void callReceivers(CommandDescription description, String[] lineArgs) throws Exception {
        for (ExternalArgumentReceiver<T> receiver : (ArrayList<ExternalArgumentReceiver<T>>) ReceiverManager.getInstance().getReceivers(ReceiverType.ArgumentRoute)) {
            receiver.receiveCommand(description, lineArgs);
        }
    }
}
