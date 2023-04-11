package commandLogic;

import commandLogic.commandReceiverLogic.receivers.ExternalBaseReceiver;

import java.io.Serializable;

public class CommandDescription implements Serializable {
    private final String name;
    private final ExternalBaseReceiver receiver;

    public CommandDescription(String name, ExternalBaseReceiver receiver) {
        this.name = name;
        this.receiver = receiver;
    }

    public String getName() {
        return name;
    }

    public ExternalBaseReceiver getReceiver() {
        return receiver;
    }
}
