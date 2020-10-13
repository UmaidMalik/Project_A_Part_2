// Counter.java -

import java.io.File;
import java.io.IOException;

public class Counter implements ICounter {

    int count = 0;
    private File srcFile = null;
    private String srcFilename = "<srcFilename>";

    public int getCount() {
        return count;
    }

    public void process(int c) throws IOException {

    }

    public void process() {}

    public File getsrcFile() {
        return srcFile;
    }

    public void addFile(String srcFilename) {
        this.srcFilename = srcFilename;
        this.srcFile = new File(srcFilename);

        if (!srcFile.canRead()) {
            outputln("Cannot open srcFile '" + srcFilename + "'");
            return;
        } else {
            outputln("[OK] srcFilename = '" + srcFilename + "'");
        }
    }

    /** Output a message. */
    protected void output(String msg) {
        int len = msg.length();
        for (int i = 0; i < len; i++)
            System.out.write(msg.charAt(i));
    }

    /** Output a message ending with an end of line. */
    protected void outputln(String msg) {
        output(msg + '\n');
    }
    protected void usage(String msg) {
        outputln("Usage: " + msg);
        return;
    }

}
