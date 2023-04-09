package requestLogic.dtoMappers;

import commandLogic.commands.BaseCommand;
import dataTransferObjects.requests.ArgumentCommandClientRequestDTO;

public class ArgumentCommandRequestDTOMapper<T> extends CommandRequestDTOMapper {
    public ArgumentCommandClientRequestDTO<T> argumentCommandRequestDTOMapper(BaseCommand source, String[] args, T argument) throws ClassNotFoundException {
        ArgumentCommandClientRequestDTO<T> argRequestDTO = new ArgumentCommandClientRequestDTO<>(super.commandRequestDTOMapper(source, args));
        argRequestDTO.setArgument(argument);
        return argRequestDTO;
    }
}
