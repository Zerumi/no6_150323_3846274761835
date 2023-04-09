package commandLogic;

import commandLogic.commandReceiverLogic.ReceiverType;
import commandLogic.commands.BaseCommand;
import commandLogic.commands.argCommands.*;
import commandLogic.commands.noArgCommands.*;

import java.util.LinkedHashMap;

public class ExternalCommandLoader {
    final LinkedHashMap<String, BaseCommand> commands;

    public ExternalCommandLoader() {
        commands = new LinkedHashMap<>();

        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand());
        commands.put("show", new ShowCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("clear", new ClearCommand());
        commands.put("min_by_creation_date", new MinByCreationDateCommand());
        commands.put("count_greater_than_distance", new CountGreaterThanDistanceCommand());
        commands.put("print_field_ascending_distance", new PrintFieldDistanceAscendingCommand());
        commands.put("add", new AddCommand(ReceiverType.ArgumentRoute));
        commands.put("update", new UpdateCommand(ReceiverType.ArgumentRoute));
        commands.put("add_if_max", new AddIfMaxCommand(ReceiverType.ArgumentRoute));
        commands.put("add_if_min", new AddIfMinCommand(ReceiverType.ArgumentRoute));
        commands.put("remove_greater", new RemoveGreaterCommand(ReceiverType.ArgumentRoute));
    }

    public LinkedHashMap<String, BaseCommand> getExternalCommands() {
        return commands;
    }
}
