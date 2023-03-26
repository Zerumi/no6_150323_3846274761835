package requestLogic.requests;

import commandManager.commands.BaseCommand;

public class CommandClientRequest extends BaseRequest {
    private BaseCommand command;
    private String[] lineArgs;

    public BaseCommand getCommand() {
        return command;
    }

    public String[] getLineArgs() {
        return lineArgs;
    }

    public void accept(RequestVisitor visitor) {
        visitor.visit(this);
    }
}
