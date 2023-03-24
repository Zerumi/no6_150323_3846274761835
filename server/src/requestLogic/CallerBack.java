package requestLogic;

import serverLogic.ServerConnection;

import java.net.InetAddress;

public class CallerBack {
    private InetAddress address;
    private int port;

    public CallerBack(InetAddress address, int port) {
        this.address = address;
        this.port = port;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void callback(ServerConnection connection) {

    }
}
