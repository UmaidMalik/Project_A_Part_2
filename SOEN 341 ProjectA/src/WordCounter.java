import java.io.*;
public class WordCounter implements iCounter{
    WordCounter(File srcFile) throws IOException {
        FileInputStream srcStream = new FileInputStream(srcFile);
        int  c;
        int  nWords = 0;
        boolean inWord = false;

        while ((c = srcStream.read()) != -1) {
            if (!(c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ')) {
                if (!inWord) {
                    inWord = true;
                    ++nWords;
                    if (Administrator.verboseActive) Stream.outputln('.');
                }
            } else {
                inWord = false;
            }
        }
        Stream.outputln("\nwordcount: " + nWords + " words in sourceFile " + srcFile.getName());
        srcStream.close();
    }
}