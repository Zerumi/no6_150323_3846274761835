package responseLogic.responses;

public class CommandStatusResponse extends BaseResponse {

    private String response;
    private int statusCode;

    public String getResponse() {
        return response;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
