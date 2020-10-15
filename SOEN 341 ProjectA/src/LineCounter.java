import java.io.*;

public class LineCounter implements iCounter {

    LineCounter(File srcFile) throws IOException {
        FileInputStream srcStream = new FileInputStream(srcFile);
        int c;
        int nLines = 1;

        while ((c = srcStream.read()) != -1) {
            if (c == '\n') {
                ++nLines;
                if (Administrator.verboseActive)
                    Stream.outputln('.');
            }
        }
        Stream.outputln("\nlinecount: " + nLines + " lines in sourceFile " + srcFile.getName());
        srcStream.close();
    }
}
