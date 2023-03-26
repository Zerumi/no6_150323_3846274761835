package requestLogic.requests;

import requestLogic.CallerBack;
import serverLogic.ServerConnection;

public class BaseRequest {
    private CallerBack from;
    private ServerConnection connection;

    public ServerConnection getConnection() {
        return connection;
    }

    public void setConnection(ServerConnection connection) {
        this.connection = connection;
    }

    public CallerBack getFrom() {
        return from;
    }

    public void setFrom(CallerBack from) {
        this.from = from;
    }

    public void accept(RequestVisitor visitor) {
        visitor.visit(this);
    }
}
