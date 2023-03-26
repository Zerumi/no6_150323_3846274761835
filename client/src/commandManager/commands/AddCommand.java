package commandManager.commands;

import exceptions.BuildObjectException;
import models.Route;
import models.handlers.ModuleHandler;
import models.handlers.userMode.RouteCLIHandler;

/**
 * Adds new element to collection.
 *
 * @since 1.0
 * @author Zerumi
 */
public class AddCommand implements BaseCommand {

    ModuleHandler<Route> handler;

    /**
     * Default constructor with handler from 1.0
     */
    public AddCommand()
    {
        handler = new RouteCLIHandler();
    }
    /**
     * Provides choosing handler
     *
     * @param handler ModuleHandler for operating
     */
    public AddCommand(ModuleHandler<Route> handler)
    {
        this.handler = handler;
    }

    @Override
    public void execute(String[] args) throws BuildObjectException {
        Route obj = handler.buildObject();


    }
}
