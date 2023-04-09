package dataTransferObjects.requests;

import dataTransferObjects.commands.BaseCommandDTO;

public class CommandClientRequestDTO extends BaseRequestDTO {
    private BaseCommandDTO command;
    private String[] lineArgs;

    public BaseCommandDTO getCommand() {
        return command;
    }

    public void setCommand(BaseCommandDTO command) {
        this.command = command;
    }

    public String[] getLineArgs() {
        return lineArgs;
    }

    public void setLineArgs(String[] lineArgs) {
        this.lineArgs = lineArgs;
    }
}
