package requestLogic.requestWorkers.argumentTypeResolver;

import dataTransferObjects.models.RouteDTO;
import models.Route;
import requestLogic.dtoMappers.RouteDTOMapper;

public class RouteResolver implements Resolver<Route, RouteDTO> {

    @Override
    public Route getArg(RouteDTO dto) throws ClassNotFoundException {
        return RouteDTOMapper.toRoute(dto);
    }
}
