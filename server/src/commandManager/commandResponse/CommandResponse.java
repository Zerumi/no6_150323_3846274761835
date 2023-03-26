package commandManager.commandResponse;

public class CommandResponse {
    private final String response;
    private final int statusCode;

    public CommandResponse(String response, int statusCode) {
        this.response = response;
        this.statusCode = statusCode;
    }

    public static CommandResponse ofString(String s) {
        return new CommandResponse(s, 200);
    }
}
