package serverLogic;

import java.io.IOException;

/**
 * Provides abstract server connection. Use factory methods to create the connection.
 *
 * @author zerumi
 * @see ServerConnectionFactory
 * @since 2.0
 */
public interface ServerConnection {
    /**
     * Method for open a connection.
     */
    void openConnection() throws IOException;

    /**
     * Method for close a connection
     */
    void closeConnection() throws IOException;

    void sendData(byte[] bytesToSend) throws IOException;
}
