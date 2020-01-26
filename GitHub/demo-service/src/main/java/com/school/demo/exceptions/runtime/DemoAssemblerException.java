package com.school.demo.exceptions.runtime;

/**
 * @author Nicholas Dietz
 */

public class DemoAssemblerException extends RuntimeException {

    public DemoAssemblerException() { super(); }

    public DemoAssemblerException(String message) {
        super(message);
    }

    public DemoAssemblerException(String message, Throwable cause) {
        super(message, cause);
    }

}
