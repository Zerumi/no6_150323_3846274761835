package requestLogic;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class RequestReader<T> {
    final InputStream in;

    public RequestReader(InputStream in) {
        this.in = in;
    }

    @SuppressWarnings("unchecked")
    public T readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(in);
        return (T) ois.readObject();
    }
}
