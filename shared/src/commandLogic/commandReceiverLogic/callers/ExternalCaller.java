package commandLogic.commandReceiverLogic.callers;

import commandLogic.CommandDescription;

import java.io.Serializable;

public abstract class ExternalCaller implements Serializable {
    public abstract void callReceivers(CommandDescription description, String[] lineArgs) throws Exception;
}
