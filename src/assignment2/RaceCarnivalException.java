package assignment2;

/**
 *
 * @author oriengoulding
 */
public class RaceCarnivalException extends RuntimeException {

    /**
     * Default Comment!!!!!!!!!!!!!!!!!!!!!
     * Creates a new instance of
     * <code>RaceCarnivalException</code> without detail message.
     */
    public RaceCarnivalException() {
        super("Race Carnival Exception");
    }

    /**
     * Constructs an instance of
     * <code>RaceCarnivalException</code> with the specified detail message.
     *
     * @param message the detail message.
     */
    public RaceCarnivalException(String message) {
        super(message);
    }
}
