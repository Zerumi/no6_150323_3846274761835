package commandManager.commands;

import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.responses.CommandStatusResponse;

import java.util.HashSet;
import java.util.List;

/**
 * Shows count of the elements greater than distance value.
 *
 * @author Zerumi
 * @since 1.0
 */
public class CountGreaterThanDistanceCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.countGTDistance");
    private CommandStatusResponse response;

    @Override
    public String getName() {
        return "count_greater_than_distance";
    }

    @Override
    public String getDescr() {
        return "Shows count of the elements greater than distance value.";
    }

    @Override
    public String getArgs() {
        return "distance";
    }

    @Override
    public void execute(String[] args) {
        int greaterThan = Integer.parseInt(args[1]);

        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();
        List<Integer> distances = collectionHandler.getCollection().stream().map(Route::getDistance).toList();

        response = CommandStatusResponse.ofString("Total count: " + distances.stream().map(x -> x.compareTo(greaterThan)).filter(x -> x > 0).count());
        logger.info(response);
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
