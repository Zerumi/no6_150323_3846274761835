package commandManager;

import commandLogic.CommandDescription;
import commandLogic.commandReceiverLogic.callers.ExternalArgumentReceiverCaller;
import commandLogic.commandReceiverLogic.callers.ExternalBaseReceiverCaller;
import models.Route;

import java.util.ArrayList;

public class CommandExporter {
    public static ArrayList<CommandDescription> getCommandsToExport() {
        ArrayList<CommandDescription> commands = new ArrayList<>();
        commands.add(new CommandDescription("help", new ExternalBaseReceiverCaller()));
        commands.add(new CommandDescription("info", new ExternalBaseReceiverCaller()));
        commands.add(new CommandDescription("show", new ExternalBaseReceiverCaller()));
        commands.add(new CommandDescription("remove_by_id", new ExternalBaseReceiverCaller()));
        commands.add(new CommandDescription("clear", new ExternalBaseReceiverCaller()));
        commands.add(new CommandDescription("execute_script", new ExternalBaseReceiverCaller()));
        commands.add(new CommandDescription("exit", new ExternalBaseReceiverCaller()));
        commands.add(new CommandDescription("min_by_creation_date", new ExternalBaseReceiverCaller()));
        commands.add(new CommandDescription("count_greater_than_distance", new ExternalBaseReceiverCaller()));
        commands.add(new CommandDescription("print_field_ascending_distance", new ExternalBaseReceiverCaller()));
        commands.add(new CommandDescription("add", new ExternalArgumentReceiverCaller<Route>()));
        commands.add(new CommandDescription("add_if_min", new ExternalArgumentReceiverCaller<Route>()));
        commands.add(new CommandDescription("add_if_max", new ExternalArgumentReceiverCaller<Route>()));
        commands.add(new CommandDescription("update", new ExternalArgumentReceiverCaller<Route>()));
        commands.add(new CommandDescription("remove_greater", new ExternalArgumentReceiverCaller<Route>()));

        return commands;
    }
}
