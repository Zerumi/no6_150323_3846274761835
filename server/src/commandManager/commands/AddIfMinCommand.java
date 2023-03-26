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
 * Adds element if it's value lower than min value.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddIfMinCommand implements BaseCommand {
    private CommandResponse response;
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
            System.out.println("Element added!");
        } else {
            System.out.println("Element not added: it's not lower than min value.");
        }

    }

    @Override
    public CommandResponse getResponse() {
        return response;
    }
}
