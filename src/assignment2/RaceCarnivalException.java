package assignment2;

/**
 * Assignment 2 - CSE1IOO Semester 1, 2014.
 * @author Orien, Dean and Rushabh
 * @version 1.0
 * 
 * RaceCarnivalException class is to handle exceptions from 
 * RaceCarnical constructor in RaceCarnival class.
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
