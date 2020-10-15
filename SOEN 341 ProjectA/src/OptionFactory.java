import java.util.*;

public class OptionFactory {
    iOptions createHelp() {
        return new Help();
    }
    iOptions createBanner() {
        return new Banner();
    }
    iOptions createVerbose() {
        return new Verbose();
    }
    iOptions getOptions(ArrayList<String> Options) {
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
