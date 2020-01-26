package com.school.demo.exceptions.runtime;

/**
 * @author Nicholas Dietz
 */

public class InvalidIdException extends RuntimeException {

    public InvalidIdException() { super(); }

    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException(String message, Throwable cause) {
        super(message, cause);
    }

}
