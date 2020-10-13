// copy.java - Copy sourceFile to destinationFile

import java.io.*;

public class copy {
    private static int EOF = -1;
    private static File srcFile = null;
    private static File dstFile = null;
    private static String srcFilename = "<srcFilename>";
    private static String dstFilename = "<dstFilename>";
    private static boolean verbose = false;
    private static boolean isEnabled = false;

    private static void usage(String msg) {
        outputln("Usage: " + msg);
        return;
    }

    private static void copy(String msg) {
        outputln("copy: " + msg);
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

    private static void setVerbose(boolean isVerbose) {
        verbose = isVerbose;
    }

    public static void main(String args[]) throws IOException {

        // Help option for program.
        if (("-help".equals(args[0])) || ("-h".equals(args[0])) || ("-?".equals(args[0]))) {
            copy("This program copies the source file and overwrites it to the destination file.");
            return;
        }

        // Banner option for program.
        if (("-banner".equals(args[0])) || ("-b".equals(args[0]))) {
            outputln("Copy Version 1.2a\n" +
                            "Copyright (C) DIO Inc 2020. All Rights Reserved.\n" +
                            "Written by Umaid Malik");
            return;
        }

        // Check the number of arguments.
        // In java, the command name 'copy' is considered as an argument.
        if (args.length != 2 || args.length != 3) {
            usage("copy <src> <dst>");
            return;
        }

        // Check if arguments are valid, if the srcFile exists, and if it can create the dstFile.
        if (args[0] != null) { // Check <src>

            // Verbose option for program.
            if (("-verbose".equals(args[0])) || ("-v".equals(args[0]))) {
                isEnabled = true;
                srcFilename = args[1];
            }
            else srcFilename = args[0];
            copy("srcFilename = '" + srcFilename + "'");
            srcFile = new File(srcFilename);
            if (!srcFile.canRead()) {
                copy("Cannot open srcFile '" + srcFilename + "'");
                return;
            } else {
                copy("[OK] srcFilename = '" + srcFilename + "'");
            }

            if (args[1] != null) { // Check <dst>
                if (("-verbose".equals(args[0])) || ("-v".equals(args[0])))
                    dstFilename = args[2];
                else dstFilename = args[1];
                dstFile = new File(dstFilename);
            } else {
                copy("[OK] dstFilename = '" + dstFilename + "'");
            }

            FileInputStream srcStream = new FileInputStream(srcFile);
            FileOutputStream dstStream = new FileOutputStream(dstFile);

            // Execute the copy.
            int c = 0;

            while ((c = srcStream.read()) != EOF) {
                dstStream.write(c);
                if (isEnabled) {
                    output(".");
                }
            }

            // Close and flush all the files.
            srcStream.close();
            dstStream.close();

            copy("done.");
        }
    }
}