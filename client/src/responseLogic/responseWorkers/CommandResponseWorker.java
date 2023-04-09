package responseLogic.responseWorkers;

import dataTransferObjects.responses.BaseResponseDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.responses.BaseResponse;
import responseLogic.responses.CommandStatusResponse;

public class CommandResponseWorker extends BaseResponseWorker {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    @Override
    public void workWithResponse(BaseResponse response, BaseResponseDTO dto) {
        CommandStatusResponse responseToWork = (CommandStatusResponse) response;
        logger.info("Status code: " + responseToWork.getStatusCode());
        logger.info("Response:\n" + responseToWork.getResponse());
    }
}
