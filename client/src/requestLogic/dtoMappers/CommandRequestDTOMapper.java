package requestLogic.dtoMappers;

import commandManager.commands.BaseCommand;
import requestLogic.dataTransferObjects.CommandClientRequestDTO;
import requestLogic.dataTransferObjects.commands.BaseCommandDTO;

public class CommandRequestDTOMapper {
    public static CommandClientRequestDTO commandRequestDTOMapper(BaseCommand source, String[] args) throws ClassNotFoundException {
        CommandClientRequestDTO clientRequestDTO = new CommandClientRequestDTO();
        BaseCommandDTO cmd = DTOMapper.convertToDTO(source, "requestLogic.dataTransferObjects.commands");
        clientRequestDTO.setCommand(cmd);
        clientRequestDTO.setLineArgs(args);
        return clientRequestDTO;
    }
}
