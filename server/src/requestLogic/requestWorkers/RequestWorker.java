package requestLogic.requestWorkers;

import dataTransferObjects.requests.BaseRequestDTO;
import requestLogic.requests.BaseRequest;

public interface RequestWorker {
    void workWithRequest(BaseRequest request, BaseRequestDTO dto);
}
