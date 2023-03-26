package requestLogic.requestWorkers;

import commandManager.CommandManager;
import commandManager.commands.BaseCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import requestLogic.dataTransferObjects.BaseRequestDTO;
import requestLogic.dataTransferObjects.CommandClientRequestDTO;
import requestLogic.requests.BaseRequest;
import requestLogic.requests.CommandClientRequest;
import requestLogic.requests.RequestUtils;

public class CommandClientRequestWorker implements RequestWorker {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    @Override
    public void workWithRequest(BaseRequest request, BaseRequestDTO dto) {
        try {
            CommandClientRequest requestToWork = (CommandClientRequest) request;
            CommandClientRequestDTO requestDTOtoWork = (CommandClientRequestDTO) dto;
            ModelMapper mapper = new ModelMapper();
            requestToWork.setCommand((BaseCommand) mapper.map(requestDTOtoWork.getCommand(), Class.forName("commandManager.commands." + RequestUtils.dtoNameConverter(requestDTOtoWork.getCommand().getClass().getSimpleName()))));
            CommandManager manager = new CommandManager();
            manager.executeCommand(requestToWork);
        } catch (ClassNotFoundException e) {
            logger.fatal("Class not found!", e);
        }
    }
}
