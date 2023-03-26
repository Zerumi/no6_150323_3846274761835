package main;

import commandManager.CommandExecutor;
import commandManager.CommandMode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serverLogic.ServerConnection;
import serverLogic.ServerConnectionHandler;
import serverLogic.UdpServerConnectionFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Program entry point class. Contains main() method.
 * This program is managing collection of type <code>HashSet&#8249;Route></code>
 *
 * @author zerumi
 * @since 1.0
 */
public class Main {
    @SuppressWarnings("SpellCheckingInspection")
    public static final String HOST_ADDRESS = "se.ifmo.ru";
    public static final int PORT = 44456;
    private static final Logger logger = LogManager.getLogger("lab6");

    /**
     * Program entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // server connecting
        try {
            //ServerConnection connection = new UdpServerConnectionFactory().openConnection(InetAddress.getByName(HOST_ADDRESS), PORT);
            ServerConnection connection = new UdpServerConnectionFactory().openConnection(InetAddress.getLocalHost(), PORT);
            ServerConnectionHandler.setServerConnection(connection);
            connection.openConnection();

            CommandExecutor executor = new CommandExecutor();
            executor.startExecuting(System.in, CommandMode.CLI_UserMode);


            logger.info("sent some data");
        } catch (UnknownHostException ex) {
            logger.fatal("Can't find host.");
        } catch (IOException ex) {
            logger.error("Something went wrong during IO operations.");
        }
    }
}