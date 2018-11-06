/**
 * This is a placeholder class to test the basic development
 * environment.
 */
public class SourceSample {

    private String aField;

    /**
     * Constructor.
     * @param field The string field
     */
    public SourceSample(final String field) {
        aField = field;
    }

    /**
     * A sample method that returns a string to the private field.
     *
     * @param append The string to append
     * @return The new string
     */
    public String aMethod(final String append) {
        return aField + append;
    }
}
