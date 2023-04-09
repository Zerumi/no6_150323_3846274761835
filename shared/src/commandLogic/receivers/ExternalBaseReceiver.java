package commandLogic.receivers;

import commandLogic.commands.BaseCommand;

public interface ExternalBaseReceiver {
    void recieveCommand(BaseCommand command, String[] args);
}
