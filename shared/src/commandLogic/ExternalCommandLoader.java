package commandLogic;

import commandLogic.commands.BaseCommand;
import commandLogic.commands.noArgCommands.*;

import java.util.LinkedHashMap;

public class ExternalCommandLoader {
    LinkedHashMap<String, BaseCommand> commands;

    public ExternalCommandLoader() {
        commands = new LinkedHashMap<>();

        commands.put("clear", new ClearCommand());
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand());
        commands.put("min_by_creation_date", new MinByCreationDateCommand());
        commands.put("print_field_ascending_distance", new PrintFieldDistanceAscendingCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("show", new ShowCommand());
    }

    public LinkedHashMap<String, BaseCommand> getExternalCommands() {
        return commands;
    }
}
