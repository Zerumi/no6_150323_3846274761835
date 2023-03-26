package requestLogic.requests;

public class RequestUtils {
    public static String dtoNameConverter(String nameWithDTO) {
        return nameWithDTO.substring(0, nameWithDTO.length() - 3);
    }
}
