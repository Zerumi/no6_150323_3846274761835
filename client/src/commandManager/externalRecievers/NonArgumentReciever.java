package commandManager.externalRecievers;

import commandLogic.commands.BaseCommand;
import commandLogic.receivers.ExternalBaseReceiver;
import requestLogic.requestSenders.CommandRequestSender;
import serverLogic.ServerConnectionHandler;

public class NonArgumentReciever implements ExternalBaseReceiver {

    @Override
    public void recieveCommand(BaseCommand command, String[] args) {
        CommandRequestSender.sendCommand(command, args, ServerConnectionHandler.getCurrentConnection());
    }
}
