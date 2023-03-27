package commandManager;

import commandManager.commands.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.requests.CommandClientRequest;
import responseLogic.responseSenders.CommandResponseSender;
import responseLogic.responses.CommandStatusResponse;

import java.util.LinkedHashMap;

/**
 * Command Manager for interactive collection manage.
 *
 * @author Zerumi
 * @since 1.0
 */
public class CommandManager {

    private static final Logger logger = LogManager.getLogger("com.github.zerumi.lab5");
    LinkedHashMap<String, BaseCommand> commands;

    /**
     * Setup command manager and all of its commands.
     */
    public CommandManager() {
        commands = new LinkedHashMap<>();

        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand());
        commands.put("show", new ShowCommand());
        commands.put("add", new AddCommand());
        commands.put("update", new UpdateCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("clear", new ClearCommand());
        commands.put("save", new SaveCommand());
        commands.put("exit", new ExitCommand());
        commands.put("add_if_max", new AddIfMaxCommand());
        commands.put("add_if_min", new AddIfMinCommand());
        commands.put("remove_greater", new RemoveGreaterCommand());
        commands.put("min_by_creation_date", new MinByCreationDateCommand());
        commands.put("count_greater_than_distance", new CountGreaterThanDistanceCommand());
        commands.put("print_field_ascending_distance", new PrintFieldDistanceAscendingCommand());
    }

    /**
     * Get all commands from manager.
     *
     * @return Map of loaded commands
     */
    public LinkedHashMap<String, BaseCommand> getCommands() {
        return commands;
    }

    /**
     * Universe method for command executing.
     *
     * @param command request
     */
    public void executeCommand(CommandClientRequest command) {
        CommandStatusResponse response = null;
        try {
            BaseCommand baseCommand = command.getCommand();
            baseCommand.execute(command.getLineArgs());
            response = baseCommand.getResponse();
        } catch (IllegalArgumentException | NullPointerException e) {
            response = new CommandStatusResponse("Выполнение команды пропущено из-за неправильных предоставленных аргументов! (" + e.getMessage() + ")", -90);
            logger.fatal(response.getResponse(), e);
        } catch (Exception e) {
            response = new CommandStatusResponse("В командном менеджере произошла непредвиденная ошибка!", -92);
            logger.fatal(response.getResponse(), e);
        }
        CommandResponseSender.sendResponse(response, command.getConnection(), command.getFrom());
    }
}
