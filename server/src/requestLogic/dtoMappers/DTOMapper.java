package requestLogic.dtoMappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

public class DTOMapper {
    public static <T, Y> Y convertFromDTO(T source, String location) throws ClassNotFoundException {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        return (Y) mapper.map(source, Class.forName(location + "." + DTOMapper.dtoNameConverter(source.getClass().getSimpleName())));
    }

    public static String dtoNameConverter(String nameWithDTO) {
        return nameWithDTO.substring(0, nameWithDTO.length() - 3);
    }
}
