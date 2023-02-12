package commandManager.commands;

import commandManager.CommandManager;
import exceptions.UnknownCommandException;
import models.Route;
import models.handlers.CollectionHandler;
import models.handlers.ModuleHandler;
import models.handlers.userMode.RouteCLIHandler;
import models.handlers.RoutesHandler;

import java.util.HashSet;

/**
 * Updates element by its ID.
 *
 * @since 1.0
 * @author Zerumi
 */
public class UpdateCommand implements BaseCommand {

    ModuleHandler<Route> handler;

    /**
     * Default constructor with handler from 1.0
     */
    public UpdateCommand()
    {
        handler = new RouteCLIHandler();
    }

    /**
     * Provides choosing handler
     *
     * @since 1.1
     * @param handler ModuleHandler for operating
     */
    public UpdateCommand(ModuleHandler<Route> handler)
    {
        this.handler = handler;
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescr() {
        return "Updates element by it's ID.";
    }

    @Override
    public String getArgs() {
        return "id {element}";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Route>, Route> collectionHandler = RoutesHandler.getInstance();

        CommandManager manager = new CommandManager();
        Long id = Long.valueOf(args[1]);

        ModuleHandler<Route> objHandler = new RouteCLIHandler();
        Route newObj = objHandler.buildObject();

        System.out.println("Updated ID value: " + id);
        newObj.setId(id);

        System.out.println("Removing previous element...");
        try {
            manager.executeCommand(new String[] {"remove_by_id", String.valueOf(id)});
        } catch (UnknownCommandException ignored) {}

        collectionHandler.addElementToCollection(newObj);

        System.out.println("Object updated!");
    }
}