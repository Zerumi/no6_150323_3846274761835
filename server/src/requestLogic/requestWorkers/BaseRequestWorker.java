package requestLogic.requestWorkers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.dataTransferObjects.BaseRequestDTO;
import requestLogic.requests.BaseRequest;

public class BaseRequestWorker implements RequestWorker {

    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    @Override
    public void workWithRequest(BaseRequest request, BaseRequestDTO dto) {

    }
}
