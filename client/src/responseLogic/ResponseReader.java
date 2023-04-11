package responseLogic;

import responses.BaseResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ResponseReader {
    final InputStream in;

    public ResponseReader(InputStream in) {
        this.in = in;
    }

    public BaseResponse readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(in);
        return (BaseResponse) ois.readObject();
    }
}
