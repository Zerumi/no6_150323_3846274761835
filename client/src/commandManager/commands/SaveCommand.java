package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;

/**
 * Saves collection to file.
 *
 * @author Zerumi
 * @see ExitCommand
 * @since 1.0
 * @deprecated Deprecated since 2.0. This command now is server-side invoking. Use exit command.
 */
@Deprecated
public class SaveCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws WrongAmountOfArgumentsException {
        System.out.println("Save command was removed from client application. Use exit from client application to invoke saving on server side.");
    }
}
