package requestLogic.dtoMappers;

import dataTransferObjects.models.CoordinatesDTO;
import dataTransferObjects.models.LocationDTO;
import dataTransferObjects.models.RouteDTO;
import models.Route;

public class RouteDTOMapper {
    public static RouteDTO routeDTOMapper(Route source) throws ClassNotFoundException {
        RouteDTO res = DTOMapper.convertToDTO(source, "dataTransferObjects.models");
        CoordinatesDTO coordinatesDTO = null;
        LocationDTO fromDTO = null;
        LocationDTO toDTO = null;
        if (source.getCoordinates() != null) {
            coordinatesDTO = DTOMapper.convertToDTO(source.getCoordinates(), "dataTransferObjects.models");
        }
        if (source.getFrom() != null) {
            fromDTO = DTOMapper.convertToDTO(source.getFrom(), "dataTransferObjects.models");
        }
        if (source.getTo() != null) {
            toDTO = DTOMapper.convertToDTO(source.getTo(), "dataTransferObjects.models");
        }
        res.setCoordinates(coordinatesDTO);
        res.setFrom(fromDTO);
        res.setTo(toDTO);
        return res;
    }
}
