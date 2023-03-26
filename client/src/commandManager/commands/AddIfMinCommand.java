package commandManager.commands;

import exceptions.BuildObjectException;
import models.Route;
import models.handlers.ModuleHandler;
import models.handlers.userMode.RouteCLIHandler;

/**
 * Adds element if it's value lower than min value.
 *
 * @since 1.0
 * @author Zerumi
 */
public class AddIfMinCommand implements BaseCommand {

    /**
     * Default constructor with handler from 1.0
     */
    public AddIfMinCommand()
    {
        handler = new RouteCLIHandler();
    }
    ModuleHandler<Route> handler;
    /**
     * Provides choosing handler
     *
     * @since 1.1
     * @param handler ModuleHandler for operating
     */
    public AddIfMinCommand(ModuleHandler<Route> handler)
    {
        this.handler = handler;
    }
    @Override
    public void execute(String[] args) throws BuildObjectException {

        Route obj = handler.buildObject();

    }
}
