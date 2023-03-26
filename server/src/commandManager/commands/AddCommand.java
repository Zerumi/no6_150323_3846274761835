package commandManager.commands;

import commandManager.commandResponse.CommandResponse;
import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.ModuleHandler;
import models.handlers.RouteNetworkHandler;
import models.handlers.RoutesHandler;

import java.util.HashSet;

/**
 * Adds new element to collection.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddCommand implements BaseCommand {
    CommandResponse response;
    ModuleHandler<Route> handler;

    /**
     * Default constructor with handler from 1.0
     */
    public AddCommand() {
        handler = new RouteNetworkHandler();
    }

    /**
     * Provides choosing handler
     *
     * @param handler ModuleHandler for operating
     */
    public AddCommand(ModuleHandler<Route> handler) {
        this.handler = handler;
    }

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
    public void execute(String[] args) {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        collectionHandler.addElementToCollection(handler.buildObject());

        System.out.println("Element added!");
    }

    @Override
    public CommandResponse getResponse() {
        return response;
    }
}
