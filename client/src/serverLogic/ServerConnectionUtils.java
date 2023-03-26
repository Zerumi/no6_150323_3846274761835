package serverLogic;

import commandManager.commands.BaseCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.dataTransferObjects.CommandClientRequestDTO;
import requestLogic.dataTransferObjects.commands.BaseCommandDTO;
import requestLogic.dtoMappers.DTOMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ServerConnectionUtils {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    public static void sendCommand(BaseCommand command, String[] args, ServerConnection connection) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            CommandClientRequestDTO clientRequestDTO = new CommandClientRequestDTO();

            BaseCommandDTO cmd = DTOMapper.convertToDTO(command, "requestLogic.dataTransferObjects.commands");
            clientRequestDTO.setCommand(cmd);
            clientRequestDTO.setLineArgs(args);

            oos.writeObject(clientRequestDTO);
            connection.sendData(bos.toByteArray());
        } catch (IOException e) {
            logger.fatal("Can't send request");
        } catch (ClassNotFoundException e) {
            logger.fatal("Can't find class");
        }
    }
}
