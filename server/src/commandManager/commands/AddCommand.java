package commandManager.commands;

import commandManager.commandResponse.CommandResponse;
import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import requestLogic.dataTransferObjects.models.RouteDTO;
import requestLogic.dtoMappers.RouteDTOMapper;

import java.util.HashSet;

/**
 * Adds new element to collection.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddCommand implements BaseCommand {
    private CommandResponse response;

    private RouteDTO obj;

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescr() {
        return "Adds new element to collection.";
    }

    @Override
    public String getArgs() {
        return "{element}";
    }

    @Override
    public void execute(String[] args) throws ClassNotFoundException {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        collectionHandler.addElementToCollection(RouteDTOMapper.toRoute(obj));

        System.out.println("Element added!");
    }

    @Override
    public CommandResponse getResponse() {
        return response;
    }
}
