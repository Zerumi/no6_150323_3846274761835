package commandManager.commands;

import exceptions.BuildObjectException;
import models.Route;
import models.handlers.ModuleHandler;
import models.handlers.userMode.RouteCLIHandler;

/**
 * Removes elements from collection greater than given in argument.
 *
 * @since 1.0
 * @author Zerumi
 */
public class RemoveGreaterCommand implements BaseCommand {

    ModuleHandler<Route> handler;

    /**
     * Default constructor with handler from 1.0
     */
    public RemoveGreaterCommand()
    {
        handler = new RouteCLIHandler();
    }

    /**
     * Provides choosing handler
     *
     * @since 1.1
     * @param handler ModuleHandler for operating
     */
    public RemoveGreaterCommand(ModuleHandler<Route> handler)
    {
        this.handler = handler;
    }

    @Override
    public void execute(String[] args) throws BuildObjectException {
        Route greaterThan = handler.buildObject();

    }
}
