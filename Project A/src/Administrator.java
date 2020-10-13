// Administrator.java -

public class Administrator implements IAdministrator{

    private String usage = null;
    private Option options[] = null;
    private String arguments[] = null;



    public Administrator(String arguments[], String usage, Option[] options) {
        this.usage = usage;
        this.options = options;
        this.arguments = arguments;
    }

    public void administer() {
        CounterFactory counterFactory = new CounterFactory();
        if (arguments[0].equalsIgnoreCase("linecount")) {
            Counter lineCounter =  counterFactory.getCounter("linecount");
            if (arguments[2] == null) {

            }
        }
        else if (arguments[0].equalsIgnoreCase("wordcount")) {
            Counter wordCounter =  counterFactory.getCounter("wordcount");
        }
        else if (arguments[0].equalsIgnoreCase("charcount")) {
            Counter charCounter =  counterFactory.getCounter("charcount");
        }
    }

    public String getUsage() {
        return usage;
    }

    public Option[] getOptions() {
        return options;
    }

    public String[] getArguments() {
        return arguments;
    }

    /** Output a message. */
    protected void output(String msg) {
        int len = msg.length();
        for (int i = 0; i < len; i++)
            System.out.write(msg.charAt(i));
    }

    /** Output a message ending with an end of line. */
    protected void outputln(String msg) {
        output(msg + '\n');
    }
    protected void usage(String msg) {
        outputln("Usage: " + msg);
        return;
    }

}
