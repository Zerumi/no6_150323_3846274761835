package commandManager.externalRecievers;

import commandLogic.commandReceiverLogic.receivers.ExternalBaseReceiver;
import commandLogic.commands.BaseCommand;
import requestLogic.requestSenders.CommandRequestSender;
import serverLogic.ServerConnectionHandler;

public class NonArgumentReceiver implements ExternalBaseReceiver {

    @Override
    public void receiveCommand(BaseCommand command, String[] args) {
        new CommandRequestSender().sendCommand(command, args, ServerConnectionHandler.getCurrentConnection());
    }
}
