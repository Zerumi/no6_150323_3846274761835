package responseLogic.responseWorkers;

import exceptions.UnsupportedResponseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.dataTransferObjects.BaseResponseDTO;
import responseLogic.responses.BaseResponse;

import java.util.LinkedHashMap;
import java.util.Optional;

public class ResponseWorkerManager {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    private final LinkedHashMap<String, ResponseWorker> workers = new LinkedHashMap<>();

    public ResponseWorkerManager() {
        workers.put("BaseResponse", new BaseResponseWorker());
        workers.put("CommandStatusResponse", new CommandResponseWorker());
    }

    public void workWithRequest(BaseResponse response, BaseResponseDTO dto, String requestType) {
        try {
            Optional.ofNullable(workers.get(requestType)).orElseThrow(() -> new UnsupportedResponseException("Указанный запрос не может быть обработан")).workWithResponse(response, dto);
        } catch (UnsupportedResponseException ex) {
            logger.error("Got an invalid response.");
        }
    }
}
