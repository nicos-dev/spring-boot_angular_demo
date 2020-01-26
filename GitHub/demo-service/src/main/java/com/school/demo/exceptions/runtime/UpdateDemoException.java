package com.school.demo.exceptions.runtime;

/**
 * @author Nicholas Dietz
 */

public class UpdateDemoException extends RuntimeException {

    public UpdateDemoException() { super(); }

    public UpdateDemoException(String message) {
        super(message);
    }

    public UpdateDemoException(String message, Throwable cause) {
        super(message, cause);
    }

}
