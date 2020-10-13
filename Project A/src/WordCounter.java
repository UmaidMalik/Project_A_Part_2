// WordCounter.java -

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class WordCounter extends Counter {

    private int EOF = -1;
    private File srcFile = null;
    private String srcFilename = "<srcFilename>";
    private int nWords = 0;
    private boolean inWord = false;

    public WordCounter(String srcFilename) {
        this.srcFilename = srcFilename;
        this.srcFile = new File(srcFilename);

        if (!srcFile.canRead()) {
            wordcount("Cannot open srcFile '" + srcFilename + "'");
            return;
        } else {
            wordcount("[OK] srcFilename = '" + srcFilename + "'");
        }

    }

    public WordCounter() {
    }

    public void addFile(String srcFilename) {
        this.srcFilename = srcFilename;
        this.srcFile = new File(srcFilename);

        if (!srcFile.canRead()) {
            wordcount("Cannot open srcFile '" + srcFilename + "'");
            return;
        } else {
            wordcount("[OK] srcFilename = '" + srcFilename + "'");
        }

    }

    @Override
    public void process(int c) throws IOException {

            if (!isSpace(c)) {
                if (!inWord) {
                    inWord = true;
                    ++nWords;
                }
            } else {
                inWord  = false;
            }
    }

    @Override
    public int getCount() {
        count = nWords;
        return count;
    }

    private void wordcount(String msg) {
        outputln("wordcount: " + msg);
    }

    private boolean isSpace(int c) {
        return (c == ' ' || c == '\t' || c == '\n');
    }
}
