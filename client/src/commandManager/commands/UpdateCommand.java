package commandManager.commands;

import exceptions.BuildObjectException;
import exceptions.WrongAmountOfArgumentsException;
import main.Utilities;
import models.Route;
import models.handlers.ModuleHandler;
import models.handlers.userMode.RouteCLIHandler;
import requestLogic.dataTransferObjects.models.RouteDTO;
import requestLogic.dtoMappers.RouteDTOMapper;
import serverLogic.ServerConnectionHandler;
import serverLogic.ServerConnectionUtils;

/**
 * Updates element by its ID.
 *
 * @author Zerumi
 * @since 1.0
 */
public class UpdateCommand implements BaseCommand {
    private Route route;
    private RouteDTO obj;
    private final ModuleHandler<Route> handler;

    /**
     * Default constructor with handler from 1.0
     */
    public UpdateCommand() {
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
    public void execute(String[] args) throws BuildObjectException, WrongAmountOfArgumentsException, ClassNotFoundException {
        Utilities.checkArgumentsOrThrow(args.length, 1);

        route = handler.buildObject();
        obj = RouteDTOMapper.routeDTOMapper(route);
        ServerConnectionUtils.sendCommand(this, args, ServerConnectionHandler.getCurrentConnection());
    }
}
