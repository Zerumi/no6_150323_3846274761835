package commandLogic.commands;

/*
 * Adds new element to collection.
 *
 * @author Zerumi
 * @since 1.0
 */
/*public class AddCommand implements BaseCommand {

    private RouteDTO obj;
    private Route route;

    private final ModuleHandler<Route> handler;

    /**
     * Default constructor with handler from 1.0
     */ /*
    public AddCommand() {
        handler = new RouteCLIHandler();
    }

    /**
     * Provides choosing handler
     *
     * @param handler ModuleHandler for operating
     */ /*
    public AddCommand(ModuleHandler<Route> handler)
    {
        this.handler = handler;
    }

    @Override
    public void execute(String[] args) throws BuildObjectException, ClassNotFoundException {
        route = handler.buildObject();
        obj = RouteDTOMapper.routeDTOMapper(route);
        CommandRequestSender.sendCommand(this, args, ServerConnectionHandler.getCurrentConnection());
    }
}
*/