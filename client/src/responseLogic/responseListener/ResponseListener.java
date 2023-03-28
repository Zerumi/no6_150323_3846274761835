package responseLogic.responseListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.ResponseReader;
import responseLogic.dataTransferObjects.BaseResponseDTO;
import responseLogic.dtoMappers.DTOMapper;
import responseLogic.responseWorkers.ResponseWorkerManager;
import responseLogic.responses.BaseResponse;
import serverLogic.ServerConnectionHandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.PortUnreachableException;
import java.nio.channels.ClosedChannelException;

public class ResponseListener {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    private static ResponseListener instance;
    private final Thread listenResponses;

    private ResponseListener() {
        listenResponses = new Thread(() -> {
            boolean workingFlag = true;
            while (workingFlag) {
                try (InputStream stream = ServerConnectionHandler.getCurrentConnection().listenServer()) {
                    logger.trace("received");
                    ResponseReader<BaseResponseDTO> reader = new ResponseReader<>(stream);
                    BaseResponseDTO responseDTO = reader.readObject();
                    BaseResponse response = DTOMapper.convertFromDTO(responseDTO, "responseLogic.responses");
                    ResponseWorkerManager manager = new ResponseWorkerManager();
                    manager.workWithRequest(response, responseDTO, response.getClass().getSimpleName());
                } catch (PortUnreachableException e) {
                    logger.warn("Server is unavailable. Please, wait until server will came back.");
                } catch (ClosedChannelException e) {
                    logger.warn("Channel has closed. Exiting...");
                    workingFlag = false;
                } catch (IOException e) {
                    logger.error("Something went wrong during I/O operations.");
                } catch (ClassNotFoundException e) {
                    logger.error("Response class not found.");
                }
            }
        });
    }

    public static ResponseListener getInstance() {
        if (instance == null) {
            instance = new ResponseListener();
        }
        return instance;
    }

    public Thread getListeningThread() {
        return listenResponses;
    }
}
