// IAdministrator.java -

public interface IAdministrator {

    void administer();

    String getUsage();

    Option[] getOptions();

    String[] getArguments();

    void output();

    void outputln();
}
