/**
 * The `Main` class serves as the entry point for the application. It creates an instance of the `Viewer` class
 * and invokes the `startApplication` method to start the application.
 */
public class Main {
    /**
     * The main method of the application. It creates a `Viewer` instance and calls the `startApplication` method
     * to initiate the application.
     *
     * @param args Command-line arguments passed to the application.
     */

    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        viewer.startApplication();
    }
}
