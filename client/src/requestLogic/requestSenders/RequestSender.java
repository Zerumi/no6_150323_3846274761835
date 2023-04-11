package requestLogic.requestSenders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requests.BaseRequest;
import responseLogic.ResponseReader;
import responses.BaseResponse;
import serverLogic.ServerConnection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class RequestSender {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    public BaseResponse sendRequest(BaseRequest request, ServerConnection connection) throws IOException {
        BaseResponse response = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(request);
            ResponseReader reader = new ResponseReader(connection.sendData(bos.toByteArray()));
            response = reader.readObject();
            logger.info("Request sent");
        } catch (ClassNotFoundException e) {
            logger.error("Response class not found.");
        }
        return response;
    }
}
