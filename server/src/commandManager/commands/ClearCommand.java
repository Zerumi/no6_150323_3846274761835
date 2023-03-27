package commandManager.commands;

import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.responses.CommandStatusResponse;

import java.util.HashSet;

/**
 * Clears collection
 *
 * @author Zerumi
 * @since 1.0
 */
public class ClearCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.clear");
    private CommandStatusResponse response;

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescr() {
        return "Clears collection";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        collectionHandler.clearCollection();

        response = CommandStatusResponse.ofString("Cleared!");
        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
