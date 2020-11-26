package com.pozharsky.dmitri.exception;

public class IntegerArrayException extends Exception {
    public IntegerArrayException() {
        super();
    }

    public IntegerArrayException(String message) {
        super(message);
    }

    public IntegerArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntegerArrayException(Throwable cause) {
        super(cause);
    }
}
