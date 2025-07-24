package net.fiv.backend.exception;

public class NoSuchExistsException extends RuntimeException {
    public NoSuchExistsException(String message) {
        super(message);
    }
}
