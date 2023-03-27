package commandManager.commands;

import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.dataTransferObjects.models.RouteDTO;
import requestLogic.dtoMappers.RouteDTOMapper;
import responseLogic.responses.CommandStatusResponse;

import java.util.HashSet;
import java.util.Objects;

/**
 * Updates element by its ID.
 *
 * @author Zerumi
 * @since 1.0
 */
public class UpdateCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.update");
    private CommandStatusResponse response;
    private RouteDTO obj;

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescr() {
        return "Updates element by it ID.";
    }

    @Override
    public String getArgs() {
        return "id {element}";
    }

    @Override
    public void execute(String[] args) throws ClassNotFoundException {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        Long finalId = Long.valueOf(args[1]);

        if (!collectionHandler.getCollection().removeIf(route -> Objects.equals(route.getId(), finalId))) {
            response = new CommandStatusResponse("Element with that id doesn't exists.", 2);
            logger.warn(response.getResponse());
            return;
        }
        Route newObj = RouteDTOMapper.toRoute(obj);

        logger.info("Updated ID value: " + finalId);
        newObj.setId(finalId);

        collectionHandler.addElementToCollection(newObj);

        response = CommandStatusResponse.ofString("Object updated!");
        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
