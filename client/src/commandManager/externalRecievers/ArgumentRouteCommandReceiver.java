package commandManager.externalRecievers;

import commandLogic.commandReceiverLogic.receivers.ExternalArgumentReceiver;
import commandLogic.commands.BaseCommand;
import exceptions.BuildObjectException;
import models.Route;
import models.handlers.ModuleHandler;
import requestLogic.dtoMappers.RouteDTOMapper;
import requestLogic.requestSenders.ArgumentRequestSender;
import serverLogic.ServerConnectionHandler;

public class ArgumentRouteCommandReceiver implements ExternalArgumentReceiver<Route> {

    ModuleHandler<Route> handler;
    Route route;

    {
        route = new Route();
    }

    public ArgumentRouteCommandReceiver(ModuleHandler<Route> handler) {
        this.handler = handler;
    }

    @Override
    public void receiveCommand(BaseCommand command, String[] args) throws BuildObjectException {
        route = handler.buildObject();
        new ArgumentRequestSender<>(new RouteDTOMapper()).sendCommand(command, args, route, ServerConnectionHandler.getCurrentConnection());
    }

    @Override
    public Route getArguemnt() {
        return route;
    }
}
