package requestLogic.requests;

public class RequestTypeVisitor implements RequestVisitor {
    private String requestType;

    public void visit(BaseRequest request) {
        requestType = "BaseRequest";
    }

    public void visit(CommandClientRequest request) {
        requestType = "CommandClientRequest";
    }

    public <T> void visit(ArgumentClientRequest<T> request) {
        requestType = "ArgumentClientRequest";
    }

    public String getRequestType() {
        return requestType;
    }
}
