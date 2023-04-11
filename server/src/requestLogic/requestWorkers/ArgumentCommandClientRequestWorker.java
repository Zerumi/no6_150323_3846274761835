package requestLogic.requestWorkers;

import commandManager.CommandManager;
import commandManager.commands.ArgumentConsumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.requests.ServerRequest;
import requests.ArgumentCommandClientRequest;

public class ArgumentCommandClientRequestWorker<T, Y> implements RequestWorker {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    @Override
    public void workWithRequest(ServerRequest request) {
        ArgumentCommandClientRequest<T> requestToWork = (ArgumentCommandClientRequest<T>) request.getUserRequest();
        ArgumentConsumer<T> argCommand = (ArgumentConsumer<T>) requestToWork.getCommandDescription();
        argCommand.setObj(requestToWork.getArgument());
        CommandManager manager = new CommandManager();
        //manager.executeCommand(requestToWork);
    }
}
