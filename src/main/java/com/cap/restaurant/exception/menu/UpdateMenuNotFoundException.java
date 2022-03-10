package com.cap.restaurant.exception.menu;

public class UpdateMenuNotFoundException extends Exception{
    public UpdateMenuNotFoundException() {
        super();
    }
    public UpdateMenuNotFoundException(String message) {
        super(message);
    }
    public UpdateMenuNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public UpdateMenuNotFoundException(Throwable cause) {
        super(cause);
    }
    protected UpdateMenuNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
