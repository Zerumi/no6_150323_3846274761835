package requestLogic.requestSenders;

import dataTransferObjects.requests.BaseRequestDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serverLogic.ServerConnection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class RequestSender {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    public void sendRequest(BaseRequestDTO request, ServerConnection connection) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(request);
        connection.sendData(bos.toByteArray());
        logger.info("Request sent");
    }
}
