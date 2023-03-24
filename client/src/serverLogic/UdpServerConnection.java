package serverLogic;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UdpServerConnection implements ServerConnection {

    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");
    DatagramChannel channel;
    SocketAddress address;

    protected UdpServerConnection(DatagramChannel channel, SocketAddress address) {
        this.channel = channel;
        this.address = address;
    }


    /**
     * Method for open a connection.
     */
    @Override
    public void openConnection() throws IOException {
        if (!channel.isConnected()) {
            channel.connect(address);
            logger.log(Level.INFO, "Connected to: " + address);
        }
    }

    /**
     * Method for close a connection
     */
    @Override
    public void closeConnection() throws IOException {
        if (channel.isConnected()) {
            channel.close();
        }
    }

    @Override
    public void sendData(byte[] bytesToSend) throws IOException {
        if (channel.isConnected()) {
            var buf = ByteBuffer.wrap(bytesToSend);
            channel.send(buf, address);
        }
    }
}
