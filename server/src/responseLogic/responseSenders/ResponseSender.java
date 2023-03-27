package responseLogic.responseSenders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.CallerBack;
import responseLogic.dataTransferObjects.BaseResponseDTO;
import serverLogic.ServerConnection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ResponseSender {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    public static void sendResponse(BaseResponseDTO response, ServerConnection connection, CallerBack to) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(response);

        connection.sendData(bos.toByteArray(), to.getAddress(), to.getPort());
        logger.info("response sent.");
    }
}
