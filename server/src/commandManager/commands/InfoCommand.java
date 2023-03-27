package commandManager.commands;

import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.responses.CommandStatusResponse;

import java.util.HashSet;

/**
 * Shows information about the collection.
 *
 * @author Zerumi
 * @since 1.0
 */
public class InfoCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.info");
    private CommandStatusResponse response;

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescr() {
        return "Shows information about the collection.";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Route>, Route> handler = RoutesHandler.getInstance();

        HashSet<Route> collection = handler.getCollection();

        String sb = "Now you are operating with collection of type " + collection.getClass().getName() + ", filled with elements of type " + handler.getFirstOrNew().getClass().getName() + '\n' +
                "Size of the collection is " + collection.size() + '\n' +
                "Init date: " + handler.getInitDate();

        response = CommandStatusResponse.ofString(sb);
        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
