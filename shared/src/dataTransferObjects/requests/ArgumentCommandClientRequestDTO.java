package dataTransferObjects.requests;

public class ArgumentCommandClientRequestDTO<T> extends CommandClientRequestDTO {

    T argument;

    public ArgumentCommandClientRequestDTO(CommandClientRequestDTO commandClientRequestDTO) {
        super(commandClientRequestDTO.getCommand(), commandClientRequestDTO.getLineArgs());
    }

    public T getArgument() {
        return argument;
    }

    public void setArgument(T argument) {
        this.argument = argument;
    }
}
