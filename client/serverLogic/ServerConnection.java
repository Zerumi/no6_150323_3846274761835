package serverLogic;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;

public class ServerConnection {

    DatagramChannel channel;
    SocketAddress address;

    private ServerConnection(DatagramChannel channel, SocketAddress address)
    {
        this.channel = channel;
        this.address = address;
    }
    public static ServerConnection openConnection(InetAddress host, int port) throws IOException {
        DatagramChannel dc;
        SocketAddress addr;
        addr = new InetSocketAddress(host,port);
        dc = DatagramChannel.open();
        return new ServerConnection(dc, addr);
    }
}
