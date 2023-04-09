package dataTransferObjects.requests;

public class ArgumentCommandClientRequestDTO<T> extends CommandClientRequestDTO {

    T argument;

    public T getArgument() {
        return argument;
    }

    public void setArgument(T argument) {
        this.argument = argument;
    }
}
