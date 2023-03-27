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
 * Add element if it's value greater than max value.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddIfMaxCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.addIfMax");
    private CommandStatusResponse response;
    private RouteDTO obj;

    @Override
    public String getName() {
        return "add_if_max";
    }

    @Override
    public String getDescr() {
        return "Add element if it's value greater than max value.";
    }

    @Override
    public String getArgs() {
        return "{element}";
    }

    @Override
    public void execute(String[] args) throws ClassNotFoundException {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        Route route = RouteDTOMapper.toRoute(obj);

        if (route.compareTo(collectionHandler.getMax(new RouteDistanceComparator())) > 0) {
            collectionHandler.addElementToCollection(route);
            response = CommandStatusResponse.ofString("Element added!");
        } else {
            response = CommandStatusResponse.ofString("Element not added: it's not greater than max value.");
        }

        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
