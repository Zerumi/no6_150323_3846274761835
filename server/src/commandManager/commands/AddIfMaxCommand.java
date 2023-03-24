package commandManager.commands;

import models.Route;
import models.comparators.RouteDistanceComparator;
import models.handlers.CollectionHandler;
import models.handlers.ModuleHandler;
import models.handlers.RouteNetworkHandler;
import models.handlers.RoutesHandler;

import java.util.HashSet;

/**
 * Add element if it's value greater than max value.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddIfMaxCommand implements BaseCommand {
    ModuleHandler<Route> handler;

    /**
     * Default constructor with handler from 1.0
     */
    public AddIfMaxCommand() {
        handler = new RouteNetworkHandler();
    }

    /**
     * Provides choosing handler
     *
     * @param handler ModuleHandler for operating
     * @since 1.1
     */
    public AddIfMaxCommand(ModuleHandler<Route> handler) {
        this.handler = handler;
    }

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
    public void execute(String[] args) {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        Route obj = handler.buildObject();

        if (obj.compareTo(collectionHandler.getMax(new RouteDistanceComparator())) > 0) {
            collectionHandler.addElementToCollection(obj);
            System.out.println("Element added!");
        } else {
            System.out.println("Element not added: it's not greater than max value.");
        }
    }
}
