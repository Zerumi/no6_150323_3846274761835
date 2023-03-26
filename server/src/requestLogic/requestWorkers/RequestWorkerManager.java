package requestLogic.requestWorkers;

import exceptions.UnsupportedRequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.requests.BaseRequest;

import java.util.LinkedHashMap;
import java.util.Optional;

public class RequestWorkerManager {

    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    private final LinkedHashMap<String, RequestWorker> workers = new LinkedHashMap<>();

    public RequestWorkerManager() {
        workers.put("BaseRequest", new BaseRequestWorker());
        workers.put("CommandClientRequest", new CommandClientRequestWorker());
        workers.put("ArgumentClientRequest", new ArgumentClientRequestWorker());
    }

    public void workWithRequest(BaseRequest request, String requestType) {
        try {
            Optional.ofNullable(workers.get(requestType)).orElseThrow(() -> new UnsupportedRequestException("Указанный запрос не может быть обработан")).workWithRequest(request);
        } catch (UnsupportedRequestException ex) {
            logger.error("Got an invalid request.");
        }
    }
}
