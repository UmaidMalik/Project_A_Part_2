
public final class Stream {

    /** Output a message. */
    public static void output(String msg) {
        int len = msg.length();
        for (int i = 0; i < len; i++)
            System.out.write(msg.charAt(i));
    }

    /** Output a message ending with an end of line. */
    public static void outputln(String msg) {
        output(msg + '\n');
    }

    /** Output a character. */
    public static void output(char c) {
            System.out.write(c);
    }

    /** Output a character ending with an end of line. */
    public static void outputln(char c) {
        output(c);
        outputln(' ');
    }
}
