package main;

import commandManager.commands.BaseCommand;
import exceptions.WrongAmountOfArgumentsException;
import fileLogic.Loader;
import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.RequestReader;
import requestLogic.StatusRequest;
import serverLogic.DatagramServerConnectionFactory;
import serverLogic.ServerConnection;

import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static final int PORT = 44456;
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    /**
     * Environment key to XML file for store collection.
     */
    public static final String ENV_KEY = "lab5";

    public static void main(String[] args) {
        CollectionHandler<HashSet<Route>, Route> handler = RoutesHandler.getInstance();

        logger.trace("This is a server!");

        // load collection
        Loader<HashSet<Route>, Route> loader = new Loader<>(handler.getCollection().getClass(), Route.class);
        handler.setCollection(loader.loadFromXMLbyEnvKey(ENV_KEY));
        System.out.println("Loaded " + handler.getCollection().size() + " elements total.");
        System.out.println();

        // commands
        logger.trace("Welcome to CLI server! Now you are operating with collection of type " + handler.getCollection().getClass().getName() + ", filled with elements of type " + handler.getFirstOrNew().getClass().getName());
        logger.trace("Now server is listening a requests.");
        //CommandExecutor executor = new CommandExecutor();
        //executor.startExecuting(System.in, CommandMode.CLI_UserMode);

        // connection
        ServerConnection connection = new DatagramServerConnectionFactory().initializeServer(PORT);
        while (true) {
            try {
                StatusRequest rq = connection.listenAndGetData();
                if (rq.getCode() < 0) // skip
                {
                    logger.debug("Status code: " + rq.getCode());
                    continue;
                }
                RequestReader<BaseCommand> cmdReader = new RequestReader<>(rq.getInputStream());
                cmdReader.readObject().execute(new String[0]); // TODO: args
            } catch (WrongAmountOfArgumentsException e) {
                logger.error("Wrong amount of arguments.");
            } catch (IOException e) {
                logger.error("Something went wrong during I/O.");
            } catch (ClassNotFoundException e) {
                logger.fatal("Cannot interpreter obj type.");
            }
        }
    }
}