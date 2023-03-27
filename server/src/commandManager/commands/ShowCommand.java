package commandManager.commands;

import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.RoutesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.responses.CommandStatusResponse;

import java.util.HashSet;

/**
 * Shows every element of the collection in toString() interpretation.
 *
 * @author Zerumi
 * @since 1.0
 */
public class ShowCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.show");
    private CommandStatusResponse response;

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescr() {
        return "Shows every element of the collection in toString() interpretation.";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Route>, Route> handler = RoutesHandler.getInstance();

        StringBuilder sb = new StringBuilder();

        handler.getCollection().forEach(e -> sb.append(e.toString()).append('\n'));
        response = CommandStatusResponse.ofString(sb.toString());

        if (handler.getCollection().isEmpty()) {
            response = CommandStatusResponse.ofString("There's nothing to show.");
        }

        logger.info(response.getResponse());
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
