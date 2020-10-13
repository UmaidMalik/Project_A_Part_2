// charcount.java - Count characters in a sourcefile

import java.io.*;

public class charcount {

    private static int EOF = -1;
    private static File srcFile = null;
    private static String srcFilename = "<srcFilename>";
    private static boolean isEnabled = false;

    private static void usage(String msg) {
        outputln("Usage: " + msg);
        return;
    }

    private static void charcount(String msg) {
        outputln("charcount: " + msg);
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

    public static void main(String args[]) throws IOException {

        // Help option for program.
        if (("-help".equals(args[0])) || ("-h".equals(args[0])) || ("-?".equals(args[0]))) {
            charcount("This program counts the number of characters in the source file.");
            return;
        }

        // Banner option for program.
        if (("-banner".equals(args[0])) || ("-b".equals(args[0]))) {
            outputln("charcount Version 1.2a\n" +
                    "Copyright (C) DIO Inc 2020. All Rights Reserved.\n" +
                    "Written by Umaid Malik");
            return;
        }

        // Check the command-line.
        if ((args.length > 2)) {
            usage("charcount <src>");
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
            // charcount("srcFilename = '" + srcFilename + "'");
            srcFile = new File(srcFilename);
            if (!srcFile.canRead()) {
                charcount("Cannot open srcFile '" + srcFilename + "'");
                return;
            } else {
                charcount("[OK] srcFilename = '" + srcFilename + "'");
            }

            FileInputStream srcStream = new FileInputStream(srcFile);

            // Execute the character count.
            int c = 0;
            int nChars = 0;

            while ((c = srcStream.read()) != EOF) {
                ++nChars;
                if (isEnabled) {
                    output("c");
                }
            }

            // Close and flush the file.
            srcStream.close();

            // Print the result.
            outputln(nChars + " characters");
        }
    }
}
