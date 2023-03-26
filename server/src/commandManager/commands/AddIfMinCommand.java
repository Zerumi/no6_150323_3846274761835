package commandManager.commands;

import commandManager.commandResponse.CommandResponse;
import models.Route;
import models.comparators.RouteDistanceComparator;
import models.handlers.CollectionHandler;
import models.handlers.ModuleHandler;
import models.handlers.RouteNetworkHandler;
import models.handlers.RoutesHandler;

import java.util.HashSet;

/**
 * Adds element if it's value lower than min value.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddIfMinCommand implements BaseCommand {
    CommandResponse response;
    ModuleHandler<Route> handler;

    /**
     * Default constructor with handler from 1.0
     */
    public AddIfMinCommand() {
        handler = new RouteNetworkHandler();
    }

    /**
     * Provides choosing handler
     *
     * @param handler ModuleHandler for operating
     * @since 1.1
     */
    public AddIfMinCommand(ModuleHandler<Route> handler) {
        this.handler = handler;
    }

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
    public void execute(String[] args) {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        Route obj = handler.buildObject();

        if (obj.compareTo(collectionHandler.getMin(new RouteDistanceComparator())) < 0) {
            collectionHandler.addElementToCollection(obj);
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
