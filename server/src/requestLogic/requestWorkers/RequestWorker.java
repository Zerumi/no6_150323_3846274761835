package requestLogic.requestWorkers;

import requestLogic.dataTransferObjects.BaseRequestDTO;
import requestLogic.requests.BaseRequest;

public interface RequestWorker {
    void workWithRequest(BaseRequest request, BaseRequestDTO dto);
}
