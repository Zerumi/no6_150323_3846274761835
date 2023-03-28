package requestLogic.requestSenders;

import commandManager.commands.BaseCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.dtoMappers.CommandRequestDTOMapper;
import serverLogic.ServerConnection;

import java.io.IOException;

public class CommandRequestSender {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    public static void sendCommand(BaseCommand command, String[] args, ServerConnection connection) {
        try {
            var rq = CommandRequestDTOMapper.commandRequestDTOMapper(command, args);
            logger.info("Sending command request...");
            RequestSender.sendRequest(rq, connection);
        } catch (IOException e) {
            logger.fatal("Can't send request", e);
        } catch (ClassNotFoundException e) {
            logger.fatal("Class not found.");
        }
    }
}
