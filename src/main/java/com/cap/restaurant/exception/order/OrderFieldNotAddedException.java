package com.cap.restaurant.exception.order;

public class OrderFieldNotAddedException extends Exception{
    public OrderFieldNotAddedException() {
        super();
    }
    public OrderFieldNotAddedException(String message) {
        super(message);
    }
    public OrderFieldNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }
    public OrderFieldNotAddedException(Throwable cause) {
        super(cause);
    }
    protected OrderFieldNotAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
