import java.util.*;

public class OptionFactory {
    aOptions createHelp() {
        return new Help ();
    }
    aOptions createBanner() {
        return new Banner ();
    }
    aOptions createVerbose() {
        return new Verbose ();
    }
    aOptions getOptions(ArrayList<String> Options) {
        for (int i = 0; i < Options.size(); i++) {
            switch(Options.get(i)) {
                case "-h":
                case "-?":
                case "-help": {createHelp(); break;}
                case "-b":
                case "-banner": {createBanner(); break;}
                case "-v":
                case "-verbose": {createVerbose(); break;}
            }
        }
        return null;
    }
}
