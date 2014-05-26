package assignment2;

/**
 *
 * @author oriengoulding
 */
public class RaceContestantException extends RuntimeException {

    /**
     * Default comment!!!********
     * Creates a new instance of
     * <code>RaceContestantException</code> without detail message.
     */
    public RaceContestantException() {
        super("Race Contestant Exception");
    }

    /**
     * Constructs an instance of
     * <code>RaceContestantException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public RaceContestantException(String message) {
        super(message);
    }
}
