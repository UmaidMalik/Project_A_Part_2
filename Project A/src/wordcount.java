// wordcount.java - Count words in a sourcefile

import java.io.*;

public class wordcount {

    private static int EOF = -1;
    private static File srcFile = null;
    private static String srcFilename = "<srcFilename>";
    private static boolean isEnabled = false;

    private static void usage(String msg) {
        outputln("Usage: " + msg);
        return;
    }

    private static void wordcount(String msg) {
        outputln("wordcount: " + msg);
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
            wordcount("This program counts the number of words in the source file.");
            return;
        }

        // Banner option for program.
        if (("-banner".equals(args[0])) || ("-b".equals(args[0]))) {
            outputln("wordcount Version 1.2a\n" +
                    "Copyright (C) DIO Inc 2020. All Rights Reserved.\n" +
                    "Written by Umaid Malik");
            return;
        }


        // Check the command-line.
        if (args.length > 2) {
            usage("wordcount <src>");
            return;
        }

        // Check if arguments are valid, if the srcFile exists.
        if (args[0] != null) { // Check <src>
            // Verbose option for program.
            if (("-verbose".equals(args[0])) || ("-v".equals(args[0]))) {
                isEnabled = true;
                srcFilename = args[1];
            }
            else srcFilename = args[0];
            // wordcount("srcFilename = '" + srcFilename + "'");
            srcFile = new File(srcFilename);
            if (!srcFile.canRead()) {
                wordcount("Cannot open srcFile '" + srcFilename + "'");
                return;
            } else {
                wordcount("[OK] srcFilename = '" + srcFilename + "'");
            }

            FileInputStream srcStream = new FileInputStream(srcFile);

            // Execute the word count.
            int c = 0;
            int nWords = 0;
            boolean inWord = false;

            while ((c = srcStream.read()) != EOF) {
                if (!isSpace(c)) {
                    if (!inWord) {
                        inWord = true;
                        ++nWords;
                        if (isEnabled) {
                            output("w");
                        }
                    }
                } else {
                    inWord  = false;
                }
            }

            // Close and flush the file.
            srcStream.close();

            // Print the result.
            outputln(nWords + " words");
        }
    }
}
