package com.cap.restaurant.exception.menu;

public class UpdateMenuFieldNotAddedException extends Exception{
    public UpdateMenuFieldNotAddedException() {
        super();
    }
    public UpdateMenuFieldNotAddedException(String message) {
        super(message);
    }
    public UpdateMenuFieldNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }
    public UpdateMenuFieldNotAddedException(Throwable cause) {
        super(cause);
    }
    protected UpdateMenuFieldNotAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
