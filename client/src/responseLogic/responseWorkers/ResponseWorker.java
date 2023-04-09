package responseLogic.responseWorkers;

import dataTransferObjects.responses.BaseResponseDTO;
import responseLogic.responses.BaseResponse;

public interface ResponseWorker {
    void workWithResponse(BaseResponse response, BaseResponseDTO dto);
}
