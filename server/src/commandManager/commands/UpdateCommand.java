package commandManager.commands;

import commandManager.commandResponse.CommandResponse;
import exceptions.WrongAmountOfArgumentsException;
import main.Utilities;
import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import requestLogic.dataTransferObjects.models.RouteDTO;
import requestLogic.dtoMappers.RouteDTOMapper;

import java.util.HashSet;
import java.util.Objects;

/**
 * Updates element by its ID.
 *
 * @author Zerumi
 * @since 1.0
 */
public class UpdateCommand implements BaseCommand {
    private CommandResponse response;
    private RouteDTO obj;

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescr() {
        return "Updates element by it's ID.";
    }

    @Override
    public String getArgs() {
        return "id {element}";
    }

    @Override
    public void execute(String[] args) throws WrongAmountOfArgumentsException, ClassNotFoundException {
        Utilities.checkArgumentsOrThrow(args.length, 1);

        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        Long finalId = Utilities.handleUserInputID(args[1]);
        if (finalId == null) return;

        if (!collectionHandler.getCollection().removeIf(route -> Objects.equals(route.getId(), finalId))) {
            System.out.println("Element with that id doesn't exists.");
            return;
        }
        Route newObj = RouteDTOMapper.toRoute(obj);

        System.out.println("Updated ID value: " + finalId);
        newObj.setId(finalId);

        collectionHandler.addElementToCollection(newObj);

        System.out.println("Object updated!");
    }

    @Override
    public CommandResponse getResponse() {
        return response;
    }
}
