package commandManager.commands;

import commandManager.commandResponse.CommandResponse;
import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;

import java.util.HashSet;

/**
 * Shows information about the collection.
 *
 * @author Zerumi
 * @since 1.0
 */
public class InfoCommand implements BaseCommand {
    CommandResponse response;
    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescr() {
        return "Shows information about the collection.";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Route>, Route> handler = RoutesHandler.getInstance();

        HashSet<Route> collection = handler.getCollection();

        System.out.println("Now you are operating with collection of type " + collection.getClass().getName() + ", filled with elements of type " + handler.getFirstOrNew().getClass().getName());
        System.out.println("Size of the collection is " + collection.size());
        System.out.println("Init date: " + handler.getInitDate());
    }

    @Override
    public CommandResponse getResponse() {
        return response;
    }
}
