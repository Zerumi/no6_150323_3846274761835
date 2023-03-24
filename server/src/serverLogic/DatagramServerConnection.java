package serverLogic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class DatagramServerConnection implements ServerConnection {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");
    private final int port;

    protected DatagramServerConnection(int port) {
        this.port = port;
    }

    public void openListening() {
        byte[] buffer = new byte[128];
        while (true) {
            try (DatagramSocket ds = new DatagramSocket(port)) {
                DatagramPacket dp;
                dp = new DatagramPacket(buffer, buffer.length);
                ds.receive(dp);

                logger.info("Received connection.");
                logger.info("Bytes: " + Arrays.toString(dp.getData()));
            } catch (IOException e) {
                logger.error("Something went wrong during I/O.");
            }
        }
    }
}
