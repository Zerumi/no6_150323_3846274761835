package commandManager.commands;

import exceptions.BuildObjectException;
import exceptions.WrongAmountOfArgumentsException;
import main.Utilities;
import models.Route;
import models.handlers.ModuleHandler;
import models.handlers.userMode.RouteCLIHandler;

/**
 * Updates element by its ID.
 *
 * @since 1.0
 * @author Zerumi
 */
public class UpdateCommand implements BaseCommand {

    ModuleHandler<Route> handler;

    /**
     * Default constructor with handler from 1.0
     */
    public UpdateCommand()
    {
        handler = new RouteCLIHandler();
    }

    /**
     * Provides choosing handler
     *
     * @since 1.1
     * @param handler ModuleHandler for operating
     */
    public UpdateCommand(ModuleHandler<Route> handler)
    {
        this.handler = handler;
    }

    @Override
    public void execute(String[] args) throws BuildObjectException, WrongAmountOfArgumentsException {
        Utilities.checkArgumentsOrThrow(args.length, 1);

        Route newObj = handler.buildObject();
    }
}
