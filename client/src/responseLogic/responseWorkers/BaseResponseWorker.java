package responseLogic.responseWorkers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.dataTransferObjects.BaseResponseDTO;
import responseLogic.responses.BaseResponse;

public class BaseResponseWorker implements ResponseWorker {

    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");
    @Override
    public void workWithResponse(BaseResponse response, BaseResponseDTO dto) {
        logger.info("got a base response yeah");
    }
}
