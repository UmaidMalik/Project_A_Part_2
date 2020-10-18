public class Help extends aOptions {
    Help() {Start();}

    @Override
    public void Start() {
        Stream.outputln("Usage:	command [options] <src> {<src>}" );
        Stream.outputln("\nDo some stuff like count characters, lines, and words");
        Stream.outputln("\nOptions:\n	-h, -?, -help	Display this help" );
        Stream.outputln("	-b, -banner	Display the banner" );
        Stream.outputln("	-v, -verbose	Display ...s " );
    }
}
