package requestLogic.requestWorkers;

import commandManager.CommandManager;
import commandManager.commands.ArgumentConsumer;
import dataTransferObjects.requests.ArgumentCommandClientRequestDTO;
import dataTransferObjects.requests.BaseRequestDTO;
import exceptions.InvalidRequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.dtoMappers.DTOMapper;
import requestLogic.requestWorkers.argumentTypeResolver.ArgumentResolverManager;
import requestLogic.requests.ArgumentCommandClientRequest;
import requestLogic.requests.BaseRequest;

public class ArgumentCommandClientRequestWorker<T, Y> implements RequestWorker {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    @Override
    public void workWithRequest(BaseRequest request, BaseRequestDTO dto) {
        try {

            @SuppressWarnings("unchecked") ArgumentCommandClientRequest<T> requestToWork = (ArgumentCommandClientRequest<T>) request;
            @SuppressWarnings("unchecked") ArgumentCommandClientRequestDTO<T> requestDTOtoWork = (ArgumentCommandClientRequestDTO<T>) dto;
            requestToWork.setCommand(DTOMapper.convertFromDTO(requestDTOtoWork.getCommand(), "commandManager.commands"));
            //requestToWork.setArgument(DTOMapper.convertFromDTO(requestDTOtoWork.getArgument(), "models")); // неудачно
            //noinspection unchecked
            requestToWork.setArgument(new ArgumentResolverManager<T, Y>().resolve((Y) requestDTOtoWork.getArgument()));
            @SuppressWarnings("unchecked") ArgumentConsumer<T> argCommand = (ArgumentConsumer<T>) requestToWork.getCommand();
            argCommand.setObj(requestToWork.getArgument());
            CommandManager manager = new CommandManager();
            manager.executeCommand(requestToWork);

        } catch (ClassNotFoundException e) {
            logger.fatal("Class not found...", e);
        } catch (InvalidRequestException e) {
            logger.fatal("got an invalid request", e);
        }
    }
}
