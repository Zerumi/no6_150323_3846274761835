package requestLogic.requestSenders;

import commandLogic.commands.BaseCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import requestLogic.dtoMappers.ArgumentCommandRequestDTOMapper;
import requestLogic.dtoMappers.ArgumentMapper;
import serverLogic.ServerConnection;

import java.io.IOException;

public class ArgumentRequestSender<T, Y> {

    private static final Logger logger = LogManager.getLogger("io.github.zerumi.lab6");
    final ArgumentMapper<T, Y> mapper;

    public ArgumentRequestSender(ArgumentMapper<T, Y> mapper) {
        this.mapper = mapper;
    }

    public void sendCommand(BaseCommand command, String[] args, T argument, ServerConnection connection) {
        try {
            var rq = new ArgumentCommandRequestDTOMapper<Y>().argumentCommandRequestDTOMapper(command, args, mapper.mapArgument(argument));
            logger.info("Sending command request...");
            new RequestSender().sendRequest(rq, connection);
        } catch (IOException e) {
            logger.fatal("Can't send request", e);
        } catch (ClassNotFoundException e) {
            logger.fatal("Class not found.");
        }
    }
}
