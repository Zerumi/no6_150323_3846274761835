package requestLogic.dtoMappers;

import commandLogic.commands.BaseCommand;
import dataTransferObjects.commands.BaseCommandDTO;
import dataTransferObjects.requests.CommandClientRequestDTO;

public class CommandRequestDTOMapper {
    public CommandClientRequestDTO commandRequestDTOMapper(BaseCommand source, String[] args) throws ClassNotFoundException {
        CommandClientRequestDTO clientRequestDTO = new CommandClientRequestDTO();
        BaseCommandDTO cmd = new DTOMapper().convertToDTO(source, "dataTransferObjects.commands");
        clientRequestDTO.setCommand(cmd);
        clientRequestDTO.setLineArgs(args);
        return clientRequestDTO;
    }
}
