package requestLogic.requestWorkers;

import requestLogic.requests.BaseRequest;

public interface RequestWorker {
    void workWithRequest(BaseRequest request);
}
