package main;

import fileLogic.Loader;
import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.RequestReader;
import requestLogic.StatusRequest;
import requestLogic.dataTransferObjects.BaseRequestDTO;
import requestLogic.requestWorkers.RequestWorkerManager;
import requestLogic.requests.RequestDTOMapper;
import requestLogic.requests.RequestTypeVisitor;
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
                RequestReader<BaseRequestDTO> rqReader = new RequestReader<>(rq.getInputStream());
                BaseRequestDTO brDTO = rqReader.readObject();
                var request = RequestDTOMapper.toRequest(brDTO);
                request.setConnection(connection);
                request.setFrom(rq.getCallerBack());
                RequestWorkerManager worker = new RequestWorkerManager();
                RequestTypeVisitor visitor = new RequestTypeVisitor();
                request.accept(visitor);
                worker.workWithRequest(request, brDTO, visitor.getRequestType());
            } catch (IOException e) {
                logger.error("Something went wrong during I/O", e);
            } catch (ClassNotFoundException e) {
                logger.error("Class not Found");
            } catch (RuntimeException e) {
                logger.fatal(e);
            }
        }
    }
}