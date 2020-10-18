import java.io.*;

public class LineCounter implements iCounter{
    LineCounter(File srcFile) throws IOException {
        count (srcFile);
    }
    @Override
    public void count(File srcFile) throws IOException {
        FileInputStream srcStream = new FileInputStream(srcFile);
        int c;
        int nLines = 1;

        while ((c = srcStream.read()) != -1) {
            if (c == '\n') {
                ++nLines;
                if (Administrator.verboseActive) System.out.print('.');
            }
        }
        Stream.outputln("\nlinecount: " + nLines + " lines in sourceFile " + srcFile.getName());
        srcStream.close();
    }

}
