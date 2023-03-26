package commandManager.commands;

import exceptions.BuildObjectException;
import exceptions.WrongAmountOfArgumentsException;

/**
 * Base interface for command implementation. You should implement it before applying command in CommandManager
 *
 * @author Zerumi
 * @see commandManager.CommandManager
 * @since 1.0
 */
public interface BaseCommand {
    /**
     * Base method for command executing.
     *
     * @param args full array of entered line.
     * @throws IllegalArgumentException when command can't understand given arguments
     */
    void execute(String[] args) throws IllegalArgumentException, BuildObjectException, WrongAmountOfArgumentsException, ClassNotFoundException;
}
