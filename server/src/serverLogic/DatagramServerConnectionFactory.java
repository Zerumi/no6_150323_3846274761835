package serverLogic;

public class DatagramServerConnectionFactory implements ServerConnectionFactory {

    @Override
    public ServerConnection initializeServer(int port) {
        return new DatagramServerConnection(port);
    }
}
