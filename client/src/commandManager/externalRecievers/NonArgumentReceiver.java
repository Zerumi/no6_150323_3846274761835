package commandManager.externalRecievers;

import commandLogic.CommandDescription;
import commandLogic.commandReceiverLogic.receivers.ExternalBaseReceiver;
import requestLogic.requestSenders.CommandRequestSender;
import serverLogic.ServerConnectionHandler;

public class NonArgumentReceiver implements ExternalBaseReceiver {

    @Override
    public void receiveCommand(CommandDescription command, String[] args) {
        new CommandRequestSender().sendCommand(command, args, ServerConnectionHandler.getCurrentConnection());
    }
}
