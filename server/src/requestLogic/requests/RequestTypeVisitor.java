package requestLogic.requests;

public class RequestTypeVisitor implements RequestVisitor {
    private String requestType;

    public void visit(BaseRequest request) {
        requestType = "BaseRequest";
    }

    public void visit(CommandClientRequest request) {
        requestType = "CommandClientRequest";
    }

    public String getRequestType() {
        return requestType;
    }
}
