package commandManager.commands;

import dataTransferObjects.models.RouteDTO;
import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.dtoMappers.RouteDTOMapper;
import responseLogic.responses.CommandStatusResponse;

import java.util.HashSet;

/**
 * Adds new element to collection.
 *
 * @author Zerumi
 * @since 1.0
 */
public class AddCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.add");
    private CommandStatusResponse response;

    private RouteDTO obj;

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescr() {
        return "Adds new element to collection.";
    }

    @Override
    public String getArgs() {
        return "{element}";
    }

    @Override
    public void execute(String[] args) throws ClassNotFoundException {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        collectionHandler.addElementToCollection(RouteDTOMapper.toRoute(obj));

        response = CommandStatusResponse.ofString("Element added!");
        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
