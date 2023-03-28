package commandManager.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.responses.CommandStatusResponse;

/**
 * Terminates the application (without saving collection).
 *
 * @author Zerumi
 * @since 1.0
 */
public class ExitCommand implements BaseCommand {
    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6.commands.exit");
    private CommandStatusResponse response;

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescr() {
        return "Terminates the application. Invoke server-side collection saving.";
    }

    @Override
    public void execute(String[] args) {
        logger.trace("Invoked exit command. Saving a collection...");
        logger.info("Someone is disconnected... Saving a collection...");
        SaveCommand saveCommand = new SaveCommand();
        saveCommand.execute(new String[0]);
    }

    @Override
    public CommandStatusResponse getResponse() {
        return response;
    }
}
