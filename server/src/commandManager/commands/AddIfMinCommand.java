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
 * Adds element if it's value lower than min value.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddIfMinCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.addIfMin");
    private CommandStatusResponse response;
    private RouteDTO obj;

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
    public void execute(String[] args) throws ClassNotFoundException {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        Route route = RouteDTOMapper.toRoute(obj);

        if (route.compareTo(collectionHandler.getMin(new RouteDistanceComparator())) < 0) {
            collectionHandler.addElementToCollection(route);
            response = CommandStatusResponse.ofString("Element added!");
        } else {
            response = CommandStatusResponse.ofString("Element not added: it's not lower than min value.");
        }

        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
