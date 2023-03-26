package commandManager.commands;

import commandManager.commandResponse.CommandResponse;
import exceptions.WrongAmountOfArgumentsException;
import main.Utilities;
import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;

import java.util.HashSet;
import java.util.Objects;

/**
 * Removes element from collection by id.
 *
 * @author Zerumi
 * @since 1.0
 */
public class RemoveByIdCommand implements BaseCommand {
    CommandResponse response;

    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescr() {
        return "Removes element from collection by id.";
    }

    @Override
    public String getArgs() {
        return "id";
    }

    @Override
    public void execute(String[] args) throws WrongAmountOfArgumentsException {
        Utilities.checkArgumentsOrThrow(args.length, 1);

        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        Long finalId = Utilities.handleUserInputID(args[1]);
        if (finalId == null) return;

        collectionHandler.getCollection().removeIf(route -> Objects.equals(route.getId(), finalId));

        System.out.println("Executed.");
    }

    @Override
    public CommandResponse getResponse() {
        return response;
    }
}
