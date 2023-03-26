package models.handlers;

import models.Route;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

public class RouteIDHandler {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");

    private static Long nextID = 1L;

    private static RouteIDHandler instance;

    public static RouteIDHandler getInstance() {
        if (instance == null) {
            CollectionHandler<HashSet<Route>, Route> handler = RoutesHandler.getInstance();
            Route last = handler.getLastElement();
            if (last != null) {
                nextID = last.getId() + 1;
            }
            logger.debug("ID generator loaded. nextID is set to " + nextID);

            instance = new RouteIDHandler();
        }
        return instance;
    }

    public Long getNextID() {
        return nextID++;
    }
}
