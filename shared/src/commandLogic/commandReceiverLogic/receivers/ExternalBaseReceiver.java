package commandLogic.commandReceiverLogic.receivers;

import commandLogic.commands.BaseCommand;

public interface ExternalBaseReceiver {
    void receiveCommand(BaseCommand command, String[] args) throws Exception;
}
