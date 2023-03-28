package responseLogic.responseSenders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.CallerBack;
import responseLogic.dataTransferObjects.CommandStatusResponseDTO;
import responseLogic.dtoMappers.DTOMapper;
import responseLogic.responses.CommandStatusResponse;
import serverLogic.ServerConnection;

import java.io.IOException;

public class CommandResponseSender {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    public static void sendResponse(CommandStatusResponse response, ServerConnection connection, CallerBack to) {
        try {
            if (response != null) {
                CommandStatusResponseDTO dto = DTOMapper.convertToDTO(response, "responseLogic.dataTransferObjects");
                ResponseSender.sendResponse(dto, connection, to);
            }
        } catch (ClassNotFoundException e) {
            logger.fatal("Class not found", e);
        } catch (IOException e) {
            logger.fatal("Something went wrong during I/O", e);
        }
    }
}
