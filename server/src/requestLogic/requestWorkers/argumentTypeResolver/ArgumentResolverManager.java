package requestLogic.requestWorkers.argumentTypeResolver;

import dataTransferObjects.models.RouteDTO;
import exceptions.InvalidRequestException;

import java.util.LinkedHashMap;
import java.util.Optional;

public class ArgumentResolverManager<T, Y> {

    private final LinkedHashMap<Class<Y>, Resolver<T, Y>> resolvers;

    {
        resolvers = new LinkedHashMap<>();

        //noinspection unchecked
        resolvers.put((Class<Y>) RouteDTO.class, (Resolver<T, Y>) new RouteResolver());
    }

    public T resolve(Y requestDTOtoWork) throws InvalidRequestException, ClassNotFoundException {
        return Optional.ofNullable(resolvers.get(requestDTOtoWork.getClass())).orElseThrow(InvalidRequestException::new).getArg(requestDTOtoWork);
    }
}
