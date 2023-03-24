package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serverLogic.DatagramServerConnectionFactory;
import serverLogic.ServerConnection;

import java.io.IOException;

public class Main {
    public static final int PORT = 44456;
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    public static void main(String[] args) {

        logger.trace("This is a server!");

        try {
            ServerConnection connection = new DatagramServerConnectionFactory().initializeServer(PORT);
            connection.openListening();
        } catch (IOException ex) {
            logger.error("Something went wrong during IO.");
        }
    }
}