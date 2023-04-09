package requestLogic.requests;

public class ArgumentCommandClientRequest<T> extends CommandClientRequest {
    private T argument;

    public T getArgument() {
        return argument;
    }

    public void setArgument(T argument) {
        this.argument = argument;
    }
}
