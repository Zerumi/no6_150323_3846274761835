package dataTransferObjects.requests;

import dataTransferObjects.commands.BaseCommandDTO;

public class CommandClientRequestDTO extends BaseRequestDTO {
    private BaseCommandDTO command;
    private String[] lineArgs;

    public CommandClientRequestDTO(BaseCommandDTO command, String[] lineArgs) {
        this.command = command;
        this.lineArgs = lineArgs;
    }

    public CommandClientRequestDTO() {

    }

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
