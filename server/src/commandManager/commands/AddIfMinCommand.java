package commandManager.commands;

import models.Route;
import models.comparators.RouteDistanceComparator;
import models.handlers.CollectionHandler;
import models.handlers.RouteIDHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responses.CommandStatusResponse;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;

/**
 * Adds element if it's value lower than min value.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddIfMinCommand implements BaseCommand, ArgumentConsumer<Route> {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.addIfMin");
    private CommandStatusResponse response;
    private Route obj;

    @Override
    public String getName() {
        return "add_if_min";
    }

    @Override
    public String getDescr() {
        return "Adds element if it's value lower than min value.";
    }

    @Override
    public String getArgs() {
        return "{element}";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        if (obj.compareTo(collectionHandler.getMin(new RouteDistanceComparator())) < 0) {
            collectionHandler.addElementToCollection(obj);
            response = CommandStatusResponse.ofString("Element added!");
        } else {
            response = new CommandStatusResponse("Element not added: it's not lower than min value.", 3);
        }

        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }

    @Override
    public void setObj(Route obj) {
        this.obj = obj;
        obj.setId(RouteIDHandler.getInstance().getNextID());
        obj.setCreationDate(Date.from(Instant.now()));
    }
}
