import java.io.*;
import java.util.*;

public class CounterFactory {
    iCounter[] createCounters(File srcFile) throws IOException {
        iCounter[] c = new iCounter[3];
        c[0] = new CharCounter (srcFile);
        c[1] = new LineCounter (srcFile);
        c[2] = new WordCounter (srcFile);
        return c;
    }
    iCounter createCharCounter(File srcFile) throws IOException {
        return new CharCounter (srcFile);
    }
    iCounter createLineCounter(File srcFile) throws IOException {
        return new LineCounter (srcFile);
    }
    iCounter createWordCounter(File srcFile) throws IOException {
        return new WordCounter (srcFile);
    }
    iCounter getCounter(String counterName, File srcFile) throws IOException {
        counterName.toLowerCase(Locale.ROOT);

        switch(counterName) {
            case "wc": {createCounters(srcFile); break;}
            case "charcounter": {createCharCounter(srcFile); break;}
            case "linecounter": {createLineCounter(srcFile); break;}
            case "wordcounter": {createWordCounter(srcFile); break;}

        }
        return null;
    }


}


