package requestLogic;

import java.io.InputStream;
import java.net.InetAddress;

public class StatusRequestBuilder {

    StatusRequest result;

    private StatusRequestBuilder() {
        result = new StatusRequest();
    }

    public static StatusRequestBuilder initialize() {
        return new StatusRequestBuilder();
    }

    public StatusRequest build() {
        return result;
    }

    public StatusRequestBuilder setObjectStream(InputStream stream) {
        result.setInputStream(stream);
        return this;
    }

    public StatusRequestBuilder setCallerBack(InetAddress address, int port) {
        CallerBack callerBack = new CallerBack(address, port);
        result.setCallerBack(callerBack);
        return this;
    }

    public StatusRequestBuilder setCode(int code) {
        result.setCode(code);
        return this;
    }
}
