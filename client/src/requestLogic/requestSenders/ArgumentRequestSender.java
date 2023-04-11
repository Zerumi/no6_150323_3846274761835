package requestLogic.requestSenders;

import commandLogic.CommandDescription;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requests.ArgumentCommandClientRequest;
import serverLogic.ServerConnection;

import java.io.IOException;
import java.io.Serializable;
import java.net.PortUnreachableException;

public class ArgumentRequestSender<T extends Serializable> {

    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    public void sendCommand(CommandDescription command, String[] args, T argument, ServerConnection connection) {
        try {
            ArgumentCommandClientRequest<T> rq = new ArgumentCommandClientRequest<>(command, args, argument);
            logger.info("Sending command request...");
            new RequestSender().sendRequest(rq, connection);
        } catch (PortUnreachableException e) {
            logger.warn("Server is unavailable. Please, wait until server will came back.");
        } catch (IOException e) {
            logger.error("Something went wrong during I/O operations.");
        }
    }
}
