package semiPljec.stream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Output extends ObjectOutputStream {
    protected Output() throws IOException, SecurityException {
    }

    public Output(OutputStream out) throws IOException {
        super(out);
    }
}
