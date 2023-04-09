package requestLogic.requestWorkers;

import commandManager.CommandManager;
import dataTransferObjects.requests.BaseRequestDTO;
import dataTransferObjects.requests.CommandClientRequestDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.dtoMappers.DTOMapper;
import requestLogic.requests.BaseRequest;
import requestLogic.requests.CommandClientRequest;

public class CommandClientRequestWorker implements RequestWorker {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    @Override
    public void workWithRequest(BaseRequest request, BaseRequestDTO dto) {
        try {
            CommandClientRequest requestToWork = (CommandClientRequest) request;
            CommandClientRequestDTO requestDTOtoWork = (CommandClientRequestDTO) dto;
            requestToWork.setCommand(DTOMapper.convertFromDTO(requestDTOtoWork.getCommand(), "commandManager.commands"));
            CommandManager manager = new CommandManager();
            manager.executeCommand(requestToWork);
        } catch (ClassNotFoundException e) {
            logger.fatal("Class not found!", e);
        }
    }
}
