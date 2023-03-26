package requestLogic.requests;

public class ArgumentClientRequest<T> extends CommandClientRequest {
    private T argument;

    public T getArgument() {
        return argument;
    }

    public void accept(RequestVisitor visitor) {
        visitor.visit(this);
    }
}
