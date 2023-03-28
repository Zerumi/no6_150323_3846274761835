package commandManager.commands;

import models.Route;
import models.comparators.RouteCreationDateComparator;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.responses.CommandStatusResponse;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

/**
 * Returns element from collection with min creation date.
 *
 * @author Zerumi
 * @since 1.0
 */
public class MinByCreationDateCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.minByCD");
    private CommandStatusResponse response;

    @Override
    public String getName() {
        return "min_by_creation_date";
    }

    @Override
    public String getDescr() {
        return "Returns element from collection with min creation date.";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();
        Date min = collectionHandler.getCollection().stream().map(Route::getCreationDate).min(Date::compareTo).orElse(null);

        if (min == null) response = CommandStatusResponse.ofString("There's nothing to show...");
        else {
            Optional<Route> optional = collectionHandler.getCollection().stream().min(new RouteCreationDateComparator());
            response = optional.map(route -> CommandStatusResponse.ofString(route.toString())).orElseGet(() -> CommandStatusResponse.ofString("There's nothing to show..."));
        }

        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
