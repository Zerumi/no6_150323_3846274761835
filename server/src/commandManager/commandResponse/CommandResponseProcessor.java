package commandManager.commandResponse;

import requestLogic.CallerBack;
import serverLogic.ServerConnection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CommandResponseProcessor {
    public static void sendResponse(CommandResponse response, ServerConnection connection, CallerBack to) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(response);

        connection.sendData(bos.toByteArray(), to.getAddress());
    }
}
