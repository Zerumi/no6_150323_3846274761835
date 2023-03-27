package responseLogic.dtoMappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

public class DTOMapper {
    public static <T, Y> Y convertToDTO(T source, String location) throws ClassNotFoundException {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        return (Y) mapper.map(source, Class.forName(location + "." + source.getClass().getSimpleName() + "DTO"));
    }
}
