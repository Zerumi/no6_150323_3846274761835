package commandManager.commands;

import commandManager.commandResponse.CommandResponse;
import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;

import java.util.HashSet;

/**
 * Clears collection
 *
 * @author Zerumi
 * @since 1.0
 */
public class ClearCommand implements BaseCommand {
    CommandResponse response;
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescr() {
        return "Clears collection";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        collectionHandler.clearCollection();

        System.out.println("Cleared!");
    }

    @Override
    public CommandResponse getResponse() {
        return response;
    }
}
