package responseLogic.responseWorkers;

import responseLogic.dataTransferObjects.BaseResponseDTO;
import responseLogic.responses.BaseResponse;

public interface ResponseWorker {
    void workWithResponse(BaseResponse response, BaseResponseDTO dto);
}
