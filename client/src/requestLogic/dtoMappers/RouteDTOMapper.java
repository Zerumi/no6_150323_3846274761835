package requestLogic.dtoMappers;

import models.Route;
import requestLogic.dataTransferObjects.models.CoordinatesDTO;
import requestLogic.dataTransferObjects.models.LocationDTO;
import requestLogic.dataTransferObjects.models.RouteDTO;

public class RouteDTOMapper {
    public static RouteDTO routeDTOMapper(Route source) throws ClassNotFoundException {
        RouteDTO res = DTOMapper.convertToDTO(source, "requestLogic.dataTransferObjects.models");
        CoordinatesDTO coordinatesDTO = null;
        LocationDTO fromDTO = null;
        LocationDTO toDTO = null;
        if (source.getCoordinates() != null) {
            coordinatesDTO = DTOMapper.convertToDTO(source.getCoordinates(), "requestLogic.dataTransferObjects.models");
        }
        if (source.getFrom() != null) {
            fromDTO = DTOMapper.convertToDTO(source.getFrom(), "requestLogic.dataTransferObjects.models");
        }
        if (source.getTo() != null) {
            toDTO = DTOMapper.convertToDTO(source.getTo(), "requestLogic.dataTransferObjects.models");
        }
        res.setCoordinates(coordinatesDTO);
        res.setFrom(fromDTO);
        res.setTo(toDTO);
        return res;
    }
}
