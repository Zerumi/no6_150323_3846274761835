package requestLogic.requestWorkers.argumentTypeResolver;

public interface Resolver<T, Y> {
    T getArg(Y dto) throws ClassNotFoundException;
}
