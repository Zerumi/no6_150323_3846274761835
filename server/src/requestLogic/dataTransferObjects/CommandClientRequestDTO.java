package requestLogic.dataTransferObjects;

import commandManager.commands.BaseCommand;

import java.io.Serializable;

public class CommandClientRequestDTO extends BaseRequestDTO implements Serializable {
    private BaseCommand command;
    private String[] lineArgs;

    public BaseCommand getCommand() {
        return command;
    }

    public void setCommand(BaseCommand command) {
        this.command = command;
    }

    public String[] getLineArgs() {
        return lineArgs;
    }

    public void setLineArgs(String[] lineArgs) {
        this.lineArgs = lineArgs;
    }
}
