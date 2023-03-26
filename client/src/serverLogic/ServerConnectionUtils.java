package serverLogic;

import commandManager.commands.BaseCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import requestLogic.dataTransferObjects.CommandClientRequestDTO;
import requestLogic.dataTransferObjects.commands.BaseCommandDTO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ServerConnectionUtils {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    public static void sendNonArgumentCommand(BaseCommand command, String[] args, ServerConnection connection) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            CommandClientRequestDTO clientRequestDTO = new CommandClientRequestDTO();
            ModelMapper mapper = new ModelMapper();
            BaseCommandDTO cmd = (BaseCommandDTO) mapper.map(command, Class.forName("requestLogic.dataTransferObjects.commands." + command.getClass().getSimpleName() + "DTO"));
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
