// CounterFactory.java -

public class CounterFactory {

    public Counter getCounter(String counterChoice) {

        if (counterChoice == null) {
            return null;
        }
        if (counterChoice.equalsIgnoreCase("WORDCOUNT")) {
            return new WordCounter();
        }
        else if (counterChoice.equalsIgnoreCase("LINECOUNT")) {
            return new LineCounter();
        }
        else if (counterChoice.equalsIgnoreCase("CHARCOUNT")) {
            return new CharCounter();
        }
        return null;
    }
}
