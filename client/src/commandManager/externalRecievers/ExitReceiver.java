package commandManager.externalRecievers;

import commandLogic.CommandDescription;
import commandLogic.commandReceiverLogic.receivers.ExternalBaseReceiver;

import java.util.Objects;

public class ExitReceiver implements ExternalBaseReceiver {

    @Override
    public void receiveCommand(CommandDescription command, String[] args) throws Exception {
        if (!Objects.equals(command.getName(), "exit")) return;

        System.exit(0);
    }
}
