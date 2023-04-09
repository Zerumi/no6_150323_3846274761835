package requestLogic.dtoMappers;

public interface ArgumentMapper<T, Y> {
    Y mapArgument(T source) throws ClassNotFoundException;
}
