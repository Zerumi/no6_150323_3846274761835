package requestLogic.dtoMappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

public class DTOMapper {
    public <T, Y> Y convertToDTO(T source, String location) throws ClassNotFoundException {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        //noinspection unchecked
        return (Y) mapper.map(source, Class.forName(location + "." + source.getClass().getSimpleName() + "DTO"));
    }

    public String dtoNameConverter(String nameWithDTO) {
        return nameWithDTO.substring(0, nameWithDTO.length() - 3);
    }
}
