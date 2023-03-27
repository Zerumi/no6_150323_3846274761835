package main;

import commandManager.CommandExecutor;
import commandManager.CommandMode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import responseLogic.ResponseReader;
import responseLogic.dataTransferObjects.BaseResponseDTO;
import responseLogic.dtoMappers.DTOMapper;
import responseLogic.responseWorkers.ResponseWorkerManager;
import responseLogic.responses.BaseResponse;
import serverLogic.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Program entry point class. Contains main() method.
 * This program is managing collection of type <code>HashSet&#8249;Route></code>
 *
 * @author zerumi
 * @since 1.0
 */
public class Main {
    @SuppressWarnings("SpellCheckingInspection")
    public static final String HOST_ADDRESS = "se.ifmo.ru";
    public static final int PORT = 44456;
    private static final Logger logger = LogManager.getLogger("lab6");

    /**
     * Program entry point.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // server connecting
        try {
            //ServerConnection connection = new UdpServerConnectionFactory().openConnection(InetAddress.getByName(HOST_ADDRESS), PORT);
            ServerConnection connection = new UdpConnectionBlockDecorator((UdpServerConnection) new UdpServerConnectionFactory().openConnection(InetAddress.getLocalHost(), PORT), true);
            ServerConnectionHandler.setServerConnection(connection);
            connection.openConnection();

            Thread listenResponses = new Thread(() -> {
                while (true) {
                    try (InputStream stream = connection.listenServer()) {
                        logger.info("received");
                        ResponseReader<BaseResponseDTO> reader = new ResponseReader<>(stream);
                        BaseResponseDTO responseDTO = reader.readObject();
                        BaseResponse response = DTOMapper.convertFromDTO(responseDTO, "responseLogic.responses");
                        ResponseWorkerManager manager = new ResponseWorkerManager();
                        manager.workWithRequest(response, responseDTO, response.getClass().getSimpleName());
                    } catch (IOException e) {
                        logger.error("Something went wrong during I/O operations.");
                    } catch (ClassNotFoundException e) {
                        logger.error("Response class not found.");
                    }
                }
            });
            listenResponses.start();

            CommandExecutor executor = new CommandExecutor();
            executor.startExecuting(System.in, CommandMode.CLI_UserMode);
        } catch (UnknownHostException ex) {
            logger.fatal("Can't find host.");
        } catch (IOException ex) {
            logger.error("Something went wrong during IO operations.");
        }
    }
}