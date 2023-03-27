package requestLogic.requests;

import commandManager.commands.BaseCommand;

public class CommandClientRequest extends BaseRequest {
    private BaseCommand command;
    private String[] lineArgs;

    public void setCommand(BaseCommand command) {
        this.command = command;
    }

    public BaseCommand getCommand() {
        return command;
    }

    public String[] getLineArgs() {
        return lineArgs;
    }
}
