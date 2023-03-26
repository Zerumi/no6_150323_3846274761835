package commandManager.commands;

import commandManager.commandResponse.CommandResponse;
import models.Route;
import models.comparators.RouteDistanceComparator;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import requestLogic.dataTransferObjects.models.RouteDTO;
import requestLogic.dtoMappers.RouteDTOMapper;

import java.util.HashSet;

/**
 * Add element if it's value greater than max value.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddIfMaxCommand implements BaseCommand {
    private CommandResponse response;
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
            System.out.println("Element added!");
        } else {
            System.out.println("Element not added: it's not greater than max value.");
        }
    }

    @Override
    public CommandResponse getResponse() {
        return response;
    }
}
