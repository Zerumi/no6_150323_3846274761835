package commandLogic.commands.argCommands;

import commandLogic.commandReceiverLogic.ReceiverManager;
import commandLogic.commandReceiverLogic.ReceiverType;
import commandLogic.commands.BaseCommand;

public abstract class ArgumentCommand implements BaseCommand {

    private final ReceiverType type;

    public ArgumentCommand(ReceiverType type) {
        this.type = type;
    }

    @Override
    public void execute(String[] args) throws Exception {
        for (var receiver : ReceiverManager.getInstance().getReceivers(type)) {
            receiver.receiveCommand(this, args);
        }
    }
}
