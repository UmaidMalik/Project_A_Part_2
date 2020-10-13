// LineCounter.java -

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LineCounter extends Counter {

    private int EOF = -1;
    private File srcFile = null;
    private String srcFilename = "<srcFilename>";
    private int nLines = 1;

    public LineCounter(String srcFilename) {
        this.srcFilename = srcFilename;
        this.srcFile = new File(srcFilename);

        if (!srcFile.canRead()) {
            linecount("Cannot open srcFile '" + srcFilename + "'");
            return;
        } else {
            linecount("[OK] srcFilename = '" + srcFilename + "'");
        }

    }

    public LineCounter() {}

    public void addFile(String srcFilename) {
        this.srcFilename = srcFilename;
        this.srcFile = new File(srcFilename);

        if (!srcFile.canRead()) {
            linecount("Cannot open srcFile '" + srcFilename + "'");
            return;
        } else {
            linecount("[OK] srcFilename = '" + srcFilename + "'");
        }

    }

    @Override
    public void process(int c) throws IOException {
            if (c == '\n') ++nLines;
    }

    @Override
    public int getCount() {
        count = nLines;
        return count;
    }

    private void linecount(String msg) {
        outputln("linecount: " + msg);
    }
}
