package com.school.demo.exceptions.runtime;

/**
 * @author Nicholas Dietz
 */

public class SaveDemoException extends RuntimeException {

    public SaveDemoException() { super(); }

    public SaveDemoException(String message) {
        super(message);
    }

    public SaveDemoException(String message, Throwable cause) {
        super(message, cause);
    }

}
