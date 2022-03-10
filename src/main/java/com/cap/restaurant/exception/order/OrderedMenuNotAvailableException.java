package com.cap.restaurant.exception.order;

public class OrderedMenuNotAvailableException extends Exception {
    public OrderedMenuNotAvailableException() {
        super();
    }
    public OrderedMenuNotAvailableException(String message) {
        super(message);
    }
    public OrderedMenuNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
    public OrderedMenuNotAvailableException(Throwable cause) {
        super(cause);
    }
    protected OrderedMenuNotAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
