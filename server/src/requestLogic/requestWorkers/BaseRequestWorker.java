package requestLogic.requestWorkers;

import dataTransferObjects.requests.BaseRequestDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.requests.BaseRequest;

public class BaseRequestWorker implements RequestWorker {

    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    @Override
    public void workWithRequest(BaseRequest request, BaseRequestDTO dto) {
        logger.info("we've got base request wow");
    }
}
