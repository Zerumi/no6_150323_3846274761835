package commandManager.commands;

import fileLogic.Saver;
import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.responses.CommandStatusResponse;

import java.util.HashSet;

/**
 * Saves collection to file.
 *
 * @author Zerumi
 * @since 1.0
 */
public class SaveCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.save");
    private CommandStatusResponse response;

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescr() {
        return "Saves collection to file.";
    }

    @Override
    public void execute(String[] args) {
        logger.trace("Saving...");
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();
        Saver<HashSet<Route>, Route> saver = new Saver<>(Route.class);

        saver.saveCollection(collectionHandler.getCollection(), "lab5");

        response = CommandStatusResponse.ofString("[Server] Collection saving executed.");
        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
