package commandManager.commands;

import models.Route;
import models.comparators.RouteDistanceComparator;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.dataTransferObjects.models.RouteDTO;
import requestLogic.dtoMappers.RouteDTOMapper;
import responseLogic.responses.CommandStatusResponse;

import java.util.HashSet;

/**
 * Removes elements from collection greater than given in argument.
 *
 * @author Zerumi
 * @since 1.0
 */
public class RemoveGreaterCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.rmGreater");
    private CommandStatusResponse response;
    private RouteDTO obj;

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
    public void execute(String[] args) throws ClassNotFoundException {
        RouteDistanceComparator comparator = new RouteDistanceComparator();

        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        Route greaterThan = RouteDTOMapper.toRoute(obj);
        logger.info("Distance: " + greaterThan.getDistance());

        var iterator = collectionHandler.getCollection().iterator();

        int count = 0;

        while (iterator.hasNext()) {
            var current = iterator.next();
            logger.info("Comparing: current -- " + current.getDistance() + " vs " + greaterThan.getDistance());
            if (comparator.compare(current, greaterThan) > 0) {
                logger.info(" -- Greater / Will be removed...");
                count++;
            } else {
                logger.info(" -- Lower.");
            }
        }

        collectionHandler.getCollection().removeIf(current -> comparator.compare(current, greaterThan) > 0);
        response = CommandStatusResponse.ofString("Removed " + count + " elements");
        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
