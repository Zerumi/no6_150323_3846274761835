package commandLogic.commands;

/**
 * Base interface for command implementation. You should implement it before applying command in CommandManager
 *
 * @author Zerumi
 * @since 2.1
 */
public interface BaseCommand {

    String getName();

    default int getArgCount() {
        return 0;
    }

    /**
     * Base method for command executing.
     *
     * @param args full array of entered line.
     * @throws Exception -- This is used by 3rd party apps, so that's ok
     */
    void execute(String[] args) throws Exception;
}