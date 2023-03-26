package requestLogic.requests;

import org.modelmapper.ModelMapper;
import requestLogic.dataTransferObjects.BaseRequestDTO;

public class RequestDTOMapper {
    public static BaseRequest toRequest(BaseRequestDTO dto) throws ClassNotFoundException {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        String typeName = dto.getClass().getSimpleName();
        BaseRequest request = (BaseRequest) modelMapper.map(dto, Class.forName("requestLogic.requests." + RequestUtils.dtoNameConverter(typeName)));
        return request;
    }
}
