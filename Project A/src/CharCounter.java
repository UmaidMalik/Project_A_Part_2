// CharCounter.java -

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CharCounter extends Counter {

    private int EOF = -1;
    private File srcFile = null;
    private String srcFilename = "<srcFilename>";
    private int nChars = 0;

    public CharCounter(String srcFilename) {
        this.srcFilename = srcFilename;
        this.srcFile = new File(srcFilename);

        if (!srcFile.canRead()) {
            charcount("Cannot open srcFile '" + srcFilename + "'");
            return;
        } else {
            charcount("[OK] srcFilename = '" + srcFilename + "'");
        }

    }

    public CharCounter() {}

    public void addFile(String srcFilename) {
        this.srcFilename = srcFilename;
        this.srcFile = new File(srcFilename);

        if (!srcFile.canRead()) {
            charcount("Cannot open srcFile '" + srcFilename + "'");
            return;
        } else {
            charcount("[OK] srcFilename = '" + srcFilename + "'");
        }

    }

    @Override
    public void process(int c) throws IOException {
            ++nChars;
    }

    @Override
    public int getCount() {
        count = nChars;
        return count;
    }

    private void charcount(String msg) {
        outputln("charcount: " + msg);
    }

}
