package requestLogic.requestWorkers;

import commandManager.CommandManager;
import requestLogic.requests.BaseRequest;
import requestLogic.requests.CommandClientRequest;

public class CommandClientRequestWorker implements RequestWorker {
    @Override
    public void workWithRequest(BaseRequest request) {
        CommandClientRequest requestToWork = (CommandClientRequest) request;
        CommandManager manager = new CommandManager();
        manager.executeCommand(requestToWork);
    }
}
