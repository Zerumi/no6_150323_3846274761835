package commandManager.commands;

import models.Route;
import models.comparators.RouteDistanceComparator;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responses.CommandStatusResponse;

import java.util.HashSet;

/**
 * Removes elements from collection greater than given in argument.
 *
 * @author Zerumi
 * @since 1.0
 */
public class RemoveGreaterCommand implements BaseCommand, ArgumentConsumer<Route> {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.rmGreater");
    private CommandStatusResponse response;
    private Route obj;

    @Override
    public String getName() {
        return "remove_greater";
    }

    @Override
    public String getDescr() {
        return "Removes elements from collection greater than given in argument. Comparing is set by distance.";
    }

    @Override
    public String getArgs() {
        return "{element}";
    }

    @Override
    public void execute(String[] args) {
        RouteDistanceComparator comparator = new RouteDistanceComparator();

        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        logger.debug("Distance: " + obj.getDistance());

        var iterator = collectionHandler.getCollection().iterator();

        int count = 0;

        while (iterator.hasNext()) {
            var current = iterator.next();
            logger.debug("Comparing: current -- " + current.getDistance() + " vs " + obj.getDistance());
            if (comparator.compare(current, obj) > 0) {
                logger.debug(" -- Greater / Will be removed...");
                count++;
            } else {
                logger.debug(" -- Lower.");
            }
        }

        collectionHandler.getCollection().removeIf(current -> comparator.compare(current, obj) > 0);
        response = CommandStatusResponse.ofString("Removed " + count + " elements");
        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }

    @Override
    public void setObj(Route obj) {
        this.obj = obj;
    }
}
