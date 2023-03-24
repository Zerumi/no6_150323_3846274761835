package main;

import commandManager.CommandExecutor;
import fileLogic.Loader;
import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serverLogic.ServerConnection;
import serverLogic.ServerConnectionHandler;
import serverLogic.UdpServerConnectionFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;

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
     * Environment key to XML file for store collection.
     */
    public static final String ENV_KEY = "lab5";

    /**
     * Program entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        CollectionHandler<HashSet<Route>, Route> handler = RoutesHandler.getInstance();

        // load collection
        Loader<HashSet<Route>, Route> loader = new Loader<>(handler.getCollection().getClass(), Route.class);
        handler.setCollection(loader.loadFromXMLbyEnvKey(ENV_KEY));
        System.out.println("Loaded " + handler.getCollection().size() + " elements total.");
        System.out.println();

        // commands
        System.out.println("Welcome to CLI! Now you are operating with collection of type " + handler.getCollection().getClass().getName() + ", filled with elements of type " + handler.getFirstOrNew().getClass().getName());
        System.out.println("Now you can enter the commands. Use help for reference.");
        CommandExecutor executor = new CommandExecutor();
        //executor.startExecuting(System.in, CommandMode.CLI_UserMode);

        // server connecting
        try {
            //ServerConnection connection = new UdpServerConnectionFactory().openConnection(InetAddress.getByName(HOST_ADDRESS), PORT);
            ServerConnection connection = new UdpServerConnectionFactory().openConnection(InetAddress.getLocalHost(), PORT);
            ServerConnectionHandler.setServerConnection(connection);
            connection.openConnection();

            connection.sendData(new byte[]{1, 2, 3});
            logger.info("sent some data");
        } catch (UnknownHostException ex) {
            logger.fatal("Can't find host.");
        } catch (IOException ex) {
            logger.error("Something went wrong during IO operations.");
        }
    }
}