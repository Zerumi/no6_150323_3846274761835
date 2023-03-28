package commandManager.commands;

import responseLogic.responses.CommandStatusResponse;

public class ExecuteScriptCommand implements BaseCommand {
    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescr() {
        return "Reads and executes script from file.";
    }

    @Override
    public String getArgs() {
        return "file_path";
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException, ClassNotFoundException {
        // for client-use only
    }

    @Override
    public CommandStatusResponse getResponse() {
        return null;
    }
}
