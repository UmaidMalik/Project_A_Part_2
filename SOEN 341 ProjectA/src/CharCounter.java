
import java.io.*;
public class CharCounter implements iCounter{
    CharCounter(File srcFile) throws IOException {
        FileInputStream srcStream = new FileInputStream(srcFile);
        int c;
        int nChars = 0;
        while ((c = srcStream.read()) != -1) {
            ++nChars;
            if (Administrator.verboseActive) System.out.print('.');
        }
        Stream.outputln("\ncharcount: " + nChars + " characters in sourceFile " + srcFile.getName());
        srcStream.close();
    }
}
