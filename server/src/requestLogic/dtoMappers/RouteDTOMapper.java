package requestLogic.dtoMappers;

import models.Coordinates;
import models.Location;
import models.Route;
import models.handlers.RouteIDHandler;
import requestLogic.dataTransferObjects.models.RouteDTO;

import java.time.Instant;
import java.util.Date;

public class RouteDTOMapper {
    private static final String MODEL_PATH = "models";

    public static Route toRoute(RouteDTO source) throws ClassNotFoundException {
        Route res = DTOMapper.convertFromDTO(source, MODEL_PATH);
        Coordinates coordinates = null;
        Location from = null;
        Location to = null;
        if (source.getCoordinates() != null) {
            coordinates = DTOMapper.convertFromDTO(source.getCoordinates(), MODEL_PATH);
        }
        if (source.getFrom() != null) {
            from = DTOMapper.convertFromDTO(source.getFrom(), MODEL_PATH);
        }
        if (source.getTo() != null) {
            to = DTOMapper.convertFromDTO(source.getTo(), MODEL_PATH);
        }
        res.setCoordinates(coordinates);
        res.setFrom(from);
        res.setTo(to);

        // set auto-generated values
        res.setId(RouteIDHandler.getInstance().getNextID());
        res.setCreationDate(Date.from(Instant.now()));

        return res;
    }
}
