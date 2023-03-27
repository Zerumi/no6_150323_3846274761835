package commandManager.commands;

import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.responses.CommandStatusResponse;

import java.util.HashSet;
import java.util.Objects;

/**
 * Removes element from collection by id.
 *
 * @author Zerumi
 * @since 1.0
 */
public class RemoveByIdCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.rmByID");
    private CommandStatusResponse response;

    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescr() {
        return "Removes element from collection by id.";
    }

    @Override
    public String getArgs() {
        return "id";
    }

    @Override
    public void execute(String[] args) {

        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        if (collectionHandler.getCollection().removeIf(route -> Objects.equals(route.getId(), Long.valueOf(args[1]))))
            response = CommandStatusResponse.ofString("Element with that id doesn't exists.");
        else
            response = CommandStatusResponse.ofString("Executed.");

        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
