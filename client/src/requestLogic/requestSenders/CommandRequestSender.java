package requestLogic.requestSenders;

import commandLogic.CommandDescription;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requests.CommandClientRequest;
import serverLogic.ServerConnection;

import java.io.IOException;
import java.net.PortUnreachableException;

public class CommandRequestSender {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    public void sendCommand(CommandDescription command, String[] args, ServerConnection connection) {
        try {
            var rq = new CommandClientRequest(command, args);
            logger.info("Sending command request...");
            new RequestSender().sendRequest(rq, connection);
        } catch (PortUnreachableException e) {
            logger.warn("Server is unavailable. Please, wait until server will came back.");
        } catch (IOException e) {
            logger.error("Something went wrong during I/O operations.");
        }
    }
}
