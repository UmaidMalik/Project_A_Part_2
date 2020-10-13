// wc.java - Count characters, lines, and words in a sourcefile

import java.io.*;

public class wc {

    private static int EOF = -1;
    private static File srcFile = null;
    private static String srcFilename = "<srcFilename>";

    private static int totalLines;
    private static int totalWords;
    private static int totalChars;

    private static void usage(String msg) {
        outputln("Usage: " + msg);
        return;
    }

    private static void wc(String msg) {
        outputln("wc: " + msg);
        return;
    }

    /** Output a message. */
    private static void output(String msg) {
        int len = msg.length();
        for (int i = 0; i < len; i++)
            System.out.write(msg.charAt(i));
    }

    /** Output a message ending with an end of line. */
    private static void outputln(String msg) {
        output(msg + '\n');
    }

    private static boolean isSpace(int c) {
        return (c == ' ' || c == '\t' || c == '\n');
    }

    public static void main(String args[]) throws IOException {

        // Help option for program.
        if (("-help".equals(args[0])) || ("-h".equals(args[0])) || ("-?".equals(args[0]))) {
            System.out.println("wc: This program counts the number of characters, lines, and words in a given source file.");
            return;
        }

        // Banner option for program.
        if (("-banner".equals(args[0])) || ("-b".equals(args[0]))) {
            outputln("wc Version 1.2a\n" +
                    "Copyright (C) DIO Inc 2020. All Rights Reserved.\n" +
                    "Written by Umaid Malik");
            return;
        }


        // Check the command-line.
        if (args.length < 1) {
            usage("wc <src> { <src> }");
            return;
        }

        for (int n = 0; n < args.length; ++n) {
            // Check if arguments are valid, if the srcFile exists.
            if (args[n] != null) { // Check <src>
                srcFilename = args[n];
                // wc("srcFilename = '" + srcFilename + "'");
                srcFile = new File(srcFilename);
                if (!srcFile.canRead()) {
                    wc("Cannot open srcFile '" + srcFilename + "'");
                    return;
                } else {
                    wc("[OK] srcFilename = '" + srcFilename + "'");
                }

                FileInputStream srcStream = new FileInputStream(srcFile);

                // Execute the word count.
                totalLines = totalWords = totalChars = 0;
                int c = 0;
                int nChars, nLines, nWords;
                boolean inWord = false;

                nLines = 1;
                nChars = nWords = 0;

                if ((c = srcStream.read()) == EOF) {
                    --nLines;
                }

                while ((c = srcStream.read()) != EOF) {
                    // Count characters.
                    ++nChars;

                    // Count lines.
                    if (c == '\n') ++nLines;


                    // Count words.
                    if (!isSpace(c)) {
                        if (!inWord) {
                            inWord = true;
                            ++nWords;
                        }
                    } else {
                        inWord = false;
                    }
                }
                // Close and flush the file.
                srcStream.close();

                // Print the result of the source file.
                outputln(srcFilename + ": " + nLines + " lines, " + nWords + " words, " + nChars + " chars");

                totalLines += nLines;
                totalChars += nWords;
                totalChars += nChars;
            }

            // Print the total if more than one source file.
            if (args.length > 1) {
                outputln("**Total: " + totalLines + " lines, " + totalWords + " words, " + totalChars + " chars");
            }
        }
    }
}