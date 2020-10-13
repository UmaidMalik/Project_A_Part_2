// TestAdministrator.java -

import java.io.IOException;

public class TestAdministrator {

    private static final Option help = new Option("h", "help", "Print usage of the program.");
    private static final Option verbose = new Option("v", "verbose", "Enable verbose output.");
    private static final Option banner = new Option("b", "banner", "Print application's banner.");

    public static void main(String args[]) throws IOException {

        // Create banner for linecounter
        IBanner lineBanner = new Banner("LineCount", "1.2a", "2020", "Umaid Malik");

        // Create banner for wordcounter
        IBanner wordBanner = new Banner("WordCount", "1.2a", "2020", "Umaid Malik");

        // Create banner for charcounter
        IBanner charBanner = new Banner("CharCount", "1.2a", "2020", "Umaid Malik");

        Option[] optionsArray = {help, verbose, banner};

        IAdministrator admin = new Administrator(args, "Administrator [ -h | -b | -v ]", optionsArray);
    }
}
