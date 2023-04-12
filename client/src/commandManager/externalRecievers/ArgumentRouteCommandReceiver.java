package commandManager.externalRecievers;

import commandLogic.CommandDescription;
import commandLogic.commandReceiverLogic.receivers.ExternalArgumentReceiver;
import exceptions.BuildObjectException;
import models.Route;
import models.handlers.ModuleHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.requestSenders.ArgumentRequestSender;
import responses.CommandStatusResponse;
import serverLogic.ServerConnectionHandler;

public class ArgumentRouteCommandReceiver implements ExternalArgumentReceiver<Route> {

    private static final Logger logger = LogManager.getLogger("com.github.zerumi.lab6");
    ModuleHandler<Route> handler;
    Route route;

    {
        route = new Route();
    }

    public ArgumentRouteCommandReceiver(ModuleHandler<Route> handler) {
        this.handler = handler;
    }

    @Override
    public void receiveCommand(CommandDescription command, String[] args) throws BuildObjectException {
        route = handler.buildObject();
        CommandStatusResponse response = new ArgumentRequestSender<Route>().sendCommand(command, args, route, ServerConnectionHandler.getCurrentConnection());
        if (response != null) {
            logger.info("Status code: " + response.getStatusCode());
            logger.info("Response: \n" + response.getResponse());
        }
    }

    @Override
    public Route getArguemnt() {
        return route;
    }
}
