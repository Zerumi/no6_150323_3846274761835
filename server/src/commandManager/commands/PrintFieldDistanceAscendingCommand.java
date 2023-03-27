package commandManager.commands;

import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.responses.CommandStatusResponse;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Prints all distance fields in ascending sorting.
 *
 * @author Zerumi
 * @since 1.0
 */
public class PrintFieldDistanceAscendingCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.printFDA");
    private CommandStatusResponse response;

    @Override
    public String getName() {
        return "print_field_ascending_distance";
    }

    @Override
    public String getDescr() {
        return "Prints all distance fields in ascending sorting.";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();
        List<Integer> distances = collectionHandler.getCollection().stream().map(Route::getDistance).sorted(Comparator.comparingInt(o -> o)).toList();

        StringBuilder sb = new StringBuilder();
        distances.forEach(d -> sb.append(d).append('\n'));
        response = CommandStatusResponse.ofString(sb.toString());

        if (collectionHandler.getCollection().isEmpty())
            response = CommandStatusResponse.ofString("There's nothing to show...");

        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
