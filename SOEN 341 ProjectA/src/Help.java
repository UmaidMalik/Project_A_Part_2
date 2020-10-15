public class Help implements iOptions{
    Help() {
        Stream.outputln("Usage:	command [options] <src> {<src>}" );
        Stream.outputln("\nDo some stuff like count characters, lines, and words");
        Stream.outputln("\nOptions:\n	-h, -?, -help	Display this help" );
        Stream.outputln("	-b, -banner	Display the banner" );
        Stream.outputln("	-v, -verbose	Display ...s " );
    }
}
