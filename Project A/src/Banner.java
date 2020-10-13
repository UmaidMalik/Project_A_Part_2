// Banner.java -

public class Banner implements IBanner {

    private String commandName;
    private String version;
    private String year;
    private String name;

    public Banner(String commandName, String version, String year, String name) {

        this.commandName = commandName;
        this.version = version;
        this.year = year;
        this.name = name;
    }

    public void print() {
            outputln(commandName + " Version " + version + "\n" +
                    "Copyright (C) DIO Inc " + year + ". All Rights Reserved.\n" +
                    "Written by " + name);
    }

    /** Output a message. */
    public void output(String msg) {
        int len = msg.length();
        for (int i = 0; i < len; i++)
            System.out.write(msg.charAt(i));
    }

    /** Output a message ending with an end of line. */
    public void outputln(String msg) {
        output(msg + '\n');
    }
}
