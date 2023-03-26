package requestLogic.dtoMappers;

import org.modelmapper.ModelMapper;
import requestLogic.dataTransferObjects.BaseRequestDTO;
import requestLogic.requests.BaseRequest;

public class RequestDTOMapper {
    public static BaseRequest toRequest(BaseRequestDTO dto) throws ClassNotFoundException {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        String typeName = dto.getClass().getSimpleName();
        return (BaseRequest) modelMapper.map(dto, Class.forName("requestLogic.requests." + DTOMapper.dtoNameConverter(typeName)));
    }
}
