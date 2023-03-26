package commandManager.commands;

import exceptions.BuildObjectException;
import models.Route;
import models.handlers.ModuleHandler;
import models.handlers.userMode.RouteCLIHandler;
import requestLogic.dataTransferObjects.models.RouteDTO;
import requestLogic.dtoMappers.RouteDTOMapper;
import serverLogic.ServerConnectionHandler;
import serverLogic.ServerConnectionUtils;

/**
 * Adds element if it's value lower than min value.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddIfMinCommand implements BaseCommand {
    private Route route;
    private RouteDTO obj;

    /**
     * Default constructor with handler from 1.0
     */
    public AddIfMinCommand() {
        handler = new RouteCLIHandler();
    }

    ModuleHandler<Route> handler;

    /**
     * Provides choosing handler
     *
     * @since 1.1
     * @param handler ModuleHandler for operating
     */
    public AddIfMinCommand(ModuleHandler<Route> handler) {
        this.handler = handler;
    }

    @Override
    public void execute(String[] args) throws BuildObjectException, ClassNotFoundException {
        route = handler.buildObject();
        obj = RouteDTOMapper.routeDTOMapper(route);
        ServerConnectionUtils.sendCommand(this, args, ServerConnectionHandler.getCurrentConnection());
    }
}
