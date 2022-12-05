package org.supermarket.exception;

public class ReflectionErrorException extends RuntimeException {
    public ReflectionErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
