package requestLogic.dataTransferObjects;

import requestLogic.dataTransferObjects.commands.BaseCommandDTO;

import java.io.Serializable;

public class CommandClientRequestDTO extends BaseRequestDTO implements Serializable {
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
