package requestLogic.requests;

public interface RequestVisitor {
    void visit(BaseRequest request);

    void visit(CommandClientRequest request);

    <T> void visit(ArgumentClientRequest<T> request);
}
