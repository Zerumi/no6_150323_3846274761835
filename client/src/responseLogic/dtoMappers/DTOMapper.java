package responseLogic.dtoMappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

public class DTOMapper {
    public static <T, Y> Y convertFromDTO(T source, String location) throws ClassNotFoundException {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        //noinspection unchecked
        return (Y) mapper.map(source, Class.forName(location + "." + new requestLogic.dtoMappers.DTOMapper().dtoNameConverter(source.getClass().getSimpleName())));
    }
}
