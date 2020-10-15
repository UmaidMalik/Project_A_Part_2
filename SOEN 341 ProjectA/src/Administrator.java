import java.util.*;
import java.io.*;

public class Administrator implements iAdministrator {
    static File srcFile = null;

    ArrayList<String> srcFilenames = new ArrayList<String>();
    ArrayList<String> options = new ArrayList<String>();
    String commandName = "";
    static boolean verboseActive = false;

    public static void displayUsage() {
        Stream.outputln("Usage:	command [options] <src> {<src>}" );
        Stream.outputln("\nDo some stuff like count characters, lines, and words");
        Stream.outputln("\nOptions:\n	-h, -?, -help	Display this help" );
        Stream.outputln("	-b, -banner	Display the banner" );
        Stream.outputln("	-v, -verbose	Display ...s " );
    }
    void checkArgsLength(String[] args) {
        if (args.length < 2) {
            System.out.println("Invalid number of arguments");
            displayUsage();
            return;
        }
    }
    void getCommandName(String[] args) {
        commandName = args[0];
    }

    void getOptions(String[] args) {
        for (int n = 1; n < (args.length); ++n) {
            if (args[n] != null) {
                if (args[n].startsWith("-")) {
                    options.add(args[n]);
                }
            }
        }
    }
    void getFileNames(String[] args) {
        for (int n = 1; n < (args.length); ++n) {
            if (args[n] != null) {
                if (!args[n].startsWith("-")) {
                    srcFilenames.add(args[n]);
                }
            }
        }
    }

    Administrator(String[] args) {
        checkArgsLength(args);
        getCommandName(args);
        getOptions(args);
        getFileNames(args);
    }

    void Start() throws IOException {
        OptionFactory OF = new OptionFactory ();
        OF.getOptions(options);

        for (int i = 0; i < srcFilenames.size(); i++) {
            srcFile = new File(srcFilenames.get(i));
            if (!srcFile.canRead()) {
                Stream.outputln("wc: Cannot open srcFile '" + srcFilenames.get(i) + "'");
                System.exit(0);
            }

            FileInputStream srcStream = new FileInputStream(srcFile);
            CounterFactory CF = new CounterFactory ();
            CF.getCounter(commandName, srcFile);
        }
    }

}