// ICounter.java -

import java.io.IOException;

public interface ICounter {

    int getCount();
    void process(int c) throws IOException;
}
