package requestLogic.dtoMappers;

import dataTransferObjects.models.CoordinatesDTO;
import dataTransferObjects.models.LocationDTO;
import dataTransferObjects.models.RouteDTO;
import models.Route;

public class RouteDTOMapper implements ArgumentMapper<Route, RouteDTO> {
    public RouteDTO mapArgument(Route source) throws ClassNotFoundException {
        RouteDTO res = new DTOMapper().convertToDTO(source, "dataTransferObjects.models");
        CoordinatesDTO coordinatesDTO = null;
        LocationDTO fromDTO = null;
        LocationDTO toDTO = null;
        if (source.getCoordinates() != null) {
            coordinatesDTO = new DTOMapper().convertToDTO(source.getCoordinates(), "dataTransferObjects.models");
        }
        if (source.getFrom() != null) {
            fromDTO = new DTOMapper().convertToDTO(source.getFrom(), "dataTransferObjects.models");
        }
        if (source.getTo() != null) {
            toDTO = new DTOMapper().convertToDTO(source.getTo(), "dataTransferObjects.models");
        }
        res.setCoordinates(coordinatesDTO);
        res.setFrom(fromDTO);
        res.setTo(toDTO);
        return res;
    }
}
