package requestLogic.dataTransferObjects;

import java.io.Serializable;

public class ArgumentClientRequestDTO<T> extends CommandClientRequestDTO implements Serializable {
    private T argument;

    public T getArgument() {
        return argument;
    }

    public void setArgument(T argument) {
        this.argument = argument;
    }
}
