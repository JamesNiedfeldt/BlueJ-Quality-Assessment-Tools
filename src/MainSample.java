/**
 * This is a sample class with a main method to test the development
 * environment.
 */
public final class MainSample {

    /**
     * Checkstyle: Utility classes should not have a public or default
     * constructor.
     */
    private MainSample() {
    }

    /**
     * Sample main method.
     *
     * @param args Console arguments
     */
    public static void main(final String[] args) {
        SourceSample basic = new SourceSample("one");
        String ret = basic.aMethod("_two");

        System.out.println("The string was constructed...");
        System.out.println(ret);
        try {
            System.out.println("Press any key to close");
            System.in.read();
        } catch (Exception e) {

        }
    }
}
