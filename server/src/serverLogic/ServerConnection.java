package serverLogic;

import requestLogic.StatusRequest;

import java.net.InetAddress;

public interface ServerConnection {
    StatusRequest listenAndGetData();

    void sendData(byte[] data, InetAddress addr, int port);
}
