// wcOO.java -

import javax.sound.sampled.Line;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class wcOO {

    private int EOF = -1;
    private static File srcFile = null;
    private String srcFilename = "<srcFilename>";
    private int c = 0;

    public static void main(String args[]) throws IOException {

        wcOO wc_obj = new wcOO();
        CounterFactory counterFactory = new CounterFactory();

        if ((args.length == 1)) {
            wc_obj.setFilename(args[0]);

            Counter lineCounter = counterFactory.getCounter("LINECOUNT");
            Counter wordCounter = counterFactory.getCounter("WORDCOUNT");
            Counter charCounter = counterFactory.getCounter("WORDCOUNT");

            lineCounter.addFile(args[0]);
            wordCounter.addFile(args[0]);
            charCounter.addFile(args[0]);

            Counter counterArray[] = new Counter[3];

            counterArray[0] = lineCounter;
            counterArray[1] = wordCounter;
            counterArray[2] = charCounter;


            wc_obj.setFile(srcFile);
            srcFile = new File(wc_obj.srcFilename);
            FileInputStream srcStream = new FileInputStream(srcFile);

            wc_obj.process(counterArray, srcStream);

            // Print the result of the source file.
            wc_obj.outputln(wc_obj.srcFilename + ": " + lineCounter.getCount() + " lines, " + wordCounter.getCount() + " words, " + charCounter.getCount() + " chars");
        }

    }

    wcOO() {
        EOF = -1;
        srcFile = null;
        srcFilename = "<srcFilename>";
        c = 0;
    }

    public void process(Counter[] counters, FileInputStream srcStream) throws IOException{
        int c = 0;

        while ((c = srcStream.read()) != EOF) {
            for (int i = 0; i < counters.length; i++) {
                counters[i].process((char) c);
            }
        }
    }

    public void setFilename(String srcFilename) {
        this.srcFilename = srcFilename;
    }

    public void setFile(File srcFile) {
        this.srcFile = new File(srcFilename);
    }

    /** Output a message. */
    private void output(String msg) {
        int len = msg.length();
        for (int i = 0; i < len; i++)
            System.out.write(msg.charAt(i));
    }

    /** Output a message ending with an end of line. */
    private void outputln(String msg) {
        output(msg + '\n');
    }
}
