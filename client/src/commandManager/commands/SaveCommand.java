package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;

/**
 * Saves collection to file. Deprecated since 2.0
 *
 * @author Zerumi
 * @since 1.0
 */
@Deprecated
public class SaveCommand implements BaseCommand {
    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescr() {
        return "Deprecated.";
    }

    @Override
    public void execute(String[] args) throws WrongAmountOfArgumentsException {
        System.out.println("Save command was removed from client application. Use exit from client application to invoke saving on server side.");
    }
}
