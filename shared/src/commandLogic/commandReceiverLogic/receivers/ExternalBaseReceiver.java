package commandLogic.commandReceiverLogic.receivers;

import commandLogic.CommandDescription;

public interface ExternalBaseReceiver {
    void receiveCommand(CommandDescription command, String[] args) throws Exception;
}
