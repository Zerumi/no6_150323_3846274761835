package commandManager.commands;

import exceptions.BuildObjectException;
import models.Route;
import models.handlers.ModuleHandler;
import models.handlers.userMode.RouteCLIHandler;

/**
 * Add element if it's value greater than max value.
 *
 * @since 1.0
 * @author Zerumi
 */
public class AddIfMaxCommand implements BaseCommand {
    ModuleHandler<Route> handler;

    /**
     * Default constructor with handler from 1.0
     */
    public AddIfMaxCommand()
    {
        handler = new RouteCLIHandler();
    }
    /**
     * Provides choosing handler
     *
     * @since 1.1
     * @param handler ModuleHandler for operating
     */
    public AddIfMaxCommand(ModuleHandler<Route> handler)
    {
        this.handler = handler;
    }

    @Override
    public void execute(String[] args) throws BuildObjectException {
        Route obj = handler.buildObject();
    }
}
