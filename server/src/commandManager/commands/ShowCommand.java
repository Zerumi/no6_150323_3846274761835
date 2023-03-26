package commandManager.commands;

import commandManager.commandResponse.CommandResponse;
import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;

import java.util.HashSet;

/**
 * Shows every element of the collection in toString() interpretation.
 *
 * @author Zerumi
 * @since 1.0
 */
public class ShowCommand implements BaseCommand {
    CommandResponse response;

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescr() {
        return "Shows every element of the collection in toString() interpretation.";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Route>, Route> handler = RoutesHandler.getInstance();

        handler.getCollection().forEach(System.out::println);

        if (handler.getCollection().isEmpty()) {
            System.out.println("There's nothing to show.");
        }
    }

    @Override
    public CommandResponse getResponse() {
        return response;
    }
}
